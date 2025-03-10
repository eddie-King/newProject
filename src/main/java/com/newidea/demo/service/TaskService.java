package com.newidea.demo.service;

import com.newidea.demo.entity.Task;
import com.newidea.demo.util.ResponseModel;
import jakarta.servlet.http.HttpServletRequest;

public interface TaskService {
    ResponseModel create(Task entity, HttpServletRequest request);
    ResponseModel update(Task entity, HttpServletRequest request);
    ResponseModel getAll(HttpServletRequest request);
    ResponseModel delete(Long id, HttpServletRequest request);
    ResponseModel deleteAll(HttpServletRequest request);
}

