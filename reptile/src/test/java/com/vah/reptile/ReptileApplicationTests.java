package com.vah.reptile;

import com.vah.reptile.collection.BaiDuPoemPageProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReptileApplicationTests {
    private @Resource
    BaiDuPoemPageProcessor baiDuPoemPageProcessor;

    @Test
    public void contextLoads() {
        baiDuPoemPageProcessor.reptile();
    }

}
