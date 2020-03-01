package com.pro.study;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
* @author: wgl
* @date: 2020年3月1日下午8:55:41 
* @version:1.0
* @Description:角色单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProApiTest.class)
public class RoleTest {
    @Test
    public void test1() {
        System.out.println("test1");
    }
}