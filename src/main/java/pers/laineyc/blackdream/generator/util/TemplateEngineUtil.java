package pers.laineyc.blackdream.generator.util;

import freemarker.template.Configuration;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

/**
 * @author LaineyC
 */
public class TemplateEngineUtil {

    public TemplateEngineUtil(){

    }

    public void processFreemarkerTemplate(File loadPath, File templateFile, File outFile, Map<String, Object> varMap){
        try {
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_26);
            configuration.setDirectoryForTemplateLoading(loadPath.getAbsoluteFile());
            configuration.setDefaultEncoding("UTF-8");
            configuration.setOutputEncoding("UTF-8");
            freemarker.template.Template template = configuration.getTemplate(templateFile.getPath());

            StringWriter writer = new StringWriter();
            template.process(varMap, writer);

            FileOutputStream fos = new FileOutputStream(outFile.getAbsolutePath());
            PrintStream ps = new PrintStream(fos, true, "UTF-8");
            ps.print(writer.toString());
            ps.flush();
            ps.close();
            fos.close();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void processVelocityTemplate(File loadPath, File templateFile, File outFile, Map<String, Object> varMap){
        try {
            Properties properties = new Properties();
            properties.setProperty("resource.loader", "file");
            properties.setProperty("file.resource.loader.path", loadPath.getAbsolutePath());
            properties.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
            properties.setProperty("input.encoding", "UTF-8");
            properties.put("output.encoding", "UTF-8");

            VelocityEngine velocityEngine = new VelocityEngine();
            velocityEngine.init(properties);
            Template template = velocityEngine.getTemplate(templateFile.getPath(), "UTF-8");
            VelocityContext context = new VelocityContext();
            varMap.forEach(context::put);
            StringWriter writer = new StringWriter();
            template.merge(context, writer);

            FileOutputStream fos = new FileOutputStream(outFile.getAbsolutePath());
            PrintStream ps = new PrintStream(fos, true, "UTF-8");
            ps.print(writer.toString());
            ps.flush();
            ps.close();
            fos.close();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}