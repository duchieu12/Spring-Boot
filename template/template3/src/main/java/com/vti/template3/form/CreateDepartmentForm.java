package com.vti.template3.form;

import com.vti.template3.validate.DepartmentNameNotExists;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CreateDepartmentForm {
    @Length(max = 50, message = "Department name is max 50")
    @NotBlank(message = "Department name must not blank")
    @DepartmentNameNotExists
    private String name;

    @PositiveOrZero(message = "Total member must greater than or equal 0")
    private int totalMember;

    @Pattern(regexp = "Dev|Test|ScrumMaster|PM", message = "Type must be Dev, Test, ScrumMaster or PM")
    private String type;

    private List<@Valid Account> accounts;

    @NoArgsConstructor
    @Getter
    @Setter
    private static class Account {
        @Length(max = 50, message = "Username is max 50")
        @NotBlank(message = "Username must not null")
//        @UsernameNotExists
        private String username;
    }
}
