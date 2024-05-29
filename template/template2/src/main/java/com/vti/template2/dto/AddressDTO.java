package com.vti.template2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vti.template2.entity.UserAddress;
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
    private List<UserAddressDTO> userAddresses;

    @NoArgsConstructor
    @Getter
    @Setter
    public static class UserAddressDTO {
        @JsonProperty("username")
        private String userUsername;
        @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
        private Date registerAt;
    }

//    private List<UserDTO> users;
//
//    @NoArgsConstructor
//    @Getter
//    @Setter
//    public static class UserDTO {
//        private String username;
//    }

//    private List<UserAddressDTO> userAddresses;
//    @NoArgsConstructor
//    @Getter
//    @Setter
//    public static class UserAddressDTO {
//        @JsonProperty("username")
//        private String userUsername;
//        private String registeredAt;
//    }
}
