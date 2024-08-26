package com.example.TaxiWala.service;

import com.example.TaxiWala.dto.request.DriverRequestBody;
import com.example.TaxiWala.dto.response.DriverResponseBody;
import com.example.TaxiWala.exception.DriverNotValidException;
import com.example.TaxiWala.model.Driver;
import com.example.TaxiWala.repository.DriverRepository;
import com.example.TaxiWala.transformer.DriverTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    public DriverResponseBody addDriver(DriverRequestBody driverRequestBody) {
        // request DTO -> driver
        Driver driver = DriverTransformer.driverRequestToDriver(driverRequestBody);
        // driver to response body
        return DriverTransformer.driverToDriverResponse(driver);
    }

    public DriverResponseBody getDriver(int driverId) {
        Optional<Driver> optionalDriver = driverRepository.findById(driverId);
        if (optionalDriver.isEmpty()) {
            throw new DriverNotValidException("Invalid driver id");
        }
        // driver to driver response body
        return DriverTransformer.driverToDriverResponse(optionalDriver.get());
    }

    public DriverResponseBody getDriverByMobileNumber(long mobNo) {

        Driver driver = driverRepository.findByMobNo(mobNo);
        if(ObjectUtils.isEmpty(driver)){
            throw new DriverNotValidException("Invalid mobile number");
        }
        return DriverTransformer.driverToDriverResponse(driver);
    }

    public DriverResponseBody getDriverByAgeAndMobileNumber(int age, long mobile){
        Driver driver = driverRepository.findByAgeAndMobNo(age,mobile);
        if(ObjectUtils.isEmpty(driver)){
            throw new DriverNotValidException("Invalid mobile number");
        }
        return DriverTransformer.driverToDriverResponse(driver);
    }
}