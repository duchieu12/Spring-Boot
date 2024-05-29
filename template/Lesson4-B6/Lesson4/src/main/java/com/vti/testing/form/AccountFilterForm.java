package com.vti.testing.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AccountFilterForm {
    private String search;
    private int minId;
}
