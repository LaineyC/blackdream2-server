package pers.laineyc.blackdream.foundation.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.laineyc.blackdream.configuration.constant.SystemConstant;
import pers.laineyc.blackdream.configuration.tool.PathTool;
import pers.laineyc.blackdream.foundation.service.parameter.*;
import java.io.File;

/**
 * @author LaineyC
 */
@Component
public class StorageFileServiceTool {

    @Autowired
    private PathTool pathTool;

    public String getMetaPath(String fileId){
        return pathTool.getRootPath() + File.separator + SystemConstant.RESOURCE_PATH_NAME + pathTool.splitIdAsPath(fileId) + fileId + "." + SystemConstant.RESOURCE_META_SUFFIX_NAME;
    }

    public String getDataPath(String fileId){
        return pathTool.getRootPath() + File.separator + SystemConstant.RESOURCE_PATH_NAME + pathTool.splitIdAsPath(fileId) + fileId + "." + SystemConstant.RESOURCE_DATA_SUFFIX_NAME;
    }

    public void createValidate(StorageFileCreateParameter parameter) {

    }

    public void deleteValidate(StorageFileDeleteParameter parameter) {

    }

    public void updateValidate(StorageFileUpdateParameter parameter) {

    }

    public void getValidate(StorageFileGetParameter parameter) {

    }

    public void getMetaValidate(StorageFileGetMetaParameter parameter) {

    }

    public void getInputStreamValidate(StorageFileGetInputStreamParameter parameter) {

    }

}
