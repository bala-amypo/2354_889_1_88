package com.example.demo.controller;

import com.example.demo.model.Facility;
import com.example.demo.service.FacilityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facilities")
public class FacilityController {

    private final FacilityService service;

    public FacilityController(FacilityService service) {
        this.service = service;
    }

    @PostMapping
    public Facility createFacility(@RequestBody Facility facility) {
        return service.save(facility);
    }

    @GetMapping
    public List<Facility> getAllFacilities() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Facility getFacilityById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteFacility(@PathVariable Long id) {
        service.deleteById(id);
        return "Facility deleted successfully";
    }
}
