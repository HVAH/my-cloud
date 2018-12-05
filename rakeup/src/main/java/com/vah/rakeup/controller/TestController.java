package com.vah.rakeup.controller;

import com.vah.rakeup.oauth2.Secure;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestController {

    @Secure
    @PostMapping(path = { "/test/test" })
    public String order(
            )throws Exception {

        return "test";
    }

    @Secure("/product")
    @PostMapping(path = { "/product/test" })
    public String product(
            )throws Exception {

        return "product";
    }

    @Secure("/car")
    @PostMapping(path = { "/car/test" })
    public String method(
    )throws Exception {

        return "/car";
    }

    @GetMapping(path = {"/login"})
    public ModelAndView aa(ModelAndView modelAndView) {
        modelAndView.setViewName("login.html");
        return modelAndView;
    }
}
