package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return service.save(booking);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable Long id) {
        service.deleteById(id);
        return "Booking deleted successfully";
    }
}
package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return service.save(booking);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable Long id) {
        service.deleteById(id);
        return "Booking deleted successfully";
    }
}
