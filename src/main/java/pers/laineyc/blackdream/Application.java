package pers.laineyc.blackdream;

import org.springframework.boot.SpringApplication;

@pers.laineyc.blackdream.configuration.config.Application
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

/*
	public static void main(String[] args) throws Exception{
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("nashorn");
		List<TemplateFile> templateFileList = new ArrayList<>();

		TemplateFile templateFile = new TemplateFile();
		templateFile.setCode("t1");
		templateFile.setEngineType(1);
		templateFileList.add(templateFile);


		TemplateFileScriptTool fileTool = new TemplateFileScriptTool(null, null, templateFileList);
		engine.put("$util", fileTool);
		engine.eval(
				"var t = $util.newTmpl(\"t1\");" +
						"for(var i = 0 ; i < 10 ; i ++){" +
						"var file = $util.newFile(\"d/a/da\", t, {a:1});" +
						//"file.putVar(\"file\", i+\"\");" +
						"}"
		);
		List<String> result = fileTool.makeTest();
		System.out.print(result);
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
