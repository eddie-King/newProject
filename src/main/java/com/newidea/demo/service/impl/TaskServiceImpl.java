package com.newidea.demo.service.impl;
import com.newidea.demo.entity.Task;
import com.newidea.demo.repository.TaskRepository;
import com.newidea.demo.service.TaskService;
import com.newidea.demo.util.ResponseModel;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public ResponseModel create(Task entity, HttpServletRequest request) {
        try {
            Task task = taskRepository.findByGroupCode(entity.getGroupCode());
            if (task != null) return ResponseModel.builder().message("Student exist!").status(400).build();
            Task saveTask = taskRepository.save(entity);
            return ResponseModel.builder()
                    .message("Save successful")
                    .status(200)
                    .data(saveTask)
                    .build();
        } catch (Exception e) {
            return ResponseModel.builder().status(400).build();
        }

    }

    @Override
    public ResponseModel update(Task entity, HttpServletRequest request) {
        try {
            Task user = taskRepository.findById(entity.getId()).orElse(null);
            if (user == null) {
                return ResponseModel.builder()
                        .message("User not found!")
                        .status(400)
                        .build();
            }
            Task saveEntity = taskRepository.save(entity);
            return ResponseModel.builder()
                    .message("Updated successfully")
                    .data(saveEntity)
                    .status(200)
                    .build();
        } catch (Exception e) {
            return ResponseModel.builder()
                    .message("Error saving user: " + e.getMessage())
                    .status(400)
                    .build();
        }
    }

    @Override
    public ResponseModel getAll(HttpServletRequest request) {
        try {
            List<Task> tasks = taskRepository.findAll();
            if (!tasks.isEmpty()) {
                return ResponseModel.builder()
                        .message("Successful")
                        .data(tasks)
                        .status(200)
                        .build();
            }
        } catch (Exception e) {
            return ResponseModel.builder()
                    .message(e.getMessage())
                    .status(400).build();
        }
        return ResponseModel.builder().message("Empty").status(200).build();
    }

    @Override
    public ResponseModel delete(Long id, HttpServletRequest request) {
        try {
            if (taskRepository.existsById(id)) {
                taskRepository.deleteById(id);
                taskRepository.truncateTable();
                return ResponseModel.builder()
                        .message("User deleted successfully")
                        .status(200)
                        .build();
            }
        } catch (Exception e) {
            return ResponseModel.builder()
                    .message("Deleted error!")
                    .status(400)
                    .build();
        }
        return ResponseModel.builder().message("Can not found").status(200).build();
    }
    @Override
    public ResponseModel deleteAll(HttpServletRequest request) {
        List<Task> tasks = taskRepository.findAll();
        if (tasks.isEmpty()) {
            return ResponseModel.builder().message("Not found any user.").status(200).build();
        }
        taskRepository.truncateTable();
        return ResponseModel.builder()
                .message("Deleted all user successful")
                .status(200)
                .build();
    }
}
