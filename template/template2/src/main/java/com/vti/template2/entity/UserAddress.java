package com.vti.template2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
//@IdClass(UserAddressPK.class)
public class UserAddress {
//    @Id
//    private int userId;
//    @Id
//    private int addressId;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    @MapsId("user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
//    @MapsId("address_id")
    private Address address;

    @Column(name = "registered_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date registeredAt;
}
