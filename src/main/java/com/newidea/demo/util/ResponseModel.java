package com.newidea.demo.util;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ResponseModel {
    private String message;
    private Object data;
    private int status;
    private String path;
    private String requestId;

    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();

    public ResponseModel(String message, Object data, int status, String path, String requestId) {
        this.message = message;
        this.data = data;
        this.status = status;
        this.path = path;
        this.requestId = requestId;
        this.timestamp = LocalDateTime.now();
    }

    public ResponseModel() {
        this.timestamp = LocalDateTime.now();
    }
}


