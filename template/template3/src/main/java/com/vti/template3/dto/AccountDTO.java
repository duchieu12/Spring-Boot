package com.vti.template3.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vti.template3.entity.Department;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class AccountDTO {
    private String username;
    private String departmentName;
    private String departmentTotalMember;
    private String departmentType;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date departmentCreatedDate;
}
