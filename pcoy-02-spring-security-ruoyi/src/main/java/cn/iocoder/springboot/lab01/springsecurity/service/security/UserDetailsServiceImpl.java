package cn.iocoder.springboot.lab01.springsecurity.service.security;

import cn.iocoder.springboot.lab01.springsecurity.constant.AuthConstant;
import cn.iocoder.springboot.lab01.springsecurity.exception.BaseException;
import cn.iocoder.springboot.lab01.springsecurity.model.LoginUser;
import cn.iocoder.springboot.lab01.springsecurity.model.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: SpringBoot-Labs
 * @description: 用户服务实现类
 * @author: pcoy
 * @create: 2021-01-15 16:23
 **/
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = AuthConstant.userMap.get(username);

        if (StringUtils.isEmpty(user)) { // 用户不存在
            log.info("登录用户：{} 不存在.", username);
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        }

        //创建 Spring Security UserDetails 用户明细
        return createLoginUser(user);
    }

    public UserDetails createLoginUser(SysUser user) {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("system:user:list");
        hashSet.add("system:role:list");
        hashSet.add("system:menu:list");
        hashSet.add("system:dept:list");
        return new LoginUser(user, hashSet);
    }
}
