package com.animal.animal.community.controller;


import com.animal.animal.community.pojo.User;
import com.animal.animal.community.result.Result;
import com.animal.animal.community.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;


@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestUser.getPassword());
        if (null == user) {
            System.out.println("Error");
            return new Result(400);
        } else {
            System.out.println("Succeed");
            //后端拦截器
//            Session.setAttribute("user", user);
            return new Result(200);
        }
    }
}