package com.example.TaxiWala.transformer;

import com.example.TaxiWala.dto.request.CouponRequest;
import com.example.TaxiWala.model.Coupon;

public class CouponTransformer {

    public static Coupon couponRequestToCoupon(CouponRequest couponRequest){
        return Coupon.builder()
                .couponCode(couponRequest.getCouponCode())
                .percentageDiscount(couponRequest.getPercentageDiscount())
                .build();
    }
}
