package sz.scriptpool;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.log4j.Logger;

/**
 * 脚本加载器
 *
 * @author 失足程序员
 * @Blog http://www.cnblogs.com/ty408/
 * @mail 492794628@qq.com
 * @phone 13882122019
 */
public class ScriptLoader {

    private static final Logger log = Logger.getLogger(ScriptLoader.class);

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        String property = System.getProperty("user.dir");
        ScriptLoader scriptLoader = new ScriptLoader("F:\\javatest\\tttt\\", property + "\\target\\classes\\out\\");
        scriptLoader.Compile();
        scriptLoader.loadClass();
        scriptLoader.loadClass("wzh.Http.NewClass");
        Iterator<IBaseScript> scripts = scriptLoader.getScripts(IBaseScript.class);
        while (scripts.hasNext()) {
            IBaseScript next = scripts.next();
        }
    }

    //源文件夹
    private String sourceDir;
    //输出文件夹
    private String outDir;
    //附加的jar包地址
    private String jarsDir = "F:\\javatest\\mavenproject1\\target\\";

    HashMap<String, HashMap<String, IBaseScript>> scriptInstances = new HashMap<>(0);

    public ScriptLoader(String source) throws Exception {
        this(source, source + "\\out");
    }

    /**
     *
     * @param source
     * @param out
     * @throws java.lang.Exception
     */
    public ScriptLoader(String source, String out) throws Exception {
        if (stringIsNullEmpty(source)) {
            log.error("指定 输入 输出 目录为空");
            throw new Exception("目录为空");
        }
        this.sourceDir = new File(source).getPath();
        this.outDir = new File(out).getPath();
    }

    /**
     *
     * @param <T>
     * @param t
     * @return
     */
    public <T> Iterator<T> getScripts(Class<T> t) {
        return new MyIterator<T>(t.getName());
    }

    //<editor-fold desc="自定义迭代器 public class MyIterator<T> implements Iterator<T>">
    /**
     *
     * @param <T>
     */
    public class MyIterator<T> implements Iterator<T> {

        Iterator<IBaseScript> iterator = null;

        public MyIterator(String key) {
            HashMap<String, IBaseScript> scripts = ScriptLoader.this.scriptInstances.get(key);
            if (scripts != null) {
                iterator = scripts.values().iterator();
            }
        }

        @Override
        public T next() {
            //忽略是否存在键的问题
            if (iterator == null) {
                return null;
            }
            return (T) iterator.next();
        }

        @Override
        public boolean hasNext() {
            //忽略是否存在键的问题
            if (iterator == null) {
                return false;
            }
            return iterator.hasNext();
        }
    }
    //</editor-fold>

    final boolean stringIsNullEmpty(String str) {
        return str == null || str.length() <= 0 || "".equals(str.trim());
    }

    //<editor-fold desc="public final void Compile(String... fileNames)">
    /**
     *
     * @param fileNames 文件列表
     */
    public void Compile(String... fileNames) {
        if (null != fileNames) {

            for (String fileName : fileNames) {
                // 获取编译器实例
                JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
                // 获取标准文件管理器实例
                StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
                try {
                    List<File> sourceFileList = new ArrayList<>(0);
                    //得到filePath目录下的所有java源文件
                    File sourceFile = new File(this.sourceDir + fileName);
                    getFiles(sourceFile, sourceFileList, ".java");
                    // 没有java文件，直接返回
                    if (sourceFileList.isEmpty()) {
                        log.error(this.sourceDir + "目录下查找不到任何java文件");
                        return;
                    }
                    for (File file : sourceFileList) {
                        log.info("编译脚本文件：" + file.getPath());
                    }
                    //创建输出目录，如果不存在的话
                    new java.io.File(this.outDir).mkdirs();
                    // 获取要编译的编译单元
                    Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(sourceFileList);
                    /**
                     * 编译选项，在编译java文件时，编译程序会自动的去寻找java文件引用的其他的java源文件或者class。
                     * -sourcepath选项就是定义java源文件的查找目录，
                     * -classpath选项就是定义class文件的查找目录。
                     */
                    ArrayList<String> options = new ArrayList<>(0);
                    options.add("-g");
                    options.add("-encoding");
                    options.add("UTF-8");
                    options.add("-sourcepath");
                    options.add(this.sourceDir); //指定文件目录
                    options.add("-d");
                    options.add(this.outDir); //指定输出目录

                    File jarFile = new File(this.jarsDir);
                    ArrayList<File> jarsList = new ArrayList<>();
                    getFiles(this.jarsDir, jarsList, ".jar");
                    String jarString = "";
                    for (File jar : jarsList) {
                        jarString += jar.getPath() + ";";
                    }
                    if (!stringIsNullEmpty(jarString)) {
                        options.add("-classpath");
                        options.add(jarString);//指定附加的jar包
                    }
                    JavaCompiler.CompilationTask compilationTask = compiler.getTask(null, fileManager, null, options, null, compilationUnits);
                    // 运行编译任务
                    compilationTask.call();

                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        fileManager.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
    //</editor-fold>

    //<editor-fold desc="public final void Compile()">
    /**
     * 编译 java 源文件
     */
    public void Compile() {
        MyFileMonitor.deleteDirectory(this.outDir);
        this.Compile("");
    }
    //</editor-fold>

    //<editor-fold desc="查找该目录下的所有的 java 文件 public void getFiles(File sourceFile, List<File> sourceFileList, String endName)">
    /**
     *
     * @param source
     * @param sourceFileList
     * @param endName
     */
    public void getFiles(String source, List<File> sourceFileList, final String endName) {
        File sFile = new File(source);
        getFiles(sFile, sourceFileList, endName);
    }

    /**
     * 查找该目录下的所有的 java 文件
     *
     * @param sourceFile ,单文件或者目录
     * @param sourceFileList 返回目录所包含的所有文件包括子目录
     * @param endName
     */
    public void getFiles(File sourceFile, List<File> sourceFileList, final String endName) {
        if (sourceFile.exists() && sourceFileList != null) {// 文件或者目录必须存在
            if (sourceFile.isDirectory()) {// 若file对象为目录
                // 得到该目录下以.java结尾的文件或者目录
                File[] childrenFiles = sourceFile.listFiles(new FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                        if (pathname.isDirectory()) {
                            return true;
                        } else {
                            String name = pathname.getName();
                            return name.endsWith(endName);
                        }
                    }
                });
                // 递归调用
                for (File childFile : childrenFiles) {
                    getFiles(childFile, sourceFileList, endName);
                }
            } else {// 若file对象为文件
                sourceFileList.add(sourceFile);
            }
        }
    }
    //</editor-fold>

    //<editor-fold desc="加载脚本 public void loadClass() throws Exception">
    public void loadClass() throws Exception {
        List<File> sourceFileList = new ArrayList<>(0);
        //得到filePath目录下的所有java源文件
        getFiles(this.outDir, sourceFileList, ".class");
        String[] fileNames = new String[sourceFileList.size()];
        for (int i = 0; i < sourceFileList.size(); i++) {
            fileNames[i] = sourceFileList.get(i).getPath();
        }
        loadClass(fileNames);
    }

    public void loadClass(String... names) {
        try {
            ScriptClassLoader loader = new ScriptClassLoader();
            for (String name : names) {
                name = name.replace(outDir + "\\", "").replace(".class", "").replace(File.separatorChar, '.');
                loader.loadClass(name);
            }
        } catch (ClassNotFoundException e) {
        }
    }
    //</editor-fold>

    //<editor-fold desc="自定义文件加载器 class ScriptClassLoader extends ClassLoader">
    class ScriptClassLoader extends ClassLoader {

        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {

            return super.loadClass(name, true);

        }

        @Override
        protected Class<?> findClass(String name) {
            byte[] classData = getClassData(name);
            if (classData == null) {
                log.error("自定义文件不存在：" + name);
            } else {
                try {
                    Class<?> defineClass = defineClass(name, classData, 0, classData.length);
                    Class<?>[] interfaces = defineClass.getInterfaces();
                    //读取加载的类的接口情况，是否实现了最基本的借口，如果不是，表示加载的本身自主类
                    IBaseScript newInstance = (IBaseScript) defineClass.newInstance();
                    for (Class<?> aInterface : interfaces) {
                        if (IBaseScript.class.isAssignableFrom(aInterface)) {
                            if (!scriptInstances.containsKey(aInterface.getName())) {
                                scriptInstances.put(aInterface.getName(), new HashMap<String, IBaseScript>(0));
                            }
                            scriptInstances.get(aInterface.getName()).put(defineClass.getName(), newInstance);
                        }
                    }
                    return defineClass;
                } catch (InstantiationException | IllegalAccessException ex) {
                    ex.printStackTrace();
                }
            }
            return null;
        }

        private byte[] getClassData(String className) {
            String path = classNameToPath(className);
            log.info("加载脚本文件：" + path);
            try {
                File file = new File(path);
                if (file.exists()) {
                    InputStream ins = new FileInputStream(path);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int bufferSize = 4096;
                    byte[] buffer = new byte[bufferSize];
                    int bytesNumRead = 0;
                    while ((bytesNumRead = ins.read(buffer)) != -1) {
                        baos.write(buffer, 0, bytesNumRead);
                    }
                    return baos.toByteArray();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        private String classNameToPath(String className) {
            //return className;
            return new File(outDir + File.separatorChar + className.replace('.', File.separatorChar) + ".class").getPath();
        }
    }
    //</editor-fold>
}
