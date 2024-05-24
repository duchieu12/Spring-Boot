package com.vti.template2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "User")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    private String username;

//    @ManyToMany
//    @JoinTable(
//            name = "UserAddress",
//            joinColumns = {
//                    @JoinColumn(name = "user_id", referencedColumnName = "id"),
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "address_id", referencedColumnName = "id")
//            }
//    )

    @OneToMany(mappedBy = "user")
    private List<UserAddress> userAddresses;
}
