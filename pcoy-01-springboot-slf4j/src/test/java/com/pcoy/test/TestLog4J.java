package com.pcoy.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.regex.Pattern;

/**
 * @program: SpringBoot-Labs
 * @description: Lombok插件，打印日志功能（记得安装插件哦！！！）
 * @author: pcoy
 * @create: 2021-01-06 10:29
 **/
@Slf4j
public class TestLog4J {

    //参考https://blog.csdn.net/u012129558/article/details/79947477
    @Test
    public void testPrintLog() {
        log.trace("======trace");
        log.debug("======debug");
        log.info("======info");
        log.warn("======warn");
        log.error("======error");
    }

    private static final Pattern PASSWORD_ALGORITHM_PATTERN = Pattern.compile("^\\{.+}.*$");
    @Test
    public void testRegular() {
        String password = "{MD5}user";
        log.info("正则表达式匹配结果： {}" ,PASSWORD_ALGORITHM_PATTERN.matcher(password).matches());
    }

}
