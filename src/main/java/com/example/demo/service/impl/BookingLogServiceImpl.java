package com.example.demo.service.impl;

import com.example.demo.model.BookingLog;
import com.example.demo.repository.BookingLogRepository;
import com.example.demo.service.BookingLogService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingLogServiceImpl implements BookingLogService {

    private final BookingLogRepository repository;

    public BookingLogServiceImpl(BookingLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public BookingLog save(BookingLog log) {
        return repository.save(log);
    }

    @Override
    public List<BookingLog> findAll() {
        return repository.findAll();
    }

    @Override
    public BookingLog findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BookingLog not found with id " + id));
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("BookingLog not found with id " + id);
        }
        repository.deleteById(id);
    }
}
