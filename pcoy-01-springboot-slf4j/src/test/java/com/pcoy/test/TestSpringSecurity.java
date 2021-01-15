package com.pcoy.test;

import cn.iocoder.springboot.lab01.springsecurity.Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: SpringBoot-Labs
 * @description: TestSpringSecurity
 * @author: pcoy
 * @create: 2021-01-07 14:54
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestSpringSecurity {

    @Autowired
    SecurityProperties securityProperties;

    @Test
    public void TestSecurityProperties(){
        log.info("测试安全信息配置: {}" , securityProperties.getUser().getName());
    }
}
