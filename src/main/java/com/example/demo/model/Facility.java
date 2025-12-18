package com.example.demo.entity;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(
    name = "facilities",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
    }
)
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @Pattern(
        regexp = "^([01]\\d|2[0-3]):([0-5]\\d)$",
        message = "Time must be in HH:mm format"
    )
    @Column(nullable = false)
    private String openTime;

    @Pattern(
        regexp = "^([01]\\d|2[0-3]):([0-5]\\d)$",
        message = "Time must be in HH:mm format"
    )
    @Column(nullable = false)
    private String closeTime;
    public Facility() {
    }
    public Facility(Long id, String name, String description, String openTime, String closeTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }
    @PrePersist
    @PreUpdate
    private void validateTime() {
        if (openTime != null && closeTime != null) {
            if (openTime.compareTo(closeTime) >= 0) {
                throw new IllegalArgumentException("Open time must be before close time");
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }
}
