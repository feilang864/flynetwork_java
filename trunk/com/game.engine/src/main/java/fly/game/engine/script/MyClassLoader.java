/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.game.engine.script;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import org.apache.log4j.Logger;

/**
 * class loader 容器 extends ClassLoader
 *
 * @author Administrator
 */
public class MyClassLoader extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        while (true) {
            MyClassLoader fscl = new MyClassLoader("D:\\222222\\");
            Class<?> loadJava = fscl.loadJava("", "fly.loadtest.ScriptMain");
            if (loadJava != null) {
                loadJava.newInstance();
            }
            System.in.read();
        }
    }

    private Logger log;
    private String SourceDir;
    private String OutDir;

    /**
     * 初始化一个 classloader 容器
     *
     * @param sourceDir 源文件夹
     */
    public MyClassLoader(String sourceDir) {
        this.SourceDir = sourceDir;
        this.OutDir = sourceDir + "\\out";
        this.log = Logger.getLogger(MyClassLoader.class);
        log.debug("初始化 Class Loader 容器 Source：" + this.SourceDir + " out：" + this.OutDir + " 完成");
    }

    boolean StringIsEmpty(String str) {
        return str == null || str.length() <= 0;
    }

    /**
     * 编译 java 源文件
     *
     * @param fileName 需要编译的文件，如果为空，则编译文件夹包含的全部文件
     * @return 返回是否编译成功
     */
    public boolean Compile(String fileName) {

        // 获取编译器实例
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        // 获取标准文件管理器实例
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        try {
            if (StringIsEmpty(this.SourceDir) || StringIsEmpty(this.OutDir)) {
                log.error("指定 输入 输出 目录为空");
                return false;
            }

            List<File> sourceFileList = new ArrayList<File>();
            File sourceFile = null;
            //得到filePath目录下的所有java源文件
            if (StringIsEmpty(fileName)) {
                sourceFile = new File(this.SourceDir);
                getJavaFiles(sourceFile, sourceFileList);
            } else {
                sourceFile = new File(this.SourceDir + fileName);
                sourceFileList.add(sourceFile);
            }
            // 没有java文件，直接返回
            if (sourceFileList.isEmpty()) {
                log.error(this.SourceDir + "目录下查找不到任何java文件");
                return false;
            }
            //创建输出目录，如果不存在的话
            new java.io.File(this.OutDir).mkdirs();

            // 获取要编译的编译单元
            Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(sourceFileList);
            /**
             * 编译选项，在编译java文件时，编译程序会自动的去寻找java文件引用的其他的java源文件或者class。
             * -sourcepath选项就是定义java源文件的查找目录， -classpath选项就是定义class文件的查找目录。
             */
            Iterable<String> options = Arrays.asList("-d", this.OutDir, "-sourcepath", this.SourceDir);
            JavaCompiler.CompilationTask compilationTask = compiler.getTask(null, fileManager, null, options, null, compilationUnits);

            // 运行编译任务
            boolean ret = compilationTask.call();
            if (ret) {
                log.error("编译：" + this.SourceDir + fileName + " 的文件成功");
            } else {
                log.error("编译：" + this.SourceDir + fileName + " 的文件失败");
            }
            return ret;
        } catch (Exception ex) {
            log.error("编译：" + this.SourceDir + fileName + " 的文件失败 " + ex);
        } finally {
            try {
                fileManager.close();
            } catch (IOException ex) {
                log.error("编译：" + this.SourceDir + fileName + " 的文件失败 " + ex);
            }
        }
        log.error("编译：" + this.SourceDir + fileName + " 的文件失败");
        return false;
    }

    /**
     * 查找该目录下的所有的 java 文件
     *
     * @param sourceFile ,单文件或者目录
     * @param sourceFileList 返回目录所包含的所有文件包括子目录
     * @throws Exception
     */
    public void getJavaFiles(File sourceFile, List<File> sourceFileList) throws Exception {
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
                            return name.endsWith(".java");
                        }
                    }
                });
                // 递归调用
                for (File childFile : childrenFiles) {
                    getJavaFiles(childFile, sourceFileList);
                }
            } else {// 若file对象为文件
                sourceFileList.add(sourceFile);
            }
        }
    }

    /**
     * 加载 java 文件，在加载之前先编译 java 文件为 class 文件然后加载 class 文件
     *
     * @param javaFileName 需要编译的文件，如果为空，编译文件夹，
     * @param classFileName 需要加载的类完全限定名称,不能为空
     * @return 返回加载的源需要 newInstance() 得到实例
     * @throws ClassNotFoundException
     * @throws Exception
     */
    public Class<?> loadJava(String javaFileName, String classFileName) throws ClassNotFoundException, Exception {
        if (Compile(javaFileName)) {
            return super.loadClass(classFileName); //To change body of generated methods, choose Tools | Templates.
        } else {
            return null;
        }
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> tClass = super.loadClass(name);
        if (tClass == null) {
            log.debug("加载 " + this.OutDir + "" + name + " 失败");
        } else {
            log.debug("加载 " + this.OutDir + "" + name + " 成功");
        }
        return tClass;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] getClassData(String className) {
        String path = classNameToPath(className);
        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String classNameToPath(String className) {
        return this.OutDir + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
    }

}
