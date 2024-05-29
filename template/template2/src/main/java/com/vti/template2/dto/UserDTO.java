package com.vti.template2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vti.template2.entity.Address;
import com.vti.template2.entity.UserAddress;
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
    private List<UserAddressDTO> userAddresses;

    @NoArgsConstructor
    @Getter
    @Setter
    public static class UserAddressDTO {
        @JsonProperty("street")
        private String addressStreet;
        @JsonProperty("city")
        private String addressCity;
        @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
        private Date registerAt;
    }

//        private List<AddressDTO> addresses;
//    @NoArgsConstructor
//    @Getter
//    @Setter
//    public static class AddressDTO {
//        private String street;
//        private String city;
//    }

//    private List<UserAddressDTO> addresses;
//
//    @NoArgsConstructor
//    @Getter
//    @Setter
//    public static class UserAddressDTO {
//        private String addressStreet;
//        private String addressCity;
//        private Date registeredAt;
//    }
}
