package com.example.demo.service.impl;

import com.example.demo.model.Facility;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.service.FacilityService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository repository;

    public FacilityServiceImpl(FacilityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Facility save(Facility facility) {
        return repository.save(facility);
    }

    @Override
    public List<Facility> findAll() {
        return repository.findAll();
    }

    @Override
    public Facility findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Facility not found with id " + id));
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Facility not found with id " + id);
        }
        repository.deleteById(id);
    }
}
