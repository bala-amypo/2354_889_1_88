package com.example.demo.service;

import com.example.demo.model.Booking;
import java.util.List;

public interface BookingService {

    Booking save(Booking booking);

    List<Booking> findAll();

    Booking findById(Long id);

    void deleteById(Long id);
}
