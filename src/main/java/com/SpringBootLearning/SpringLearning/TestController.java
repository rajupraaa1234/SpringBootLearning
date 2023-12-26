package com.SpringBootLearning.SpringLearning;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
public class TestController {

    @RequestMapping("/test")
    public String firstHandler(){
        return "First method called";
    }
}
