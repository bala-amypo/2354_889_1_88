package com.example.demo.service;

import com.example.demo.model.ApartmentUnit;
import java.util.List;

public interface ApartmentUnitService {

    ApartmentUnit save(ApartmentUnit unit);

    List<ApartmentUnit> findAll();

    ApartmentUnit findById(Long id);

    void deleteById(Long id);
}
