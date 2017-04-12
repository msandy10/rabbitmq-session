package com.spring.session.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.session.redis.repository.CacheService;

@RestController
public class MessageController {
    @Autowired
    private CacheService cacheService;
    
    @RequestMapping(value = "/message",method = RequestMethod.GET)
    @ResponseBody
    public List<String> greeting(@RequestParam(required=false) String user) {
        List<String> messages = cacheService.listMessages(user);
        return messages;
    }
    @RequestMapping(value = "/message",method = RequestMethod.POST)
    @ResponseBody
    public String saveGreeting(String user,String message) {
        cacheService.addMessage(user,message);
        return "OK";
    }
}