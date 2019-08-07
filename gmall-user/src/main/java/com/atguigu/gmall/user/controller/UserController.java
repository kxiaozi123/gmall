package com.atguigu.gmall.user.controller;

import com.atguigu.gmall.user.bean.UmsMember;
import com.atguigu.gmall.user.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/getAll")
    public List<UmsMember> getAllUser(){
       return userService.getAllUser();
    }
    @GetMapping("/getReceiveAddressByMemberId/{id}")
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(@PathVariable("id") String memberId){
        return userService.getReceiveAddressByMemberId(memberId);
    }
}