package pers.laineyc.blackdream.usercenter.tool;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.framework.exception.ErrorCodes;
import pers.laineyc.blackdream.usercenter.dao.UserAuthDao;
import pers.laineyc.blackdream.usercenter.dao.po.UserAuthPo;
import pers.laineyc.blackdream.usercenter.dao.query.UserAuthQuery;
import pers.laineyc.blackdream.usercenter.model.AccessToken;
import pers.laineyc.blackdream.usercenter.model.AccessTokenBody;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

/**
 * @author LaineyC
 */
@Component
public class AccessTokenTool {

    @Autowired
    private UserAuthDao userAuthDao;

    private static final String STATIC_SECRET = "BlackDream";

    public String format(AccessToken accessToken){
        AccessTokenBody accessTokenBody = accessToken.getBody();
        String userId = accessTokenBody.getUserId();
        String secret = getSecret(userId);

        String payload = JSON.toJSONString(accessToken);
        String payloadBase64 = this.encodeBase64(payload);
        String sign = this.sign(payload, secret);
        String signBase64 =  this.encodeBase64(sign);
        return payloadBase64 + "." + signBase64;
    }

    public AccessToken parse(String tokenString){
        if(!tokenString.contains(".")){
            throw new BusinessException(ErrorCodes.EC_001002);
        }
        String[] tokenArray = tokenString.split("\\.");
        String payloadBase64 = tokenArray[0];
        String payload = this.decodeBase64(payloadBase64);
        String signBase64 = tokenArray[1];
        String sign = this.decodeBase64(signBase64);

        AccessToken accessToken = JSON.parseObject(payload, AccessToken.class);
        Date expiryTime = accessToken.getExpiryTime();
        if(new Date().after(expiryTime)){
            throw new BusinessException(ErrorCodes.EC_001002);
        }

        AccessTokenBody accessTokenBody = accessToken.getBody();
        String userId = accessTokenBody.getUserId();
        String secret = getSecret(userId);

        String signNow = this.sign(payload, secret);
        if(!signNow.equals(sign)){
            throw new BusinessException(ErrorCodes.EC_001002);
        }

        return accessToken;
    }

    private String getSecret(String userId){
        UserAuthQuery userAuthQuery = new UserAuthQuery();
        userAuthQuery.setUserId(userId);
        UserAuthPo userAuthPo = userAuthDao.selectOne(userAuthQuery);
        if(userAuthPo == null){
            throw new BusinessException(ErrorCodes.EC_001002);
        }

        return STATIC_SECRET + userAuthPo.getPassword();
    }

    private String encodeBase64(String str){
        try {
            return new String(Base64.getEncoder().encode(str.getBytes("UTF-8")), "UTF-8");
        }
        catch (Exception e){
            throw new BusinessException(ErrorCodes.EC_001002);
        }
    }

    private String decodeBase64(String str){
        try {
            return new String(Base64.getDecoder().decode(str.getBytes("UTF-8")), "UTF-8");
        }
        catch (Exception e){
            throw new BusinessException(ErrorCodes.EC_001002);
        }
    }

    /**
     * HmacSHA256(payload, secret)
     */
    private String sign(String payload, String secret){
        String sign;
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256");
            sha256_HMAC.init(secretKey);
            byte[] bytes = sha256_HMAC.doFinal(payload.getBytes("UTF-8"));
            sign = new String(bytes, "UTF-8");
        }
        catch (Exception e){
            throw new BusinessException(ErrorCodes.EC_001002);
        }
        return sign;
    }
}
