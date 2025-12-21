package com.example.demo.service;

import com.example.demo.model.BookingLog;
import java.util.List;

public interface BookingLogService {

    BookingLog save(BookingLog log);

    List<BookingLog> findAll();

    BookingLog findById(Long id);

    void deleteById(Long id);
}
