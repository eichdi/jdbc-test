package ru.test.jdbc.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.test.jdbc.user.model.User;
import ru.test.jdbc.user.service.UsersService;


import java.util.List;

/**
 * Created by SOTI on 27.06.2016 15:38.
 */
@Component
@RestController
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    public UsersService service;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity(service.getAllUsers(), null, HttpStatus.OK);
    }

    @RequestMapping(value = "/")
    String startPage(){
        System.out.print("it`s work!");
        return "start1";
    }
    //@RequestMapping(value = "/user")

    private MultiValueMap<String, String> prepareHeadersWithAllow(String origin) {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.set("Access-Control-Allow-Origin", origin);
        return headers;
    }





}
