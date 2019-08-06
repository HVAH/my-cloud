package com.mall.study;

import com.vah.component.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/8/5 17:43
 * @Version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class StarterTest {
    private @Autowired
    User user;

    @Test
    public void testStarter() {
        System.out.println(user.toString());
        System.out.println(user.toString());
    }
}
