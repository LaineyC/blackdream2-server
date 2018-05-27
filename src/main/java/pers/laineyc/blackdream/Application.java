package pers.laineyc.blackdream;

import org.springframework.boot.SpringApplication;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Set;

@pers.laineyc.blackdream.configuration.config.Application
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

/*
	public static void main(String[] args) throws Exception{
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");

		TemplateFileTool fileTool = new TemplateFileTool(new File(""), new File("E:\\a"), null);
		engine.put("tmplTool", fileTool);
		engine.eval(
				"var t = tmplTool.newTmpl(\"a\", \"a\");" +
				"for(var i = 0 ; i < 10 ; i ++){" +
					"var file = tmplTool.newFile(\"dada\", t);" +
					"file.putVar(\"file\", i+\"\");" +
					"file.make();" +
				"}"
		);
	}
*/
/*
	public static void main(String[] args) {
		FileSystem fs = FileSystems.getDefault();
		Set<String> views = fs.supportedFileAttributeViews();
		for (String view : views) {
			System.out.println(view);
		}
		Path path = Paths.get("G:\\sethotkey.log");
		try {
			UserDefinedFileAttributeView aa = Files.getFileAttributeView(path, UserDefinedFileAttributeView.class);
			ByteBuffer aas = ByteBuffer.allocate(aa.size("user.mimetype"));
			aa.read("user.mimetype", aas);
			aas.flip();
			String value = Charset.defaultCharset().decode(aas).toString();
			System.out.println(value);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
}
