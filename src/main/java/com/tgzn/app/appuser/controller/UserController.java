package com.tgzn.app.appuser.controller;

import com.tgzn.app.appuser.service.UserService;
import com.tgzn.app.common.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@Api("用户模块")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value="获取用户基本信息")
    @GetMapping("getUserBaseInfo")
    public ServerResponse getUserBaseInfo(Integer userId){
        return userService.getUserBaseInfo(userId);
    }

    @ApiOperation(value="修改密码")
    @PostMapping("modifyPassword")
    public ServerResponse modifyPassword(Integer userId, String oldPassword, String newPassword) {
        return userService.modifyPassword(userId, oldPassword, newPassword);
    }


}
