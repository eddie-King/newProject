package com.newidea.demo.controller;

import com.newidea.demo.common.LoginModel;
import com.newidea.demo.common.ResponseModel;
import com.newidea.demo.entity.UserInfo;
import com.newidea.demo.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseModel login(@RequestBody LoginModel loginModel, HttpServletRequest request, HttpServletResponse response){
        return authService.loginWebService(loginModel, request, response);
    }
    @PostMapping("/signup")
    public ResponseModel signup(@RequestBody UserInfo loginModel, HttpServletRequest request, HttpServletResponse response){
        return authService.signupWebService(loginModel, request, response);
    }
}
