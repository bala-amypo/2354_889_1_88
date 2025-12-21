package com.example.demo.service.impl;

import com.example.demo.model.Booking;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository repository;

    public BookingServiceImpl(BookingRepository repository) {
        this.repository = repository;
    }

    @Override
    public Booking save(Booking booking) {
        return repository.save(booking);
    }

    @Override
    public List<Booking> findAll() {
        return repository.findAll();
    }

    @Override
    public Booking findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id " + id));
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Booking not found with id " + id);
        }
        repository.deleteById(id);
    }
}
