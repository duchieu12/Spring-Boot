package com.ntd.review.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class UpdateUserForm {
    @NotBlank(message = "Password must not blank!")
    @Size(min = 6, max = 50, message = "Password must be at least 6 characters")
    private String password;

    private String firstName;
    private String lastName;
    private Date dob;
}
