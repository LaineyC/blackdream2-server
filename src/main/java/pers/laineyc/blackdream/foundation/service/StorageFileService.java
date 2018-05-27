package pers.laineyc.blackdream.foundation.service;

import pers.laineyc.blackdream.foundation.service.domain.StorageFile;
import pers.laineyc.blackdream.foundation.service.parameter.*;
import pers.laineyc.blackdream.framework.service.Service;
import java.io.InputStream;

/**
 * 游离文件Service
 * @author LaineyC
 */
public interface StorageFileService extends Service{

    StorageFile create(StorageFileCreateParameter parameter);

    StorageFile delete(StorageFileDeleteParameter parameter);

    StorageFile update(StorageFileUpdateParameter parameter);

    StorageFile get(StorageFileGetParameter parameter);

    StorageFile getMeta(StorageFileGetMetaParameter parameter);

    InputStream getInputStream(StorageFileGetInputStreamParameter parameter);

}