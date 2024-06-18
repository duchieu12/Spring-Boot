package com.ntd.pratice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ntd.pratice.entity.Account;
import com.ntd.pratice.entity.Role;
import com.ntd.pratice.entity.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class DepartmentDTO {
    private String name;
    private int totalMember;
    private String type;
    @JsonFormat(pattern = "HH:mm:ss dd/MM/yyyy")
    private Date createdDate;
    private List<AccountDTO> accounts;

    @NoArgsConstructor
    @Getter
    @Setter
    private static class AccountDTO {
        private String username;
        private String firstName;
        private String lastName;
        private String role;
    }
}
