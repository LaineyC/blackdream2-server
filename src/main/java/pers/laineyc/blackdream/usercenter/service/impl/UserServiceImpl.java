package pers.laineyc.blackdream.usercenter.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pers.laineyc.blackdream.foundation.service.DetachedFileService;
import pers.laineyc.blackdream.foundation.service.SequenceService;
import pers.laineyc.blackdream.foundation.service.StorageFileService;
import pers.laineyc.blackdream.foundation.service.domain.DetachedFile;
import pers.laineyc.blackdream.foundation.service.parameter.DetachedFilePersistParameter;
import pers.laineyc.blackdream.foundation.service.parameter.StorageFileDeleteParameter;
import pers.laineyc.blackdream.framework.model.Auth;
import pers.laineyc.blackdream.framework.service.BaseService;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.usercenter.constant.UserStatusEnum;
import pers.laineyc.blackdream.usercenter.service.UserService;
import pers.laineyc.blackdream.usercenter.service.parameter.*;
import pers.laineyc.blackdream.usercenter.tool.UserServiceTool;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.usercenter.service.domain.User;
import pers.laineyc.blackdream.usercenter.dao.po.UserPo;
import pers.laineyc.blackdream.usercenter.dao.query.UserQuery;
import pers.laineyc.blackdream.usercenter.dao.UserDao;
import java.util.List; 
import java.util.Date; 
import java.util.ArrayList;
import java.util.UUID;

/**
 * 用户ServiceImpl
 * @author LaineyC
 */
@Primary
@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    private UserServiceTool userServiceTool;

    @Autowired
    private UserDao userDao;

    @Autowired
    private SequenceService sequenceService;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private DetachedFileService detachedFileService;

    @Autowired
    private StorageFileService storageFileService;

    public UserServiceImpl() {

	}

    /**
     * 用户修改
     */
    @Transactional
    public User update(UserUpdateParameter parameter) {
        userServiceTool.updateValidate(parameter);
      
        Auth auth = parameter.getAuth();

        Long id = parameter.getId();
        UserPo userPo = userDao.selectById(id);
        if(userPo == null){
            throw new BusinessException("用户不存在");
        }
        userPo.setId(id);
        
        Integer status = parameter.getStatus();
        userPo.setStatus(status);

        String nickname = parameter.getNickname();
        userPo.setNickname(nickname);

        Long iconFileId = parameter.getIconFileId();
        userPo.setIconFileId(iconFileId);

        String username = parameter.getUsername();
        userPo.setUsername(username);

        String email = parameter.getEmail();
        userPo.setEmail(email);

        userPo.setSignInCount(0);

        userPo.setSignInTime(new Date());

        userPo.setSignUpTime(new Date());

        userPo.setCreateTime(new Date());

        userPo.setUpdateTime(new Date());

        userDao.update(userPo);

        User user = new User();
        user.setId(id);

        return user;
    }
    
    /**
     * 用户单个查询
     */
    //@Transactional(readOnly = true)
    public User get(UserGetParameter parameter) {
        userServiceTool.getValidate(parameter);
        
        Auth auth = parameter.getAuth();
        
        Long id = parameter.getId();
        UserPo userPo = userDao.selectById(id);
        if(userPo == null) {
            throw new BusinessException("用户不存在");
        }

        User user = new User();
        
        user.setId(userPo.getId());

        user.setStatus(userPo.getStatus());

        user.setNickname(userPo.getNickname());

        user.setIconFileId(userPo.getIconFileId());

        user.setUsername(userPo.getUsername());

        user.setEmail(userPo.getEmail());

        user.setSignInCount(userPo.getSignInCount());

        user.setSignInIp(userPo.getSignInIp());

        user.setSignInTime(userPo.getSignInTime());

        user.setSignUpTime(userPo.getSignUpTime());

        user.setCreateTime(userPo.getCreateTime());

        user.setUpdateTime(userPo.getUpdateTime());

        return user;
    }

    /**
     * 用户多个查询
     */
    //@Transactional(readOnly = true)
    public List<User> query(UserQueryParameter parameter) {
        userServiceTool.queryValidate(parameter);
    
        Auth auth = parameter.getAuth();
        
        UserQuery userQuery = new UserQuery();
        userQuery.setStatus(parameter.getStatus());
        userQuery.setNickname(parameter.getNickname());
        userQuery.setIconFileId(parameter.getIconFileId());
        userQuery.setUsername(parameter.getUsername());
        userQuery.setEmail(parameter.getEmail());

        List<UserPo> userPoList = userDao.selectList(userQuery);

        List<User> userList = new ArrayList<>();
        if(userPoList.isEmpty()){
            return userList;
        }
        
        userPoList.forEach(po -> {
            User user = new User();

            user.setId(po.getId());

            user.setStatus(po.getStatus());

            user.setNickname(po.getNickname());

            user.setIconFileId(po.getIconFileId());

            user.setUsername(po.getUsername());

            user.setEmail(po.getEmail());

            user.setSignInCount(po.getSignInCount());

            user.setSignInIp(po.getSignInIp());

            user.setSignInTime(po.getSignInTime());

            user.setSignUpTime(po.getSignUpTime());

            user.setCreateTime(po.getCreateTime());

            user.setUpdateTime(po.getUpdateTime());

            userList.add(user);
        });
        
        return userList;
    }

    /**
     * 用户分页查询
     */
    //@Transactional(readOnly = true)
    public PageResult<User> search(UserSearchParameter parameter) {
        userServiceTool.searchValidate(parameter);
    
        Auth auth = parameter.getAuth();

        Integer page = parameter.getPage();

        Integer pageSize = parameter.getPageSize();
        
        PageResult<User> pageResult = new PageResult<>();
        List<User> records = pageResult.getRecords();

        UserQuery userQuery = new UserQuery();
        userQuery.setStatus(parameter.getStatus());
        userQuery.setNickname(parameter.getNickname());
        userQuery.setIconFileId(parameter.getIconFileId());
        userQuery.setUsername(parameter.getUsername());
        userQuery.setEmail(parameter.getEmail());
        userQuery.limit((page - 1) * pageSize, pageSize);
        
        PageResult<UserPo> userPoPageResult = userDao.selectPage(userQuery);
        pageResult.setTotal(userPoPageResult.getTotal());

        userPoPageResult.getRecords().forEach(po -> {
            User user = new User();

            user.setId(po.getId());

            user.setStatus(po.getStatus());

            user.setNickname(po.getNickname());

            user.setIconFileId(po.getIconFileId());

            user.setUsername(po.getUsername());

            user.setEmail(po.getEmail());

            user.setSignInCount(po.getSignInCount());

            user.setSignInIp(po.getSignInIp());

            user.setSignInTime(po.getSignInTime());

            user.setSignUpTime(po.getSignUpTime());

            user.setCreateTime(po.getCreateTime());

            user.setUpdateTime(po.getUpdateTime());

            records.add(user);
        });

        return pageResult;
    }

    /**
     * 用户登录
     */
    @Transactional
    public User signIn(UserSignInParameter parameter) {
        userServiceTool.signInValidate(parameter);
    
        Auth auth = parameter.getAuth();
        Date now = new Date();

        UserPo userPo;

        String username = parameter.getUsername();

        String password = parameter.getPassword();

        UserQuery userQuery = new UserQuery();
        if(username.contains("@")){
            userQuery.setEmail(username);
        }
        else{
            userQuery.setUsername(username);
        }
        userPo = userDao.selectOne(userQuery);

        if(userPo == null){
            throw new BusinessException("用户名或密码错误");
        }

        Integer status = userPo.getStatus();
        if(status == UserStatusEnum.FROZEN.getCode()){
            throw new BusinessException("账号已冻结");
        }

        if(!passwordEncoder.matches(password, userPo.getPassword())){
            throw new BusinessException("用户名或密码错误");
        }

        String accessToken = UUID.randomUUID().toString();
        UserPo userPoUpdate = new UserPo();
        userPoUpdate.setId(userPo.getId());
        userPoUpdate.setSignInCount(userPo.getSignInCount() + 1);
        userPoUpdate.setSignInTime(now);
        userPoUpdate.setUpdateTime(now);
        userPoUpdate.setAccessToken(accessToken);
        userDao.updateSelective(userPoUpdate);

        User user = new User();
        user.setId(userPo.getId());
        user.setAccessToken(accessToken);

        return user;
    }

    /**
     * 令牌登录
     */
    @Transactional
    public User tokenSignIn(UserTokenSignInParameter parameter) {
        userServiceTool.tokenSignInValidate(parameter);

        Auth auth = parameter.getAuth();
        Date now = new Date();

        String username = parameter.getUsername();

        String accessToken = parameter.getAccessToken();

        Long userId = Long.valueOf(username);

        UserPo userPo = userDao.selectById(userId);
        if(userPo == null){
            throw new BusinessException("用户名或密码错误");
        }

        Integer status = userPo.getStatus();
        if(status == UserStatusEnum.FROZEN.getCode()){
            throw new BusinessException("账号已冻结");
        }

        if(!accessToken.equals(userPo.getAccessToken())){
            throw new BusinessException("用户名或密码错误");
        }
/*
        UserPo userPoUpdate = new UserPo();
        userPoUpdate.setId(userPo.getId());
        userPoUpdate.setSignInCount(userPo.getSignInCount() + 1);
        userPoUpdate.setSignInTime(now);
        userPoUpdate.setUpdateTime(now);
        userDao.updateSelective(userPoUpdate);
*/
        User user = new User();
        user.setId(userPo.getId());
        user.setAccessToken(accessToken);

        return user;
    }
    
    /**
     * 用户退出
     */
    @Transactional
    public User signOut(UserSignOutParameter parameter) {
        userServiceTool.signOutValidate(parameter);

        Auth auth = parameter.getAuth();
        Date now = new Date();

        if(auth != null){
            Long authUserId = auth.getUserId();
            String accessToken = UUID.randomUUID().toString();

            UserPo userPoUpdate = new UserPo();
            userPoUpdate.setId(authUserId);
            userPoUpdate.setUpdateTime(now);
            userPoUpdate.setAccessToken(accessToken);
            userDao.updateSelective(userPoUpdate);
        }

        User user = new User();

        return user;
    }
    
    /**
     * 用户注册
     */
    @Transactional
    public User signUp(UserSignUpParameter parameter) {
        userServiceTool.signUpValidate(parameter);
    
        Auth auth = parameter.getAuth();
        Date now = new Date();

        UserPo userPo = new UserPo();

        Long id = sequenceService.nextId();
        userPo.setId(id);

        String username = parameter.getUsername();
        UserQuery userQueryUsernameExist = new UserQuery();
        userQueryUsernameExist.setUsername(username);
        UserPo userPoUsernameExist = userDao.selectOne(userQueryUsernameExist);
        if(userPoUsernameExist != null){
            throw new BusinessException("用户名被已注册");
        }
        userPo.setUsername(username);
        userPo.setNickname(username);

        String email = parameter.getEmail();
        UserQuery userQueryEmailExist = new UserQuery();
        userQueryEmailExist.setEmail(email);
        UserPo userPoEmailExist = userDao.selectOne(userQueryEmailExist);
        if(userPoEmailExist != null){
            throw new BusinessException("邮箱被已注册");
        }
        userPo.setEmail(email);

        String password = parameter.getPassword();
        String encodePassword = passwordEncoder.encode(password);
        userPo.setPassword(encodePassword);

        userPo.setSignInCount(0);

        userPo.setStatus(UserStatusEnum.ENABLE.getCode());

        userPo.setSignUpTime(now);

        userPo.setCreateTime(now);

        userDao.insert(userPo);

        User user = new User();
        user.setId(userPo.getId());

        return user;
    }
    
    /**
     * 用户密码修改
     */
    @Transactional
    public User passwordChange(UserPasswordChangeParameter parameter) {
        userServiceTool.passwordUpdateValidate(parameter);
    
        Auth auth = parameter.getAuth();
        Long authUserId = auth.getUserId();

        UserPo userPo = userDao.selectById(authUserId);
        if(userPo == null){
            throw new BusinessException("用户不存在");
        }

        String oldPassword = parameter.getOldPassword();
        if(!passwordEncoder.matches(oldPassword, userPo.getPassword())){
            throw new BusinessException("旧密码不正确");
        }

        String newPassword = parameter.getNewPassword();
        String encodeNewPassword = passwordEncoder.encode(newPassword);
        String newAccessToken = UUID.randomUUID().toString();

        UserPo userPoUpdate = new UserPo();
        userPoUpdate.setId(userPo.getId());
        userPoUpdate.setPassword(encodeNewPassword);
        userPoUpdate.setAccessToken(newAccessToken);
        userDao.updateSelective(userPoUpdate);

        User user = new User();
        user.setId(authUserId);
        user.setAccessToken(newAccessToken);

        return user;
    }

    /**
     * 用户名测存在
     */
    //@Transactional(readOnly = true)
    public Boolean usernameExist(UserUsernameExistParameter parameter) {
        userServiceTool.usernameExistValidate(parameter);

        String username = parameter.getUsername();
        UserQuery userQuery = new UserQuery();
        if(username.contains("@")){
            userQuery.setEmail(username);
        }
        else{
            userQuery.setUsername(username);
        }
        UserPo userPo = userDao.selectOne(userQuery);

        return userPo != null;
    }

    /**
     * 用户头像更改
     */
    @Transactional
    public User iconChange(UserIconChangeParameter parameter) {
        userServiceTool.iconUpdateValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        Long authUserId = auth.getUserId();

        UserPo userPo = userDao.selectById(authUserId);
        if(userPo == null){
            throw new BusinessException("用户不存在");
        }

        Long iconFileId = parameter.getIconFileId();

        DetachedFilePersistParameter detachedFileHandleParameter = new DetachedFilePersistParameter();
        detachedFileHandleParameter.setAuth(auth);
        detachedFileHandleParameter.setId(iconFileId);
        DetachedFile detachedFile = detachedFileService.persist(detachedFileHandleParameter);
        if(detachedFile == null){
            throw new BusinessException("头像更换失败");
        }

        UserPo userPoUpdate = new UserPo();
        userPoUpdate.setId(authUserId);
        userPoUpdate.setIconFileId(iconFileId);
        userPoUpdate.setUpdateTime(now);
        userDao.updateSelective(userPoUpdate);

        Long oldIconId = userPo.getIconFileId();
        if(oldIconId != null){
            StorageFileDeleteParameter storageFileDeleteParameter = new StorageFileDeleteParameter();
            storageFileDeleteParameter.setAuth(auth);
            storageFileDeleteParameter.setId(oldIconId);
            storageFileService.delete(storageFileDeleteParameter);
        }

        return new User();
    }
}