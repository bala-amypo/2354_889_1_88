package com.example.demo.entity;

public class user{
    @Id
    private Long id;
    private String name;
    @Column(unique=true)
    private String email;
    private String ADMIN;
    private String RESIDENT
}