package com.ntd.review.form;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class CreateUserForm {
    @NotBlank(message = "Username must not blank!")
    @Size(min = 3, max = 50, message = "Username must be at least 3 characters")
    private String username;

    @NotBlank(message = "Password must not blank!")
    @Size(min = 6, max = 50, message = "Password must be at least 6 characters")
    private String password;

    private String firstName;
    private String lastName;
    private Date dob;
}
