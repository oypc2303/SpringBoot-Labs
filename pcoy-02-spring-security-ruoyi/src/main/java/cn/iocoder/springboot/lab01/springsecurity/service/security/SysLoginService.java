package cn.iocoder.springboot.lab01.springsecurity.service.security;

import cn.iocoder.springboot.lab01.springsecurity.constant.AuthConstant;
import cn.iocoder.springboot.lab01.springsecurity.model.LoginUser;
import cn.iocoder.springboot.lab01.springsecurity.redis.RedisCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import sun.security.krb5.internal.AuthContext;

import javax.annotation.Resource;

/**
 * 登录校验方法
 *
 * @author com.ruoyi
 */
@Slf4j
@Component
public class SysLoginService {

    @Autowired
    private TokenService tokenService;

    @Resource
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    /**
     * 登录验证
     *
     * @param username 用户名
     * @param password 密码
     * @param code     验证码
     * @param uuid     唯一标识
     * @return 结果
     */
    public String login(String username, String password, String code, String uuid) {
        // 用户验证
        Authentication authentication = null;
        try {
            // 该方法会去调用 UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
        }
        // 生成 Token
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        return tokenService.createToken(loginUser);
    }

}
