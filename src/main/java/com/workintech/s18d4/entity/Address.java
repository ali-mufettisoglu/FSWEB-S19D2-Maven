package com.workintech.s18d4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long id;

    @Column(name="street")
    String street;

    @Column(name="no")
    Integer no;

    @Column(name="city")
    String city;

    @Column(name="country")
    String country;

    @Column(name="description")
    String description;

    @OneToOne(mappedBy = "address")
    Customer customer;
}
