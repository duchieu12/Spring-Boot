package com.vti.template3.form;

import com.vti.template3.entity.Department;
import com.vti.template3.validate.AccountUsernameNotExists;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
public class CreateAccountForm {
    @Length(max = 50, message = "User name is max 50")
    @NotBlank(message = "User name must not null")
    @AccountUsernameNotExists
    private String username;
    private int departmentId;
}
