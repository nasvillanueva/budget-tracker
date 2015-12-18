package com.nasvillanueva.budgettracker.controller;

import com.nasvillanueva.budgettracker.model.constants.Role;
import com.nasvillanueva.budgettracker.model.entity.UserAccount;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by NazIsEvil on 13/12/2015.
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<UserAccount> helloWorld() {
        UserAccount userAccount = new UserAccount();
        userAccount.setRole(Role.ADMIN);
        return new ResponseEntity<>(userAccount, HttpStatus.OK);
    }
}
