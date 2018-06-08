package pers.laineyc.blackdream.autodoc.action.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.laineyc.blackdream.configuration.config.AuthSecurity;
import pers.laineyc.blackdream.framework.util.BeanUtils;
import pers.laineyc.blackdream.framework.controller.BaseWebController;
import pers.laineyc.blackdream.autodoc.service.parameter.GeneratorDocMakeParameter;
import pers.laineyc.blackdream.autodoc.action.web.request.GeneratorDocMakeWebRequest;
import pers.laineyc.blackdream.autodoc.action.web.response.GeneratorDocMakeWebResponse;
import pers.laineyc.blackdream.autodoc.action.web.vo.GeneratorDocMakeWebVo;
import pers.laineyc.blackdream.autodoc.service.domain.GeneratorDoc;
import pers.laineyc.blackdream.autodoc.service.GeneratorDocService;

/**
 * 生成器文档Controller
 * @author LaineyC
 */
@Api(tags = "GeneratorDoc", description = "生成器文档接口")
@Controller
public class GeneratorDocWebController extends BaseWebController {

    @Autowired
    private GeneratorDocService generatorDocService;
    
    public GeneratorDocWebController() {

    }

    @AuthSecurity
    @ApiOperation(value = "生成器文档生成")
    @PostMapping(value = "/generatorDoc/make")
    public @ResponseBody GeneratorDocMakeWebResponse make(@RequestBody GeneratorDocMakeWebRequest request) {
        GeneratorDocMakeParameter parameter = new GeneratorDocMakeParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorDoc generatorDoc = generatorDocService.make(parameter);

        GeneratorDocMakeWebVo generatorDocMakeWebVo = new GeneratorDocMakeWebVo();
        BeanUtils.copyProperties(generatorDoc, generatorDocMakeWebVo);

        return new GeneratorDocMakeWebResponse(generatorDocMakeWebVo);
    }
    
}
