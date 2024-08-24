package com.example.TaxiWala.repository;

import com.example.TaxiWala.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CabRepository extends JpaRepository<Cab,Integer> {
}
