package com.example.demo.controller;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/units")
public class ApartmentUnitController {

    private final ApartmentUnitService service;

    public ApartmentUnitController(ApartmentUnitService service) {
        this.service = service;
    }

    @PostMapping
    public ApartmentUnit createUnit(@RequestBody ApartmentUnit unit) {
        return service.save(unit);
    }

    @GetMapping
    public List<ApartmentUnit> getAllUnits() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ApartmentUnit getUnitById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUnit(@PathVariable Long id) {
        service.deleteById(id);
        return "Apartment unit deleted successfully";
    }
}
