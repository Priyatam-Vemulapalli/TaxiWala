package com.example.TaxiWala.transformer;

import com.example.TaxiWala.dto.request.DriverRequestBody;
import com.example.TaxiWala.dto.response.DriverResponseBody;
import com.example.TaxiWala.model.Driver;

public class DriverTransformer {
    public static Driver driverRequestToDriver(DriverRequestBody driverRequestBody){
        // using builder
        return Driver.builder()
                .age(driverRequestBody.getAge())
                .mobNo(driverRequestBody.getMobNo())
                .name(driverRequestBody.getName())
                .build();
    }

    public static DriverResponseBody driverToDriverResponse(Driver driver){
        // using builder
        return DriverResponseBody.builder()
                .age(driver.getAge())
                .name(driver.getName())
                .build();
    }
}
