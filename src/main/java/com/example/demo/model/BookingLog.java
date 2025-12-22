package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "booking_log")
public class BookingLog {

     @Id
    @GeneratedValue
    private Long id;

    private String message;

    public BookingLog() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
