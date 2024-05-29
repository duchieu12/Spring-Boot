package com.vti.template2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Address")
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "street", length = 50, nullable = false)
    private String street;

    @Column(name = "city", length = 50, nullable = false)
    private String city;

    @OneToMany(mappedBy = "address")
    private List<UserAddress> userAddresses;

//    @ManyToMany(mappedBy = "addresses")
//    @OneToMany(mappedBy = "address")
//    private List<UserAddress> userAddresses;
}
