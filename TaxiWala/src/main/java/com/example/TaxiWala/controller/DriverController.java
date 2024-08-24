package com.example.TaxiWala.controller;

import com.example.TaxiWala.dto.request.DriverRequestBody;
import com.example.TaxiWala.dto.response.DriverResponseBody;
import com.example.TaxiWala.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping
    public ResponseEntity addDriver(@RequestBody DriverRequestBody driver) {
        return new ResponseEntity(driverService.addDriver(driver), HttpStatus.CREATED);
    }

    @GetMapping
    public DriverResponseBody getDriver(@RequestParam("driverId") int driverId) {
        return driverService.getDriver(driverId);
    }

    @GetMapping("/mobile/{mobile}")
    public DriverResponseBody getDriverByMobileNumber(@PathVariable("mobile") long mobNo){

        return driverService.getDriverByMobileNumber(mobNo);
    }
}