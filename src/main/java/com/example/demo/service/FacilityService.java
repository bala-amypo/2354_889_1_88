package com.example.demo.service;

import com.example.demo.model.Facility;
import java.util.List;

public interface FacilityService {

    Facility save(Facility facility);

    List<Facility> findAll();

    Facility findById(Long id);

    void deleteById(Long id);
}
