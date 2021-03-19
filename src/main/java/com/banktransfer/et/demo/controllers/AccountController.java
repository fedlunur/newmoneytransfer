package com.banktransfer.et.demo.controllers;

import com.banktransfer.et.demo.domains.Account;
import com.banktransfer.et.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // make this class controller
@RequestMapping("/api/account") // tell the api ..
// http methods get, put,delete
public class AccountController {
    @Autowired  //
    private AccountRepository accrep;
    

    // the method create account is not interface method
    @PostMapping(value = "/create" , produces = "application/json")
    public Account createAccount(@RequestBody Account acc)
    {
        System.out.println("the  data is saved check out");
         return  accrep.save(acc);

    }

}
