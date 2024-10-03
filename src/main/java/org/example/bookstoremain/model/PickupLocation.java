package org.example.bookstoremain.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
public class PickupLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String city;
    private String postalCode;
}
