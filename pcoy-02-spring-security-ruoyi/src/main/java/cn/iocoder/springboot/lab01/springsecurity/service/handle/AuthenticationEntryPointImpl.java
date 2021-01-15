package cn.iocoder.springboot.lab01.springsecurity.service.handle;

import cn.iocoder.springboot.lab01.springsecurity.constant.HttpStatus;
import cn.iocoder.springboot.lab01.springsecurity.model.AjaxResult;
import cn.iocoder.springboot.lab01.springsecurity.util.ServletUtils;
import com.alibaba.fastjson.JSON;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * 认证失败处理类 返回未授权
 *
 * @author com.ruoyi
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -8970718410437077606L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
        // 响应认证不通过
        int code = HttpStatus.UNAUTHORIZED;

        String msg = "请求访问："+request.getRequestURI()+"，认证失败，无法访问系统资源";
        ServletUtils.renderString(response, JSON.toJSONString(AjaxResult.error(code, msg)));
    }

}
