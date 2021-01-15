package cn.iocoder.springboot.lab01.springsecurity.service.handle;

import cn.iocoder.springboot.lab01.springsecurity.constant.HttpStatus;
import cn.iocoder.springboot.lab01.springsecurity.model.AjaxResult;
import cn.iocoder.springboot.lab01.springsecurity.model.LoginUser;
import cn.iocoder.springboot.lab01.springsecurity.service.security.TokenService;
import cn.iocoder.springboot.lab01.springsecurity.util.ServletUtils;
import cn.iocoder.springboot.lab01.springsecurity.util.StringUtils;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义退出处理类 返回成功
 *
 * @author com.ruoyi
 */
@Configuration
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {

    @Autowired
    private TokenService tokenService;

    /**
     * 退出处理
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        // 获得当前 LoginUser
        LoginUser loginUser = tokenService.getLoginUser(request);
        // 如果有登陆的情况下
        if (StringUtils.isNotNull(loginUser)) {
            String userName = loginUser.getUsername();
            // 删除用户缓存记录
            tokenService.delLoginUser(loginUser.getToken());
            // 记录用户退出日志
        }
        // 响应退出成功
        ServletUtils.renderString(response, JSON.toJSONString(AjaxResult.error(HttpStatus.SUCCESS, "退出成功")));
    }

}
