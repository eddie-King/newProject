package com.newidea.demo.service;

import com.newidea.demo.common.LoginModel;
import com.newidea.demo.common.ResponseModel;
import com.newidea.demo.entity.UserInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {
    ResponseModel loginWebService
            (LoginModel loginModel,
             HttpServletRequest request,
             HttpServletResponse response);

    ResponseModel signupWebService(UserInfo loginModel,
                                   HttpServletRequest request,
                                   HttpServletResponse response);
}
