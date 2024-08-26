package com.example.TaxiWala.service;


import com.example.TaxiWala.dto.request.CouponRequest;
import com.example.TaxiWala.model.Coupon;
import com.example.TaxiWala.repository.CouponRepository;
import com.example.TaxiWala.transformer.CouponTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Couponservice {
    @Autowired
    CouponRepository couponRepository;

    public String addCoupon(CouponRequest couponRequest){
        Coupon coupon = CouponTransformer.couponRequestToCoupon(couponRequest);

        couponRepository.save(coupon);
        return "CouponAdded successfully";
    }
}
