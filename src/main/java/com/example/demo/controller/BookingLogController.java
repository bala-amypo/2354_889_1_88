package com.example.demo.controller;

import com.example.demo.model.BookingLog;
import com.example.demo.service.BookingLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
@Tag(name = "Booking Logs")
public class BookingLogController {

    private final BookingLogService bookingLogService;

    public BookingLogController(BookingLogService bookingLogService) {
        this.bookingLogService = bookingLogService;
    }

    @GetMapping("/booking/{bookingId}")
    public List<BookingLog> getLogs(@PathVariable Long bookingId) {
        return bookingLogService.getLogsByBooking(bookingId);
    }
}
