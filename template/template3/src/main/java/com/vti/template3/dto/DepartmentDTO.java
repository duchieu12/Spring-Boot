package com.vti.template3.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vti.template3.entity.Account;
import com.vti.template3.entity.Type;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;
    private List<AccountDTO> accounts;

    @NoArgsConstructor
    @Getter
    @Setter
    private static class AccountDTO {
        private String username;
    }
}
