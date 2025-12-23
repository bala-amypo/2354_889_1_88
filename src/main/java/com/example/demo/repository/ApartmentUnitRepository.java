package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.*;
import java.util.Optional;

public interface ApartmentUnitRepository extends JpaRepository<ApartmentUnit, Long> {
    boolean existsByUnitNumber(String unitNumber);
    Optional<ApartmentUnit> findByOwner(User user);
}