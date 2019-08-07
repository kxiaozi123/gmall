package com.atguigu.gmall.user.controller;
import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.user.bean.UmsMember;
import com.atguigu.gmall.user.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.user.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Reference
    UserService userService;
    @GetMapping("/getAll")
    public List<UmsMember> getAllUser(){
        return userService.getAllUser();
    }
    @GetMapping("/getReceiveAddressByMemberId/{id}")
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(@PathVariable("id") String memberId){
        return userService.getReceiveAddressByMemberId(memberId);
    }





}
