package com.vti.template3.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LoginInfor {
    private String type = "Bearer";
    private String jwt;
    private int id;
    private String username;
    private String role;
}
