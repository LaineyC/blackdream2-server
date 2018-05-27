package pers.laineyc.blackdream.configuration.tool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pers.laineyc.blackdream.configuration.constant.SystemConstant;
import pers.laineyc.blackdream.foundation.service.parameter.*;

import java.io.File;

/**
 * @author LaineyC
 */
@Component
public class PathTool {

    private static final String PATH_SEPARATOR = File.separator;

    @Value(SystemConstant.ROOT_PATH_KEY)
    private String rootPath;

    public String splitIdAsPath(Long id){
        String path = PATH_SEPARATOR;
        if(id == null){
            return path;
        }

        String idString = id.toString();
        char[] charArray = idString.toCharArray();
        for(int i = 0 ; i < charArray.length ; i++){
            path += charArray[i];
            if((i + 1) % 4 == 0){
                path += PATH_SEPARATOR;
            }
        }

        if(!path.endsWith(PATH_SEPARATOR)){
            path += PATH_SEPARATOR;
        }

        return path;
    }

    public String getRootPath(){
        return rootPath;
    }

}
