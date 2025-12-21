package com.example.demo.service.impl;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.service.ApartmentUnitService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    private final ApartmentUnitRepository repository;

    public ApartmentUnitServiceImpl(ApartmentUnitRepository repository) {
        this.repository = repository;
    }

    @Override
    public ApartmentUnit save(ApartmentUnit unit) {
        return repository.save(unit);
    }

    @Override
    public List<ApartmentUnit> findAll() {
        return repository.findAll();
    }

    @Override
    public ApartmentUnit findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ApartmentUnit not found with id " + id));
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("ApartmentUnit not found with id " + id);
        }
        repository.deleteById(id);
    }
}
package com.example.demo.service.impl;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.service.ApartmentUnitService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    private final ApartmentUnitRepository repository;

    public ApartmentUnitServiceImpl(ApartmentUnitRepository repository) {
        this.repository = repository;
    }

    @Override
    public ApartmentUnit save(ApartmentUnit unit) {
        return repository.save(unit);
    }

    @Override
    public List<ApartmentUnit> findAll() {
        return repository.findAll();
    }

    @Override
    public ApartmentUnit findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ApartmentUnit not found with id " + id));
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("ApartmentUnit not found with id " + id);
        }
        repository.deleteById(id);
    }
}
