package com.vti.testing.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DepartmentFilterForm {
    private String search; // departmentName
    private int minTotalMember;
    private int maxTotalMember;
}
