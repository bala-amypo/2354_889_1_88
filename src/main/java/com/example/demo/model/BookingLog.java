package com.example.demo.entity;

import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking_logs")
public class BookingLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @Column(nullable = false, length = 500)
    private String logMessage;

    @Column(nullable = false)
    private LocalDateTime loggedAt;
    public BookingLog() {
    }
    public BookingLog(Booking booking, String logMessage) {
        this.booking = booking;
        this.logMessage = logMessage;
    }
    @PrePersist
    private void onCreate() {
        this.loggedAt = LocalDateTime.now();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    public void setLoggedAt(LocalDateTime loggedAt) {
        this.loggedAt = loggedAt;
    }
}
