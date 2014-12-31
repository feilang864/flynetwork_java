package fly.com.object_engine.struct;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 *
 * @goal genhandler
 * @phase compile
 * @requiresProject true
 */
public class CreateHandler extends AbstractMojo {

    private static final String[] DEFAULT_INCLUDES = new String[]{"Message.java"};
    private static final String packagePatten = "package ";
    private static final String messagePatten = "(.*)public static final class [Req|GL|LG|DL|LD|DG|GD](.*)Message extends(.*)";

    public static void makeDir(File dir) {
        if (!dir.getParentFile().exists()) {
            makeDir(dir.getParentFile());
        }
        dir.mkdir();
    }

    public static boolean createFile(File file) throws IOException {
        if (!file.exists()) {
            makeDir(file.getParentFile());
        }
        return file.createNewFile();
    }
    /**
     * 项目根目录
     *
     * @parameter expression="${project.basedir}"
     * @required
     * @readonly
     */
    private File basedir = new File(System.getProperty("user.dir"));
    /**
     * 项目资源目录
     *
     * @parameter expression="${project.build.sourceDirectory}"
     * @required
     * @readonly
     */
    private File sourceDirectory;
    /**
     * 项目测试资源目录
     *
     * @parameter expression="${project.build.testSourceDirectory}"
     * @required
     * @readonly
     */
    private File testSourceDirectory;
    /**
     * 项目资源
     *
     * @parameter expression="${project.build.resources}"
     * @required
     * @readonly
     */
    private List<Resource> resources;
    /**
     * 项目测试资源
     *
     * @parameter expression="${project.build.testResources}"
     * @required
     * @readonly
     */
    private List<Resource> testResources;
    /**
     * 额外参数，由于没有配置expression，所以只能过通过pom.xml plugin->configuration配置获得
     *
     * @parameter
     */
    private String[] includes;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        if (includes == null) {
            includes = DEFAULT_INCLUDES;
        }

        List<File> rfFiles = new ArrayList<>();
        getRfFiles(rfFiles, basedir);
        for (File file : rfFiles) {
            try {
                getLog().info(getFilecounts(file).toString());
            } catch (FileNotFoundException ex) {
                getLog().error("找不到文件1", ex);
            } catch (IOException ex) {
                getLog().error("找不到文件2", ex);
            }
        }
    }

    private void getRfFiles(List<File> files, File file) {
        if (!file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (File f : listFiles) {
                getRfFiles(files, f);
            }
        } else {
            for (String include : includes) {
                if (file.getName().endsWith(include)) {
                    files.add(file);
                    break;
                }
            }

        }
    }

    private FileCountsInfo getFilecounts(File file) throws FileNotFoundException, IOException {
        String packageName = "";
        List<String> classNames = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        int count = 0;
        try {
            while (br.ready()) {
                String readLine = br.readLine();
                if (packageName.equals("") && readLine.startsWith(packagePatten)) {
                    packageName = readLine.replace(packagePatten, "").replace(";", "");// + ".handler";
                    getLog().info("packageName:: " + packageName);
                } else if (readLine.matches(messagePatten)) {
                    int indexOf0 = readLine.indexOf("class ") + 6;
                    int indexOf1 = readLine.indexOf(" extends");
                    String className = readLine.substring(indexOf0, indexOf1);
                    if (className.startsWith("Req") || className.startsWith("LG") || className.startsWith("GL") || className.startsWith("LD")) {
                        classNames.add(className);
                    }
                }
                count++;
            }
        } catch (IOException e) {
            getLog().error("getFilecounts", e);
        } finally {
            br.close();
        }

        if (!classNames.isEmpty()) {
            String protoName = file.getName().replace(".java", "");
            String module = protoName;
            module = module.replace("Message", "");
            module = module.toLowerCase();

            for (String className : classNames) {
                String fileName = className.replace("Message", "Handler.java"); // UserVersionMessageHandler.java
                // String filePath = sourceDirectory + "\\" + packageName.replace(".", "\\") + "\\handler\\" + module+ "\\"+ fileName; // E:\game\game\game-plugin\src\main\java\com\game\proto\handler\UserVersionMessageHandler.java
                String filePath = basedir + "\\src\\main\\handlers" + "\\" + packageName.replace(".", "\\") + "\\handler\\" + module + "\\" + fileName;
                getLog().info("fileName " + fileName);
                getLog().info("filePath " + filePath);
                File newFile = new File(filePath);
                if (!newFile.exists()) {
                    createFile(newFile);
                    getLog().info("创建成功");

                    {
                        // 写入类容
                        // String packageName ;//"com.game.loginsr.proto"
                        // String protoName ;//"LoginMessage"
                        String reqClassName = className.replace("Message", "");//"ReqTokenLoginMessage"
                        String resClassName = null;//"ResTokenLoginMessage"
                        if (className.startsWith("Req")) {
                            resClassName = className;
                            resClassName = resClassName.replaceFirst("Req", "Res");
                        } else if (className.startsWith("LG")) {
                            resClassName = className;
                            resClassName = resClassName.replaceFirst("LG", "GL");
                        } else if (className.startsWith("GL")) {
                            resClassName = className;
                            resClassName = resClassName.replaceFirst("GL", "LG");
                        } else if (className.startsWith("LD")) {
                            resClassName = className;
                            resClassName = resClassName.replaceFirst("LD", "DL");
                        } else if (className.startsWith("DL")) {
                            resClassName = className;
                            resClassName = resClassName.replaceFirst("DL", "LD");
                        } else if (className.startsWith("GD")) {
                            resClassName = className;
                            resClassName = resClassName.replaceFirst("GD", "DG");
                        } else if (className.startsWith("DG")) {
                            resClassName = className;
                            resClassName = resClassName.replaceFirst("DG", "GD");
                        }
                        getLog().info("================");
                        getLog().info(newFile.toString());
                        getLog().info(packageName); // com.game.loginsr.proto
                        getLog().info(protoName); // LoginMessage
                        getLog().info(reqClassName); // ReqCreateSelectUserCmd
                        getLog().info(resClassName); // ResCreateSelectUserCmd
                        getLog().info("================");
                        genCodeTemplate(newFile, packageName, protoName, reqClassName, resClassName, module);
                    }
                } else {
                    getLog().info("已经存在");
                }
            }
        }
        return new FileCountsInfo(file, count);
    }

    /**
     *
     * @param packageName "com.game.loginsr.proto"
     * @param protoName "LoginMessage"
     * @param reqClassName "ReqTokenLogin"
     * @param resClassName "ResTokenLogin"
     * @param module "login"
     */
    private void genCodeTemplate(File file, String packageName, String protoName, String reqClassName, String resClassName, String module) {
        String importProto = packageName + "." + protoName;
        String reqMessageName = protoName + "." + reqClassName;
        String resMessageName = protoName + "." + resClassName;

        StringBuilder code = new StringBuilder();
        code.append("package ").append(packageName).append(".handler.").append(module).append(";\n\n");
        code.append("import com.game.engine.io.commmand.TcpHandler;\n");
        code.append("import ").append(importProto).append(";\n");
        code.append("import org.slf4j.Logger;\n");
        code.append("import org.slf4j.LoggerFactory;\n\n");
        code.append("/**\n");
        code.append(" *\n");
        code.append(" * @author Vicky\n");
        code.append(" * @mail eclipser@163.com\n");
        code.append(" * @phone 13618074943\n");
        code.append(" */\n");
        code.append("public final class ").append(reqClassName).append("Handler extends TcpHandler {\n\n");
        code.append("    private static final Logger log = LoggerFactory.getLogger(").append(reqClassName).append("Handler.class);\n\n");
        code.append("    @Override\n");
        code.append("    public void run() {\n");
        code.append("        // TODO 处理").append(reqMessageName).append("消息\n");
        code.append("        ").append(reqMessageName).append("Message reqMessage = (").append(reqMessageName).append("Message) getMessage();\n");
        if (resClassName != null) {
            code.append("        ").append(resMessageName).append(".Builder builder4Res = ").append(resMessageName).append(".newBuilder();\n");
        }
        code.append("    }\n");
        code.append("}\n");

        if (file.canWrite()) {
            try {
                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8");
                osw.write(code.toString());
                osw.flush();
            } catch (IOException ex) {
                getLog().error("写入代码模版到" + file.getName() + "失败!", ex);
            }
        }
    }

}

class FileCountsInfo {

    private File file;
    private int count;

    public FileCountsInfo(File file, int count) {
        this.file = file;
        this.count = count;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return file.toString() + " count: " + count;
    }
}
