package com.example.TaxiWala.repository;

import com.example.TaxiWala.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DriverRepository extends JpaRepository<Driver,Integer> {

    Driver findByMobNo(long mobNo);
}
