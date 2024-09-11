package com.newidea.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Data

public final class ResponseStatus {
    private String code;
    private String message;
    private HttpStatus httpCode;

}
