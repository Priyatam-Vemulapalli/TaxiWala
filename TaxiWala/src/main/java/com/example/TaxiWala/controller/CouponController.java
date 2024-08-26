package com.example.TaxiWala.controller;


import com.example.TaxiWala.dto.request.CouponRequest;
import com.example.TaxiWala.service.Couponservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/coupon")
public class CouponController {

    @Autowired
    Couponservice couponservice;

    @PostMapping()
    public ResponseEntity addCoupon(@RequestBody CouponRequest couponRequest){
        String response = couponservice.addCoupon(couponRequest);
        return new ResponseEntity(response, HttpStatus.ACCEPTED);
    }
}
