package com.vti.testing.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "department")
@NoArgsConstructor
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DepartmentID")
    private int id;

    @Column(name = "DepartmentName", nullable = false, unique = true)
    private String name;

    @Column(name = "TotalMember")
    private byte totalMember;
}
