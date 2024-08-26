package com.example.TaxiWala.repository;

import com.example.TaxiWala.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
}
