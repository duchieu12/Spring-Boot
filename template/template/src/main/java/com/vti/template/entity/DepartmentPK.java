package com.vti.template.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class DepartmentPK implements Serializable {
    @Column(name = "department_id")
    private int departmentId;

    @Column(name = "group_id")
    private int groupId;
}
