package cn.iocoder.springboot.lab01.springsecurity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/demo")
    public String demo() {
        log.error("测试日志打印debug-----error msg: 1212");
        log.debug("测试日志打印--------debug");
        log.info("你好，测试lombok注解打印日志-----info");
        return "示例返回";
    }

}
