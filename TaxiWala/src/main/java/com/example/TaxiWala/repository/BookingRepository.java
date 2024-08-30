package com.example.TaxiWala.repository;

import com.example.TaxiWala.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
