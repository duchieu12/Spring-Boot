package com.vti.testing.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class DepartmentDTO {
    private int id;
    private String name;
    private String totalMember;
    private String type;
    @JsonFormat(pattern = "HH:mm:ss dd-MM-yyyy")
    private Date createdDate;
    private List<AccountDTO> accounts;

    @NoArgsConstructor
    @Getter
    @Setter
    public static class AccountDTO {
        private String username;
    }
}
