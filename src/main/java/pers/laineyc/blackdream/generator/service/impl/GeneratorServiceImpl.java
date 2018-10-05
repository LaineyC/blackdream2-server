package pers.laineyc.blackdream.generator.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pers.laineyc.blackdream.framework.model.Auth;
import pers.laineyc.blackdream.framework.service.BaseService;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.framework.util.BeanUtils;
import pers.laineyc.blackdream.generator.constant.GeneratorStatusEnum;
import pers.laineyc.blackdream.generator.service.GeneratorService;
import pers.laineyc.blackdream.generator.service.TemplateFileService;
import pers.laineyc.blackdream.generator.service.parameter.*;
import pers.laineyc.blackdream.generator.tool.GeneratorServiceTool;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.domain.Generator;
import pers.laineyc.blackdream.generator.dao.po.GeneratorPo;
import pers.laineyc.blackdream.generator.dao.query.GeneratorQuery;
import pers.laineyc.blackdream.generator.dao.GeneratorDao;
import pers.laineyc.blackdream.usercenter.service.domain.User;
import pers.laineyc.blackdream.usercenter.dao.po.UserPo;
import pers.laineyc.blackdream.usercenter.dao.query.UserQuery;
import pers.laineyc.blackdream.usercenter.dao.UserDao;
import java.util.List; 
import java.util.Date; 
import java.util.ArrayList; 
import java.util.Map; 
import java.util.HashMap; 

/**
 * 生成器ServiceImpl
 * @author LaineyC
 */
@Primary
@Service
public class GeneratorServiceImpl extends BaseService implements GeneratorService {

    @Autowired
    private GeneratorServiceTool generatorServiceTool;

    @Autowired
    private GeneratorDao generatorDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private TemplateFileService templateFileService;

    public GeneratorServiceImpl() {

	}

    /**
     * 生成器创建
     */
    @Transactional
    public Generator create(GeneratorCreateParameter parameter) {
        generatorServiceTool.createValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        String authUserId = auth.getUserId();
    
        GeneratorPo generatorPo = new GeneratorPo();

        generatorPo.setUserId(authUserId);

        String name = parameter.getName();
        generatorPo.setName(name);

        generatorPo.setStatus(GeneratorStatusEnum.DEVELOP.getCode());

        generatorPo.setReleaseVersion(0);

        Integer engineType = parameter.getEngineType();
        generatorPo.setEngineType(engineType);

        String description = parameter.getDescription();
        generatorPo.setDescription(description);

        generatorPo.setIsDeleted(false);

        generatorPo.setCreateTime(now);

        generatorPo.setUpdateTime(now);

        generatorDao.insert(generatorPo);

        Generator generator = new Generator();
        generator.setId(generatorPo.getId());

        return generator;
    }

    /**
     * 生成器删除
     */
    @Transactional
    public Generator delete(GeneratorDeleteParameter parameter) {
        generatorServiceTool.deleteValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        String authUserId = auth.getUserId();
               
        String id = parameter.getId();
        GeneratorPo generatorPo = generatorDao.selectById(id);
        if(generatorPo == null || generatorPo.getIsDeleted() || !generatorPo.getUserId().equals(authUserId)){
            throw new BusinessException("生成器不存在");
        }

        GeneratorPo generatorPoUpdate = new GeneratorPo();
        generatorPoUpdate.setId(id);
        generatorPoUpdate.setIsDeleted(true);
        generatorPoUpdate.setUpdateTime(now);
        generatorDao.updateSelective(generatorPoUpdate);

        Generator generator = new Generator();
        generator.setId(id);

        return generator;
    }
    
    /**
     * 生成器修改
     */
    @Transactional
    public Generator update(GeneratorUpdateParameter parameter) {
        generatorServiceTool.updateValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        String authUserId = auth.getUserId();

        String id = parameter.getId();
        GeneratorPo generatorPo = generatorDao.selectById(id);
        if(generatorPo == null || generatorPo.getIsDeleted() || !generatorPo.getUserId().equals(authUserId)){
            throw new BusinessException("生成器不存在");
        }

        String name = parameter.getName();
        generatorPo.setName(name);

        Integer engineType = parameter.getEngineType();
        generatorPo.setEngineType(engineType);

        String description = parameter.getDescription();
        generatorPo.setDescription(description);

        generatorPo.setUpdateTime(now);

        generatorDao.update(generatorPo);

        Generator generator = new Generator();
        generator.setId(id);

        return generator;
    }
    
    /**
     * 生成器单个查询
     */
    //@Transactional(readOnly = true)
    public Generator get(GeneratorGetParameter parameter) {
        generatorServiceTool.getValidate(parameter);
        
        Auth auth = parameter.getAuth();
        
        String id = parameter.getId();
        GeneratorPo generatorPo = generatorDao.selectById(id);
        if(generatorPo == null || generatorPo.getIsDeleted()){
            throw new BusinessException("生成器不存在");
        }

        Generator generator = new Generator();
        
        generator.setId(generatorPo.getId());

        String userId = generatorPo.getUserId();
        if(userId != null){
            UserPo userPo = userDao.selectById(userId);
            if(userPo != null){
                User user = new User();
                user.setId(userPo.getId());
                user.setUsername(userPo.getUsername());
                generator.setUser(user);
            }
        }

        generator.setName(generatorPo.getName());

        generator.setStatus(generatorPo.getStatus());

        generator.setReleaseVersion(generatorPo.getReleaseVersion());

        generator.setReleaseTime(generatorPo.getReleaseTime());

        generator.setDevelopTime(generatorPo.getDevelopTime());

        generator.setEngineType(generatorPo.getEngineType());

        generator.setDescription(generatorPo.getDescription());

        generator.setCreateTime(generatorPo.getCreateTime());

        generator.setUpdateTime(generatorPo.getUpdateTime());

        return generator;
    }

    /**
     * 生成器多个查询
     */
    //@Transactional(readOnly = true)
    public List<Generator> query(GeneratorQueryParameter parameter) {
        generatorServiceTool.queryValidate(parameter);
    
        Auth auth = parameter.getAuth();
        
        GeneratorQuery generatorQuery = new GeneratorQuery();
        generatorQuery.setIsDeleted(false);
        generatorQuery.setUserId(parameter.getUserId());
        generatorQuery.setName(parameter.getName());
        generatorQuery.setStatus(parameter.getStatus());
        generatorQuery.setEngineType(parameter.getEngineType());

        List<GeneratorPo> generatorPoList = generatorDao.selectList(generatorQuery);

        List<Generator> generatorList = new ArrayList<>();
        if(generatorPoList.isEmpty()){
            return generatorList;
        }
        
        Map<String, User> userMap = new HashMap<>();
        generatorPoList.forEach(po -> {
            Generator generator = new Generator();
            
            generator.setId(po.getId());

            String userId = po.getUserId();
            if(userId != null) {
                User user;
                if(userMap.containsKey(userId)) {
                    user = userMap.get(userId);
                }
                else {
                    user = new User();
                    user.setId(userId);
                    userMap.put(userId, user);
                }
                generator.setUser(user);
            }

            generator.setName(po.getName());

            generator.setStatus(po.getStatus());

            generator.setReleaseVersion(po.getReleaseVersion());

            generator.setReleaseTime(po.getReleaseTime());

            generator.setDevelopTime(po.getDevelopTime());

            generator.setEngineType(po.getEngineType());

            generator.setDescription(po.getDescription());

            generator.setCreateTime(po.getCreateTime());

            generator.setUpdateTime(po.getUpdateTime());

            generatorList.add(generator);
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

        return generatorList;
    }

    /**
     * 生成器分页查询
     */
    //@Transactional(readOnly = true)
    public PageResult<Generator> search(GeneratorSearchParameter parameter) {
        generatorServiceTool.searchValidate(parameter);
    
        Auth auth = parameter.getAuth();

        Integer page = parameter.getPage();

        Integer pageSize = parameter.getPageSize();
        
        PageResult<Generator> pageResult = new PageResult<>();
        List<Generator> records = pageResult.getRecords();

        GeneratorQuery generatorQuery = new GeneratorQuery();
        generatorQuery.setIsDeleted(false);
        generatorQuery.setUserId(parameter.getUserId());
        generatorQuery.setNameLike(parameter.getName());
        generatorQuery.setStatus(parameter.getStatus());
        generatorQuery.setEngineType(parameter.getEngineType());
        generatorQuery.limit((page - 1) * pageSize, pageSize);
        
        PageResult<GeneratorPo> generatorPoPageResult = generatorDao.selectPage(generatorQuery);
        pageResult.setTotal(generatorPoPageResult.getTotal());

        Map<String, User> userMap = new HashMap<>();
        generatorPoPageResult.getRecords().forEach(po -> {
            Generator generator = new Generator();
            
            generator.setId(po.getId());

            String userId = po.getUserId();
            if(userId != null) {
                User user;
                if(userMap.containsKey(userId)) {
                    user = userMap.get(userId);
                }
                else {
                    user = new User();
                    user.setId(userId);
                    userMap.put(userId, user);
                }
                generator.setUser(user);
            }

            generator.setName(po.getName());

            generator.setStatus(po.getStatus());

            generator.setReleaseVersion(po.getReleaseVersion());

            generator.setReleaseTime(po.getReleaseTime());

            generator.setDevelopTime(po.getDevelopTime());

            generator.setEngineType(po.getEngineType());

            generator.setDescription(po.getDescription());

            generator.setCreateTime(po.getCreateTime());

            generator.setUpdateTime(po.getUpdateTime());

            records.add(generator);
        });

        if(!userMap.isEmpty()){
            UserQuery userQuery = new UserQuery();
            userQuery.setIdList(new ArrayList<>(userMap.keySet()));
            List<UserPo> userPos = userDao.selectList(userQuery);
            userPos.forEach(po -> {
                String id = po.getId();
                User user = userMap.get(id);
                user.setId(id);
                user.setUsername(po.getUsername());
            });
        }

        return pageResult;
    }

    /**
     * 生成器导出
     */
    @Transactional
    public Generator export(GeneratorExportParameter parameter) {
        generatorServiceTool.exportValidate(parameter);
    
        Auth auth = parameter.getAuth();

        Generator generator = new Generator();

        return generator;
    }
    
    /**
     * 生成器导入
     */
    @Transactional
    public Generator import_(GeneratorImportParameter parameter) {
        generatorServiceTool.importValidate(parameter);
    
        Auth auth = parameter.getAuth();

        Generator generator = new Generator();

        return generator;
    }
    
    /**
     * 生成器分页查询
     */
    @Transactional
    public PageResult<Generator> infoSearch(GeneratorInfoSearchParameter parameter) {
        generatorServiceTool.infoSearchValidate(parameter);

        Auth auth = parameter.getAuth();
        String authUserId = auth.getUserId();

        GeneratorSearchParameter generatorSearchParameter = new GeneratorSearchParameter();
        BeanUtils.copyProperties(parameter, generatorSearchParameter);
        generatorSearchParameter.setUserId(authUserId);

        return this.search(generatorSearchParameter);
    }
    
    /**
     * 生成器发布
     */
    @Transactional
    public Generator release(GeneratorReleaseParameter parameter) {
        generatorServiceTool.releaseValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        String authUserId = auth.getUserId();

        String id = parameter.getId();
        GeneratorPo generatorPo = generatorDao.selectById(id);
        if(generatorPo == null || generatorPo.getIsDeleted() || !generatorPo.getUserId().equals(authUserId)){
            throw new BusinessException("生成器不存在");
        }

        TemplateFileBuildResourceParameter templateFileBuildResourceParameter = new TemplateFileBuildResourceParameter();
        templateFileBuildResourceParameter.setAuth(auth);
        templateFileBuildResourceParameter.setGeneratorId(id);
        templateFileService.buildResource(templateFileBuildResourceParameter);

        generatorPo.setStatus(GeneratorStatusEnum.RELEASE.getCode());
        generatorPo.setReleaseTime(now);
        generatorPo.setReleaseVersion(generatorPo.getReleaseVersion() + 1);
        generatorPo.setUpdateTime(now);
        generatorDao.update(generatorPo);

        Generator generator = new Generator();
        generator.setReleaseTime(now);

        return generator;
    }
    
}