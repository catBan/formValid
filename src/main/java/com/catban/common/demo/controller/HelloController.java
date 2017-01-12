package com.catban.common.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by catban on 16-11-26.
 */

@Controller
@RequestMapping(value="/hello")
public class HelloController {

    @RequestMapping("/mvc")
    public String helloWorld(){
        Map<String,String> sd = new HashMap<String, String>();
        List<Object> f = new ArrayList();
        f.add(3);
        f.add("dsasd");
        return "home";
    }
}
