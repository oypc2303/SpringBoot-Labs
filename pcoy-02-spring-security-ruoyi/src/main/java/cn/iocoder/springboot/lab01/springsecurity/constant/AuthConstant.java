package cn.iocoder.springboot.lab01.springsecurity.constant;

import cn.iocoder.springboot.lab01.springsecurity.model.SysUser;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: SpringBoot-Labs
 * @description: 认证常量类
 * @author: pcoy
 * @create: 2021-01-15 16:14
 **/
public class AuthConstant {
    /**
     * 令牌
     */
    public static final String TOKEN = "token";
    /**
     * 登录用户 redis key
     */
    public static final String LOGIN_TOKEN_KEY = "login_tokens:";

    /**
     * 令牌前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 令牌前缀
     */
    public static final String LOGIN_USER_KEY = "login_user_key";
    public static final String CAPTCHA_CODE_KEY = "code:key:";
    public static final Map<String, SysUser> userMap= new HashMap<String, SysUser>(10);
    static{
        userMap.put("admin", new SysUser(1L, "admin", "$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2"));
        userMap.put("user", new SysUser(2L, "user", "654321"));
        userMap.put("normal", new SysUser(3L, "normal", "111111"));
        userMap.put("dept", new SysUser(4L, "dept", "666666"));
    }
}
