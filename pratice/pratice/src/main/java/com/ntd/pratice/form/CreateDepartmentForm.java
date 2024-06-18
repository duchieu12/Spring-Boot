package com.ntd.pratice.form;

import com.ntd.pratice.entity.Account;
import com.ntd.pratice.entity.Type;
import com.ntd.pratice.validate.DepartmentNameNotExists;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Parent;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CreateDepartmentForm {
    @NotBlank(message = "Department name must not null")
    @Length(max = 50)
    @DepartmentNameNotExists
    private String name;

    @Positive(message = "Department total member must greate than 0")
    private int totalMember;

    @NotBlank(message = "Department type must not null")
    @Pattern(regexp = "Dev|Test|ScrumMaster|PM", message = "Type must be Dev, Test, ScrumMaster or PM")
    private String type;

    private Date createdDate;
}
