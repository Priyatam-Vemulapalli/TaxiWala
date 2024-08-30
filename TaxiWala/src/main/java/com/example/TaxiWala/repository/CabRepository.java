package com.example.TaxiWala.repository;

import com.example.TaxiWala.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CabRepository extends JpaRepository<Cab,Integer> {

    @Query(value = "select * from cab where available = TRUE order by rand() limit 1", nativeQuery = true)
    Cab getRandomAvailableCab();
}
