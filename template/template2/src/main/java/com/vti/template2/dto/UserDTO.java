package com.vti.template2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private String username;

//    private List<AddressDTO> addresses;
//
//    @NoArgsConstructor
//    @Getter
//    @Setter
//    public static class AddressDTO {
//        private String street;
//        private String city;
//    }

    private List<UserAddressDTO> addresses;

    @NoArgsConstructor
    @Getter
    @Setter
    public static class UserAddressDTO {
        private String addressStreet;
        private String addressCity;
        private Date registeredAt;
    }
}
