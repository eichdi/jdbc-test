package ru.test.jdbc.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.test.jdbc.user.model.User;
import ru.test.jdbc.user.service.UsersService;

import java.util.List;

/**
 * Created by SOTI on 27.06.2016 15:38.
 */
@Controller
public class UserController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    ResponseEntity<List<User>> getAllUsers(@RequestHeader(value = "ORIGIN") String origin){
        MultiValueMap<String, String> headers = prepareHeadersWithAllow(origin);
        return new ResponseEntity(usersService.getAllUsers(), headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/user")

    private MultiValueMap<String, String> prepareHeadersWithAllow(String origin) {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.set("Access-Control-Allow-Origin", origin);
        return headers;
    }





}
