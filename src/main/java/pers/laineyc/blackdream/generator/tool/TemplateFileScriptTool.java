package pers.laineyc.blackdream.generator.tool;

import org.springframework.util.StringUtils;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TemplateFileTool
 *
 * @author LaineyC
 */
public class TemplateFileScriptTool {

    private File templateRootPath;

    private File outputRootPath;

    private Map<String, $Template> templateFileCache = new HashMap<>();

    public TemplateFileScriptTool(File templateRootPath, File outputRootPath, List<$Template> templateFileList){
        this.templateRootPath = templateRootPath;
        this.outputRootPath = outputRootPath;
        if(templateFileList != null){
            templateFileList.forEach(templateFile -> templateFileCache.put(templateFile.code, templateFile));
        }
    }

    public $File newFile(String name, String templateCode){
        return newFile(name, new $Template(templateCode));
    }

    public $File newFile(String name, $Template template){
        if(!StringUtils.hasText(name)){
            throw new BusinessException("定义File时，缺少name参数");
        }

        if(template == null){
            throw new BusinessException("定义File时，缺少template参数");
        }

        if(!templateFileCache.containsKey(template.code)){
            throw new BusinessException("定义File时，template不存在");
        }

        return new $File(name, templateFileCache.get(template.code), templateRootPath, outputRootPath);
    }

    public $Var newVar(String name, Object value){
        if(!StringUtils.hasText(name)){
            throw new BusinessException("定义Var时，缺少name参数");
        }

        if(value == null){
            throw new BusinessException("定义Var时，缺少value参数");
        }

        return new $Var(name, value);
    }

    public $Template newTmpl(String code){
        if(!StringUtils.hasText(code)){
            throw new BusinessException("定义Tmpl时，缺少id参数");
        }

        return new $Template(code);
    }

    public $Directory newDir(String name){
        if(!StringUtils.hasText(name)){
            throw new BusinessException("定义Dir时，缺少name参数");
        }

        return new $Directory(name, outputRootPath);
    }

    public static class $Var{

        private String name;

        private Object value;

        public $Var(String name, Object value){
            this.name = name;
            this.value = value;
        }
    }

    public static class $Template{

        private String code;

        private Integer engineType;

        public $Template(String code, Integer engineType){
            this.code = code;
            this.engineType = engineType;
        }

        public $Template(String code){
            this.code = code;
        }
    }

    public static class $File{

        private File templateRootPath;

        private File outputRootPath;

        private $Template template;

        private String name;

        private List<$Var> varList = new ArrayList<>();

        public $File(String name, $Template template, File templateRootPath, File outputRootPath){
            this.name = name;
            this.template = template;
            this.templateRootPath = templateRootPath;
            this.outputRootPath = outputRootPath;
        }

        public void putVar($Var var){
            if(var == null){
                throw new BusinessException("添加Var时，缺少var参数");
            }

            varList.add(var);
        }

        public void putVar(String name, Object value){
            if(!StringUtils.hasText(name)){
                throw new BusinessException("添加Var时，缺少name参数");
            }

            if(value == null){
                throw new BusinessException("添加Var时，缺少value参数");
            }
            varList.add(new $Var(name, value));
        }

        public void make(){
            for($Var var : varList){
                System.out.println(var.name + "," + var.value);
            }
            System.out.println(templateRootPath + name);
        }
    }

    public static class $Directory{

        private File outputRootPath;

        private String name;

        public $Directory(String name, File outputRootPath){
            this.outputRootPath = outputRootPath;
            this.name = name;
        }

        public void make(){
            String path = outputRootPath.getAbsolutePath() + File.separator + name.replace(File.separator, "/");
            File pathFile = new File(path);
            if(!pathFile.exists()) {
                pathFile.mkdirs();
            }
        }
    }

}
