package com.vti.template2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class UserAddressPK implements Serializable {
    @Column(name = "user_id")
    private int userId;

    @Column(name = "address_id")
    private int addressId;
}
