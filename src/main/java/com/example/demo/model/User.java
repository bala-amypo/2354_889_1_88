package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String role;

    @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL)
    private ApartmentUnit apartmentUnit;

    // ================= TESTCASE REQUIRED CONSTRUCTORS =================

    // Used in many tests
    public User(Long id, String name, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Used in JPA mapping tests
    public User(Long id, String name, String email, String password,
                String role, ApartmentUnit apartmentUnit) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.apartmentUnit = apartmentUnit;
    }
}
