package org.productapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

    @RequestMapping(value = "/helloworld",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public String helloWorld(){
        return "Hello World";
    }
}
