package com.example.demo.entity;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;

@Entity
@Table(
    name = "apartment_units",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "unitNumber")
    }
)
public class ApartmentUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String unitNumber;
    @Min(value = 0, message = "Floor must be greater than or equal to 0")
    private Integer floor;
    @OneToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;
    public ApartmentUnit() {
    }
    public ApartmentUnit(Long id, String unitNumber, Integer floor, User owner) {
        this.id = id;
        this.unitNumber = unitNumber;
        this.floor = floor;
        this.owner = owner;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
