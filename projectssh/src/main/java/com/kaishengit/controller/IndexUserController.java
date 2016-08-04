package com.kaishengit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lhn on 2016/7/30.
 */
@Controller
public class IndexUserController {
    @RequestMapping(method = RequestMethod.GET)
    public String indexPage(){

        return "/login";
    }
}
