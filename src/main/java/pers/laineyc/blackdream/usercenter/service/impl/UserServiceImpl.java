package pers.laineyc.blackdream.usercenter.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pers.laineyc.blackdream.foundation.constant.ValidCodePlatformTypeEnum;
import pers.laineyc.blackdream.foundation.constant.ValidCodeTypeEnum;
import pers.laineyc.blackdream.foundation.service.DetachedFileService;
import pers.laineyc.blackdream.foundation.service.StorageFileService;
import pers.laineyc.blackdream.foundation.service.ValidCodeService;
import pers.laineyc.blackdream.foundation.service.domain.DetachedFile;
import pers.laineyc.blackdream.foundation.service.domain.ValidCode;
import pers.laineyc.blackdream.foundation.service.parameter.DetachedFilePersistParameter;
import pers.laineyc.blackdream.foundation.service.parameter.StorageFileDeleteParameter;
import pers.laineyc.blackdream.foundation.service.parameter.ValidCodeSendParameter;
import pers.laineyc.blackdream.foundation.service.parameter.ValidCodeCheckParameter;
import pers.laineyc.blackdream.framework.exception.ErrorCodes;
import pers.laineyc.blackdream.framework.model.Auth;
import pers.laineyc.blackdream.framework.service.BaseService;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.framework.util.BeanUtils;
import pers.laineyc.blackdream.usercenter.constant.UserStatusEnum;
import pers.laineyc.blackdream.usercenter.constant.UserTypeEnum;
import pers.laineyc.blackdream.usercenter.dao.UserAuthDao;
import pers.laineyc.blackdream.usercenter.dao.po.UserAuthPo;
import pers.laineyc.blackdream.usercenter.dao.query.UserAuthQuery;
import pers.laineyc.blackdream.usercenter.model.AccessToken;
import pers.laineyc.blackdream.usercenter.model.AccessTokenBody;
import pers.laineyc.blackdream.usercenter.service.UserService;
import pers.laineyc.blackdream.usercenter.service.domain.UserAuth;
import pers.laineyc.blackdream.usercenter.service.parameter.*;
import pers.laineyc.blackdream.usercenter.tool.AccessTokenTool;
import pers.laineyc.blackdream.usercenter.tool.UserServiceTool;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.usercenter.service.domain.User;
import pers.laineyc.blackdream.usercenter.dao.po.UserPo;
import pers.laineyc.blackdream.usercenter.dao.query.UserQuery;
import pers.laineyc.blackdream.usercenter.dao.UserDao;

import java.util.*;

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
    private UserAuthDao userAuthDao;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private DetachedFileService detachedFileService;

    @Autowired
    private StorageFileService storageFileService;

    @Autowired
    private ValidCodeService validCodeService;

    @Autowired
    private AccessTokenTool accessTokenTool;

    public UserServiceImpl() {

	}

    /**
     * 用户修改
     */
    @Transactional
    public User update(UserUpdateParameter parameter) {
        userServiceTool.updateValidate(parameter);
      
        Auth auth = parameter.getAuth();

        String id = parameter.getId();
        UserPo userPo = userDao.selectById(id);
        if(userPo == null){
            throw new BusinessException("用户不存在");
        }
        userPo.setId(id);

        String nickname = parameter.getNickname();
        userPo.setNickname(nickname);

        String iconFileId = parameter.getIconFileId();
        userPo.setIconFileId(iconFileId);

        String username = parameter.getUsername();
        userPo.setUsername(username);

        String email = parameter.getEmail();
        userPo.setEmail(email);

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

        String id = parameter.getId();
        UserPo userPo = userDao.selectById(id);
        if(userPo == null) {
            throw new BusinessException("用户不存在");
        }

        User user = new User();
        
        user.setId(userPo.getId());

        user.setType(userPo.getType());

        user.setNickname(userPo.getNickname());

        user.setIconFileId(userPo.getIconFileId());

        user.setUsername(userPo.getUsername());

        user.setEmail(userPo.getEmail());

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
        userQuery.setType(parameter.getType());
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

            user.setType(po.getType());

            user.setNickname(po.getNickname());

            user.setIconFileId(po.getIconFileId());

            user.setUsername(po.getUsername());

            user.setEmail(po.getEmail());

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
        userQuery.setType(parameter.getType());
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

            user.setType(po.getType());

            user.setNickname(po.getNickname());

            user.setIconFileId(po.getIconFileId());

            user.setUsername(po.getUsername());

            user.setEmail(po.getEmail());

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

        UserAuthPo userAuthPo;

        String username = parameter.getUsername();

        String password = parameter.getPassword();

        UserAuthQuery userAuthQuery = new UserAuthQuery();
        if(username.contains("@")){
            userAuthQuery.setEmail(username);
        }
        else{
            userAuthQuery.setUsername(username);
        }
        userAuthPo = userAuthDao.selectOne(userAuthQuery);

        if(userAuthPo == null){
            throw new BusinessException("用户名或密码错误");
        }

        Integer status = userAuthPo.getStatus();
        if(status == UserStatusEnum.FROZEN.getCode()){
            throw new BusinessException("账号已冻结");
        }

        if(!passwordEncoder.matches(password, userAuthPo.getPassword())){
            throw new BusinessException("用户名或密码错误");
        }

        String userId = userAuthPo.getUserId();
        UserPo userPo = userDao.selectById(userId);
        User user = new User();
        user.setId(userPo.getId());
        user.setType(userPo.getType());

        return user;
    }

    /**
     * 令牌登录
     */
    @Transactional
    public User tokenSignIn(UserTokenSignInParameter parameter) {
        userServiceTool.tokenSignInValidate(parameter);

        Auth auth = parameter.getAuth();

        String accessTokenString = parameter.getAccessToken();

        AccessToken accessToken = accessTokenTool.parse(accessTokenString);

        AccessTokenBody accessTokenBody = accessToken.getBody();

        String userId = accessTokenBody.getUserId();
        UserAuthQuery userAuthQuery = new UserAuthQuery();
        userAuthQuery.setUserId(userId);
        UserAuthPo userAuthPo = userAuthDao.selectOne(userAuthQuery);
        if(userAuthPo == null){
            throw new BusinessException(ErrorCodes.EC_001002);
        }

        Integer status = userAuthPo.getStatus();
        if(status == UserStatusEnum.FROZEN.getCode()){
            throw new BusinessException("账号已冻结");
        }

        UserPo userPo = userDao.selectById(userId);
        User user = new User();
        user.setId(userPo.getId());
        user.setType(userPo.getType());

        return user;
    }
    
    /**
     * 用户退出
     */
    @Transactional
    public User signOut(UserSignOutParameter parameter) {
        userServiceTool.signOutValidate(parameter);

        Auth auth = parameter.getAuth();

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

        UserAuthPo userAuthPo = new UserAuthPo();

        String username = parameter.getUsername();
        UserAuthQuery userAuthQueryUsernameExist = new UserAuthQuery();
        userAuthQueryUsernameExist.setUsername(username);
        UserAuthPo userAuthPoUsernameExist = userAuthDao.selectOne(userAuthQueryUsernameExist);
        if(userAuthPoUsernameExist != null){
            throw new BusinessException("用户名被已注册");
        }
        userAuthPo.setUsername(username);

        String email = parameter.getEmail();
        UserAuthQuery userAuthQueryEmailExist = new UserAuthQuery();
        userAuthQueryEmailExist.setEmail(email);
        UserAuthPo userAuthPoEmailExist = userAuthDao.selectOne(userAuthQueryEmailExist);
        if(userAuthPoEmailExist != null){
            throw new BusinessException("邮箱被已注册");
        }

        String code = parameter.getValidCode();
        ValidCodeCheckParameter validCodeValidateParameter = new ValidCodeCheckParameter();
        validCodeValidateParameter.setAuth(auth);
        validCodeValidateParameter.setType(ValidCodeTypeEnum.REGISTER);
        validCodeValidateParameter.setPlatformAccount(email);
        validCodeValidateParameter.setCode(code);
        validCodeService.check(validCodeValidateParameter);
        userAuthPo.setEmail(email);

        String password = parameter.getPassword();
        String encodePassword = passwordEncoder.encode(password);
        userAuthPo.setPassword(encodePassword);
        userAuthPo.setStatus(UserStatusEnum.ENABLE.getCode());
        userAuthPo.setCreateTime(now);
        userAuthPo.setUpdateTime(now);

        UserPo userPo = new UserPo();
        userPo.setType(UserTypeEnum.GENERAL.getCode());
        userPo.setNickname(username);
        userPo.setUsername(username);
        userPo.setEmail(email);
        userPo.setCreateTime(now);
        userPo.setUpdateTime(now);
        userDao.insert(userPo);

        userAuthPo.setUserId(userPo.getId());

        userAuthDao.insert(userAuthPo);

        User user = new User();
        user.setId(userPo.getId());

        return user;
    }

    /**
     * 注册验证码发送
     */
    @Transactional
    public ValidCode signUpEmailValidCodeSend(UserSignUpEmailValidCodeSendParameter parameter) {
        userServiceTool.signUpEmailValidCodeSendValidate(parameter);

        Auth auth = parameter.getAuth();

        String email = parameter.getEmail();

        ValidCodeSendParameter validCodeSendParameter = new ValidCodeSendParameter();
        validCodeSendParameter.setAuth(auth);
        validCodeSendParameter.setType(ValidCodeTypeEnum.REGISTER);
        validCodeSendParameter.setPlatformType(ValidCodePlatformTypeEnum.EMAIL.getCode());
        validCodeSendParameter.setPlatformAccount(email);

        ValidCode validCode = validCodeService.send(validCodeSendParameter);

        return validCode;
    }

    /**
     * 用户密码修改
     */
    @Transactional
    public User passwordChange(UserPasswordChangeParameter parameter) {
        userServiceTool.passwordUpdateValidate(parameter);
    
        Auth auth = parameter.getAuth();
        String authUserId = auth.getUserId();

        UserAuthQuery userAuthQuery = new UserAuthQuery();
        userAuthQuery.setUserId(authUserId);
        UserAuthPo userAuthPo = userAuthDao.selectOne(userAuthQuery);
        if(userAuthPo == null){
            throw new BusinessException("用户不存在");
        }

        String oldPassword = parameter.getOldPassword();
        if(!passwordEncoder.matches(oldPassword, userAuthPo.getPassword())){
            throw new BusinessException("旧密码不正确");
        }

        String newPassword = parameter.getNewPassword();
        String encodeNewPassword = passwordEncoder.encode(newPassword);

        UserAuthPo userAuthPoUpdate = new UserAuthPo();
        userAuthPoUpdate.setId(userAuthPo.getId());
        userAuthPoUpdate.setPassword(encodeNewPassword);
        userAuthDao.updateSelective(userAuthPoUpdate);

        User user = new User();
        user.setId(authUserId);

        return user;
    }

    /**
     * 用户名测存在
     */
    //@Transactional(readOnly = true)
    public Boolean usernameExist(UserUsernameExistParameter parameter) {
        userServiceTool.usernameExistValidate(parameter);

        String username = parameter.getUsername();
        UserAuthQuery userAuthQuery = new UserAuthQuery();
        if(username.contains("@")){
            userAuthQuery.setEmail(username);
        }
        else{
            userAuthQuery.setUsername(username);
        }
        UserAuthPo userAuthPo = userAuthDao.selectOne(userAuthQuery);

        return userAuthPo != null;
    }

    /**
     * 用户头像更改
     */
    @Transactional
    public User iconChange(UserIconChangeParameter parameter) {
        userServiceTool.iconUpdateValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        String authUserId = auth.getUserId();

        UserPo userPo = userDao.selectById(authUserId);
        if(userPo == null){
            throw new BusinessException("用户不存在");
        }

        String iconFileId = parameter.getIconFileId();

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

        String oldIconId = userPo.getIconFileId();
        if(oldIconId != null){
            StorageFileDeleteParameter storageFileDeleteParameter = new StorageFileDeleteParameter();
            storageFileDeleteParameter.setAuth(auth);
            storageFileDeleteParameter.setId(oldIconId);
            storageFileService.delete(storageFileDeleteParameter);
        }

        return new User();
    }

    /**
     * 用户单个查询
     */
    //@Transactional(readOnly = true)
    public User infoGet(UserInfoGetParameter parameter) {
        userServiceTool.infoGetValidate(parameter);

        Auth auth = parameter.getAuth();
        String authUserId = auth.getUserId();

        UserGetParameter userGetParameter = new UserGetParameter();
        BeanUtils.copyProperties(parameter, userGetParameter);
        userGetParameter.setId(authUserId);
        return this.get(userGetParameter);
    }

}