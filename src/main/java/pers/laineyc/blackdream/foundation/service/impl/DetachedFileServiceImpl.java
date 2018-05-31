package pers.laineyc.blackdream.foundation.service.impl;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pers.laineyc.blackdream.foundation.constant.DetachedFileStatusEnum;
import pers.laineyc.blackdream.foundation.service.StorageFileService;
import pers.laineyc.blackdream.foundation.service.parameter.*;
import pers.laineyc.blackdream.framework.model.Auth;
import pers.laineyc.blackdream.framework.service.BaseService;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.foundation.service.DetachedFileService;
import pers.laineyc.blackdream.foundation.tool.DetachedFileServiceTool;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.foundation.service.domain.DetachedFile;
import pers.laineyc.blackdream.foundation.dao.po.DetachedFilePo;
import pers.laineyc.blackdream.foundation.dao.query.DetachedFileQuery;
import pers.laineyc.blackdream.foundation.dao.DetachedFileDao;
import pers.laineyc.blackdream.usercenter.dao.query.UserQuery;
import pers.laineyc.blackdream.usercenter.service.domain.User;
import pers.laineyc.blackdream.usercenter.dao.po.UserPo;
import pers.laineyc.blackdream.usercenter.dao.UserDao;
import java.io.InputStream;
import java.util.List;
import java.util.Date; 
import java.util.ArrayList; 
import java.util.Map; 
import java.util.HashMap; 

/**
 * 游离文件ServiceImpl
 * @author LaineyC
 */
@Primary
@Service
public class DetachedFileServiceImpl extends BaseService implements DetachedFileService {

    @Autowired
    private DetachedFileServiceTool detachedFileServiceTool;

    @Autowired
    private DetachedFileDao detachedFileDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private StorageFileService storageFileService;

    public DetachedFileServiceImpl() {

	}

    /**
     * 游离文件单个查询
     */
    //@Transactional(readOnly = true)
    public DetachedFile get(DetachedFileGetParameter parameter) {
        detachedFileServiceTool.getValidate(parameter);
        
        Auth auth = parameter.getAuth();

        String id = parameter.getId();
        DetachedFilePo detachedFilePo = detachedFileDao.selectById(id);
        if(detachedFilePo == null) {
            throw new BusinessException("游离文件不存在");
        }

        DetachedFile detachedFile = new DetachedFile();
        
        detachedFile.setId(detachedFilePo.getId());

        String userId = detachedFilePo.getUserId();
        if(userId != null){
            UserPo userPo = userDao.selectById(userId);
            if(userPo != null){
                User user = new User();
                user.setId(userPo.getId());
                detachedFile.setUser(user);
            }
        }

        detachedFile.setSize(detachedFilePo.getSize());

        detachedFile.setName(detachedFilePo.getName());

        detachedFile.setExtension(detachedFilePo.getExtension());

        detachedFile.setContentType(detachedFilePo.getContentType());

        detachedFile.setCreateTime(detachedFilePo.getCreateTime());

        detachedFile.setUpdateTime(detachedFilePo.getUpdateTime());

        return detachedFile;
    }

    /**
     * 游离文件多个查询
     */
    //@Transactional(readOnly = true)
    public List<DetachedFile> query(DetachedFileQueryParameter parameter) {
        detachedFileServiceTool.queryValidate(parameter);
    
        Auth auth = parameter.getAuth();
        
        DetachedFileQuery detachedFileQuery = new DetachedFileQuery();
        detachedFileQuery.setUserId(parameter.getUserId());
        detachedFileQuery.setStatus(parameter.getStatus());
        detachedFileQuery.setSize(parameter.getSize());
        detachedFileQuery.setName(parameter.getName());
        detachedFileQuery.setExtension(parameter.getExtension());
        detachedFileQuery.setContentType(parameter.getContentType());

        List<DetachedFilePo> detachedFilePoList = detachedFileDao.selectList(detachedFileQuery);

        List<DetachedFile> detachedFileList = new ArrayList<>();
        if(detachedFilePoList.isEmpty()){
            return detachedFileList;
        }
        
        Map<String, User> userMap = new HashMap<>();
        detachedFilePoList.forEach(po -> {
            DetachedFile detachedFile = new DetachedFile();

            detachedFile.setId(po.getId());

            String userId = po.getUserId();
            if (userId != null) {
                User user;
                if (userMap.containsKey(userId)) {
                    user = userMap.get(userId);
                } else {
                    user = new User();
                    user.setId(userId);
                    userMap.put(userId, user);
                }
                detachedFile.setUser(user);
            }

            detachedFile.setSize(po.getSize());

            detachedFile.setName(po.getName());

            detachedFile.setExtension(po.getExtension());

            detachedFile.setContentType(po.getContentType());

            detachedFile.setCreateTime(po.getCreateTime());

            detachedFile.setUpdateTime(po.getUpdateTime());

            detachedFileList.add(detachedFile);
        });

        if(!userMap.isEmpty()){
            UserQuery userQuery = new UserQuery();
            userQuery.setIdList(new ArrayList<>(userMap.keySet()));
            List<UserPo> userPos = userDao.selectList(userQuery);
            userPos.forEach(po -> {
                String id = po.getId();
                User user = userMap.get(id);
                user.setId(id);
            });
        }

        return detachedFileList;
    }

    /**
     * 游离文件分页查询
     */
    //@Transactional(readOnly = true)
    public PageResult<DetachedFile> search(DetachedFileSearchParameter parameter) {
        detachedFileServiceTool.searchValidate(parameter);
    
        Auth auth = parameter.getAuth();

        Integer page = parameter.getPage();

        Integer pageSize = parameter.getPageSize();
        
        PageResult<DetachedFile> pageResult = new PageResult<>();
        List<DetachedFile> records = pageResult.getRecords();

        DetachedFileQuery detachedFileQuery = new DetachedFileQuery();
        detachedFileQuery.setUserId(parameter.getUserId());
        detachedFileQuery.setStatus(parameter.getStatus());
        detachedFileQuery.setSize(parameter.getSize());
        detachedFileQuery.setName(parameter.getName());
        detachedFileQuery.setExtension(parameter.getExtension());
        detachedFileQuery.setContentType(parameter.getContentType());
        detachedFileQuery.limit((page - 1) * pageSize, pageSize);
        
        PageResult<DetachedFilePo> detachedFilePoPageResult = detachedFileDao.selectPage(detachedFileQuery);
        pageResult.setTotal(detachedFilePoPageResult.getTotal());

        Map<String, User> userMap = new HashMap<>();
        detachedFilePoPageResult.getRecords().forEach(po -> {
            DetachedFile detachedFile = new DetachedFile();

            detachedFile.setId(po.getId());

            String userId = po.getUserId();
            if (userId != null) {
                User user;
                if (userMap.containsKey(userId)) {
                    user = userMap.get(userId);
                } else {
                    user = new User();
                    user.setId(userId);
                    userMap.put(userId, user);
                }
                detachedFile.setUser(user);
            }

            detachedFile.setSize(po.getSize());

            detachedFile.setName(po.getName());

            detachedFile.setExtension(po.getExtension());

            detachedFile.setContentType(po.getContentType());

            detachedFile.setCreateTime(po.getCreateTime());

            detachedFile.setUpdateTime(po.getUpdateTime());

            records.add(detachedFile);
        });

        if(!userMap.isEmpty()){
            UserQuery userQuery = new UserQuery();
            userQuery.setIdList(new ArrayList<>(userMap.keySet()));
            List<UserPo> userPos = userDao.selectList(userQuery);
            userPos.forEach(po -> {
                String id = po.getId();
                User user = userMap.get(id);
                user.setId(id);
            });
        }

        return pageResult;
    }

    /**
     * 游离文件上传
     */
    @Transactional
    public DetachedFile upload(DetachedFileUploadParameter parameter) {
        detachedFileServiceTool.uploadValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        String authUserId = null;
        if(auth != null){
            authUserId = auth.getUserId();
        }

        String id = ObjectId.get().toString();

        DetachedFilePo detachedFilePo = new DetachedFilePo();
        detachedFilePo.setId(id);

        detachedFilePo.setUserId(authUserId);

        detachedFilePo.setStatus(DetachedFileStatusEnum.DETACHED.getCode());

        Long size = parameter.getSize();
        detachedFilePo.setSize(size);

        String name = parameter.getName();
        detachedFilePo.setName(name);

        String extension = parameter.getExtension();
        detachedFilePo.setExtension(extension);

        String contentType = parameter.getContentType();
        detachedFilePo.setContentType(contentType);

        detachedFilePo.setCreateTime(now);

        detachedFileDao.insert(detachedFilePo);

        InputStream inputStream = parameter.getInputStream();

        StorageFileCreateParameter storageFileCreateParameter = new StorageFileCreateParameter();
        storageFileCreateParameter.setId(id);
        storageFileCreateParameter.setName(name);
        storageFileCreateParameter.setExtension(extension);
        storageFileCreateParameter.setSize(size);
        storageFileCreateParameter.setContentType(contentType);
        storageFileCreateParameter.setUserId(authUserId);
        storageFileCreateParameter.setCreateTime(now);
        storageFileCreateParameter.setUpdateTime(now);
        storageFileCreateParameter.setInputStream(inputStream);
        storageFileService.create(storageFileCreateParameter);

        DetachedFile detachedFile = new DetachedFile();
        detachedFile.setId(id);

        return detachedFile;
    }

    /**
     * 游离文件处理
     */
    @Transactional
    public DetachedFile persist(DetachedFilePersistParameter parameter) {
        detachedFileServiceTool.handleValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();

        String id = parameter.getId();
        DetachedFilePo detachedFilePo = detachedFileDao.selectById(id);
        if(detachedFilePo == null) {
            throw new BusinessException("文件不存在");
        }
        DetachedFilePo detachedFilePoUpdate = new DetachedFilePo();
        detachedFilePoUpdate.setId(id);
        detachedFilePoUpdate.setStatus(DetachedFileStatusEnum.MANAGED.getCode());
        detachedFilePoUpdate.setUpdateTime(now);
        detachedFileDao.updateSelective(detachedFilePoUpdate);

        DetachedFile detachedFile = new DetachedFile();

        String userId = detachedFilePo.getUserId();
        User user = new User();
        user.setId(userId);
        detachedFile.setUser(user);

        detachedFile.setSize(detachedFilePo.getSize());

        detachedFile.setName(detachedFilePo.getName());

        detachedFile.setExtension(detachedFilePo.getExtension());

        detachedFile.setContentType(detachedFilePo.getContentType());

        detachedFile.setCreateTime(detachedFilePo.getCreateTime());

        detachedFile.setUpdateTime(detachedFilePo.getUpdateTime());

        return detachedFile;
    }
    
}