package com.vti.template2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class AddressDTO {
    private String street;

    private String city;

//    private List<UserDTO> users;
//
//    @NoArgsConstructor
//    @Getter
//    @Setter
//    public static class UserDTO {
//        private String username;
//    }

    private List<UserAddressDTO> userAddresses;
    @NoArgsConstructor
    @Getter
    @Setter
    public static class UserAddressDTO {
        @JsonProperty("username")
        private String userUsername;
        private String registeredAt;
    }
}
