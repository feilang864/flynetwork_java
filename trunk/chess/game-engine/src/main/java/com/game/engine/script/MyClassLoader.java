/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.engine.script;

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

    private static final Logger log = Logger.getLogger(MyClassLoader.class);
    private String SourceDir;
    private String OutDir;

    /**
     * 初始化一个 classloader 容器
     *
     * @param sourceDir 源文件夹
     */
    public MyClassLoader(String sourceDir) {
        this.SourceDir = sourceDir;
        this.OutDir = this.SourceDir + "out";
        log.info("清理文件夹：" + this.OutDir);
        new java.io.File(this.OutDir).delete();
        if (stringIsEmpty(this.SourceDir) || stringIsEmpty(this.OutDir)) {
            log.error("指定 输入 输出 目录为空");
        }
        Compile();
    }

    final boolean stringIsEmpty(String str) {
        return str == null || str.length() <= 0;
    }

    /**
     * 编译 java 源文件
     *
     * @param fileName 需要编译的文件，如果为空，则编译文件夹包含的全部文件
     * @return 返回是否编译成功
     */
    final boolean Compile() {
        // 获取编译器实例
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        // 获取标准文件管理器实例
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        try {
            List<File> sourceFileList = new ArrayList<>(0);
            File sourceFile = null;
            //得到filePath目录下的所有java源文件
            sourceFile = new File(this.SourceDir);
            getJavaFiles(sourceFile, sourceFileList);
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
        log.info("编译脚本文件");
        return true;
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
        log.info("加载脚本文件 " + path);
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
