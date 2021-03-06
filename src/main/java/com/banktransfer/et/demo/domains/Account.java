package com.banktransfer.et.demo.domains;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Integer pin;

    private Double balance = 0.0;

    private Boolean isVerified = true;
}
