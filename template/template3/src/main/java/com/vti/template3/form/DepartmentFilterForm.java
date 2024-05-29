package com.vti.template3.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DepartmentFilterForm {
    private int minTotalMember;
    private int maxTotalMember;
}
