package com.newidea.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
}
