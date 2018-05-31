package pers.laineyc.blackdream.foundation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pers.laineyc.blackdream.foundation.service.StorageFileService;
import pers.laineyc.blackdream.foundation.service.domain.StorageFile;
import pers.laineyc.blackdream.foundation.service.parameter.*;
import pers.laineyc.blackdream.foundation.tool.StorageFileServiceTool;
import pers.laineyc.blackdream.framework.model.Auth;
import pers.laineyc.blackdream.framework.service.BaseService;
import pers.laineyc.blackdream.framework.util.FileUtil;
import pers.laineyc.blackdream.framework.util.JsonUtil;
import pers.laineyc.blackdream.usercenter.service.domain.User;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * 存储文件ServiceImpl
 * @author LaineyC
 */
@Primary
@Service
public class StorageFileServiceImpl extends BaseService implements StorageFileService {

    @Autowired
    private StorageFileServiceTool storageFileServiceTool;

    public StorageFileServiceImpl() {

	}

    @Override
    public StorageFile create(StorageFileCreateParameter parameter) {
        storageFileServiceTool.createValidate(parameter);

        String id = parameter.getId();

        Path metaPath = Paths.get(storageFileServiceTool.getMetaPath(id));
        Path parentPath = metaPath.getParent();
        FileUtil.create(parentPath);

        StorageFile storageFile = new StorageFile();
        storageFile.setId(id);

        String userId = parameter.getUserId();
        if(userId != null){
            User user = new User();
            user.setId(userId);
            storageFile.setUser(user);
        }

        String name = parameter.getName();
        storageFile.setName(name);

        String extension = parameter.getExtension();
        storageFile.setExtension(extension);

        Long size = parameter.getSize();
        storageFile.setSize(size);

        String contentType = parameter.getContentType();
        storageFile.setContentType(contentType);

        Date createTime = parameter.getCreateTime();
        storageFile.setCreateTime(createTime);

        Date updateTime = parameter.getUpdateTime();
        storageFile.setUpdateTime(updateTime);

        String metaJson = JsonUtil.toJson(storageFile);
        FileUtil.writeString(metaPath, metaJson);

        InputStream inputStream = parameter.getInputStream();
        Path dataPath = Paths.get(storageFileServiceTool.getDataPath(id));
        FileUtil.write(dataPath, inputStream);

        storageFile = new StorageFile();
        storageFile.setId(id);

        return storageFile;
    }

    @Override
    public StorageFile delete(StorageFileDeleteParameter parameter) {
        storageFileServiceTool.deleteValidate(parameter);
        Auth auth = parameter.getAuth();

        String id = parameter.getId();

        Path metaPath = Paths.get(storageFileServiceTool.getMetaPath(id));

        Path dataPath = Paths.get(storageFileServiceTool.getDataPath(id));

        FileUtil.delete(metaPath);

        FileUtil.delete(dataPath);

        StorageFile storageFile = new StorageFile();

        return storageFile;
    }

    @Override
    public StorageFile update(StorageFileUpdateParameter parameter) {
        storageFileServiceTool.updateValidate(parameter);

        Auth auth = parameter.getAuth();

        String id = parameter.getId();

        Path metaPath = Paths.get(storageFileServiceTool.getMetaPath(id));

        StorageFileGetMetaParameter storageFileGetMetaParameter = new StorageFileGetMetaParameter();
        storageFileGetMetaParameter.setAuth(auth);
        storageFileGetMetaParameter.setId(id);

        StorageFile storageFile = getMeta(storageFileGetMetaParameter);

        String userId = parameter.getUserId();
        if(userId != null){
            User user = new User();
            user.setId(userId);
            storageFile.setUser(user);
        }

        String name = parameter.getName();
        if(name != null){
            storageFile.setName(name);
        }

        String extension = parameter.getExtension();
        if(extension != null){
            storageFile.setExtension(extension);
        }

        Long size = parameter.getSize();
        if(size != null){
            storageFile.setSize(size);
        }

        String contentType = parameter.getContentType();
        if(contentType != null){
            storageFile.setContentType(contentType);
        }

        Date createTime = parameter.getCreateTime();
        if(createTime != null){
            storageFile.setCreateTime(createTime);
        }

        Date updateTime = parameter.getUpdateTime();
        if(updateTime != null){
            storageFile.setUpdateTime(updateTime);
        }

        String metaJson = JsonUtil.toJson(storageFile);
        FileUtil.writeString(metaPath, metaJson);

        InputStream inputStream =  parameter.getInputStream();

        Path dataPath = Paths.get(storageFileServiceTool.getDataPath(id));
        if(inputStream != null){
            FileUtil.write(dataPath, inputStream);
        }

        storageFile = new StorageFile();
        storageFile.setId(id);

        return storageFile;
    }

    @Override
    public StorageFile get(StorageFileGetParameter parameter) {
        storageFileServiceTool.getValidate(parameter);

        Auth auth = parameter.getAuth();

        String id = parameter.getId();

        StorageFileGetMetaParameter storageFileGetMetaParameter = new StorageFileGetMetaParameter();
        storageFileGetMetaParameter.setAuth(auth);
        storageFileGetMetaParameter.setId(id);
        StorageFile storageFile = this.getMeta(storageFileGetMetaParameter);

        StorageFileGetInputStreamParameter storageFileGetDataParameter = new StorageFileGetInputStreamParameter();
        storageFileGetDataParameter.setAuth(auth);
        storageFileGetDataParameter.setId(id);
        InputStream inputStream = this.getInputStream(storageFileGetDataParameter);

        storageFile.setInputStream(inputStream);

        return storageFile;
    }

    @Override
    public StorageFile getMeta(StorageFileGetMetaParameter parameter) {
        storageFileServiceTool.getMetaValidate(parameter);

        String id = parameter.getId();

        Path metaPath = Paths.get(storageFileServiceTool.getMetaPath(id));

        InputStream inputStream = FileUtil.read(metaPath);
        return JsonUtil.toObject(inputStream, StorageFile.class);
    }

    @Override
    public InputStream getInputStream(StorageFileGetInputStreamParameter parameter) {
        storageFileServiceTool.getInputStreamValidate(parameter);

        String id = parameter.getId();

        Path dataPath = Paths.get(storageFileServiceTool.getDataPath(id));

        StorageFile storageFile = new StorageFile();
        storageFile.setId(id);

        return FileUtil.read(dataPath);
    }

}