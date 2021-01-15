package cn.iocoder.springboot.lab01.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("")
public class ErrorController {

    @PermitAll
    @GetMapping("/error")
    public String error() {
        return "错误页面";
    }
}
