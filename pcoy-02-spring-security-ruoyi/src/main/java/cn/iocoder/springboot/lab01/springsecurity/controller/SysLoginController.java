package cn.iocoder.springboot.lab01.springsecurity.controller;

import cn.iocoder.springboot.lab01.springsecurity.constant.AuthConstant;
import cn.iocoder.springboot.lab01.springsecurity.model.AjaxResult;
import cn.iocoder.springboot.lab01.springsecurity.service.security.SysLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录验证
 *
 * @author com.ruoyi
 */
@RestController
public class SysLoginController {

    @Autowired
    private SysLoginService loginService;

    /**
     * 登录方法
     *
     * @param username 用户名
     * @param password 密码
     * @param code     验证码
     * @param uuid     唯一标识
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(String username, String password, String code, String uuid) {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(username, password, code, uuid);
        ajax.put(AuthConstant.TOKEN, token);
        return ajax;
    }
}
