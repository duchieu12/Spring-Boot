package com.vti.testing.entity;

import com.vti.testing.converter.DepartmentTypeConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Department")
@NoArgsConstructor
@Getter
@Setter
public class Department {
    @Id // PRIMARY KEY
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT

//    @GenericGenerator(
//            name = "generator1",
//            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//            parameters = {
//                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "5"),
//                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1"),
//            }
//    )
//    @GeneratedValue(generator = "generator1")

//    @GeneratedValue(strategy = GenerationType.AUTO)

    @GenericGenerator(
            name = "generator",
            strategy = "com.vti.testing.generator.DepartmentIdGenerator"
    )

    @GeneratedValue(generator = "generator")
    @Column(name = "DepartmentID")
    private int id;

    @Column(name = "DepartmentName", nullable = false, unique = true)
    private String name;

    @Column(name = "TotalMember")
    private int totalMember;

    @Column(name = "`type`")
//    @Enumerated(EnumType.STRING)
    @Convert(converter = DepartmentTypeConverter.class)
    private Type type;
}
