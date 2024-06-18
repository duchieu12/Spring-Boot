package com.ntd.pratice.dto;

import com.ntd.pratice.entity.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class AccountDTO {
    private String username;
    private String firstName;
    private String lastName;
    private String role;
    private String departmentName;
    private int departmentTotalMember;
    private String departmentType;
    private Date departmentCreatedDate;
}
