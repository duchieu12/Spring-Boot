package com.vti.template.entity;

import com.vti.template.converter.ArticleStatusConverter;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "department")
@NoArgsConstructor
@Getter
@Setter
@IdClass(DepartmentPK.class)
public class Department implements Serializable {
//    @Column(name = "department_id", insertable = false, updatable = false)
//    @Id

//    Option 1
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

//    Option 2
//    @GenericGenerator(
//            name = "generator1",
//            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//            parameters = {
//                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "100")
//            }
//    )
//    @GeneratedValue(generator = "generator1")

//    Option 3
//    @GeneratedValue(strategy = GenerationType.AUTO)

    @Id
    private int departmentId;
    @Id
    private int groupId;

    @Column(name = "department_name", nullable = false, unique = true)
    private String name;

    @Column(name = "total_member")
    private int totalMember;

//    @Column(name = "created_date", updatable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreationTimestamp
//    private Date created_date;

    @Column(name = "type")
    @Convert(converter = ArticleStatusConverter.class)
//    @Enumerated(EnumType.STRING)
    private Type type;

//    @Column(name = "department_code")
//    @GenericGenerator(
//            name = "generator",
//            strategy = "com.vti.template.generator.DepartmentCodeGenerator"
//    )
//    @GeneratedValue(generator = "generator")
//    private String code;
}
