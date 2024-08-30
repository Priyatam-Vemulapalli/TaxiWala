package com.example.TaxiWala.repository;

import com.example.TaxiWala.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver,Integer> {

    Driver findByMobNo(long mobNo);
    Driver findByAgeAndMobNo(int age, long mobNo);

    List<Driver> findByAgeAndName(int age, String name);
}
