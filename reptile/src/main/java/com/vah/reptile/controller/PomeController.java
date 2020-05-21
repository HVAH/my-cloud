package com.vah.reptile.controller;

import com.vah.reptile.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description
 * @Author Jiang
 * @Date 2019/11/15 1:55 下午
 * @Version 1.0
 **/
@RestController
@RequestMapping("/reptile")
public class PomeController {
    @Autowired
    private PoemService poemService;

    

}
