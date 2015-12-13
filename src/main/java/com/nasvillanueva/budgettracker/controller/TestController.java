package com.nasvillanueva.budgettracker.controller;

import com.nasvillanueva.budgettracker.model.entity.UserAccount;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by NazIsEvil on 13/12/2015.
 */
@Controller
@RequestMapping("/")
public class TestController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String helloWorld() {
        UserAccount userAccount = new UserAccount();
        System.out.println(userAccount);
        return "Hello World!";
    }
}
