package com.vti.template3.form;

import com.vti.template3.entity.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class UpdateDepartmentForm {
    private String name;
    private int totalMember;
    private Type type;
    private Date createdDate;
}
