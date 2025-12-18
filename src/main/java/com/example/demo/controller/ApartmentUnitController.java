package com.example.demo.controller;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/units")
@Tag(name = "Apartment Units")
public class ApartmentUnitController {

    private final ApartmentUnitService apartmentUnitService;

    public ApartmentUnitController(ApartmentUnitService apartmentUnitService) {
        this.apartmentUnitService = apartmentUnitService;
    }

    @PostMapping("/assign/{userid}")
    public ApartmentUnit assignUnit(
            @PathVariable Long userid,
            @RequestBody ApartmentUnit unit) {
        return apartmentUnitService.assignUnitToUser(userid, unit);
    }

    @GetMapping("/user/{userid}")
    public ApartmentUnit getUnit(@PathVariable Long userid) {
        return apartmentUnitService.getUnitByUser(userid);
    }
}
