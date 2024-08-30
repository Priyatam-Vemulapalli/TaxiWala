package com.example.TaxiWala.controller;

import com.example.TaxiWala.dto.request.DriverRequestBody;
import com.example.TaxiWala.dto.response.DriverResponseBody;
import com.example.TaxiWala.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping
    public ResponseEntity addDriver(@RequestBody DriverRequestBody driver) {
        DriverResponseBody driverResponseBody = driverService.addDriver(driver);
        return new ResponseEntity(driverResponseBody, HttpStatus.CREATED);
    }

    @GetMapping
    public DriverResponseBody getDriver(@RequestParam("driverId") int driverId) {
        return driverService.getDriver(driverId);
    }

    @GetMapping("/mobile/{mobile}")
    public DriverResponseBody getDriverByMobileNumber(@PathVariable("mobile") long mobNo){

        return driverService.getDriverByMobileNumber(mobNo);
    }

    // make same apis as in customers
    @GetMapping("/age-and-name")
    public List<DriverResponseBody> getDriversByAgeAndName(@RequestParam("age") int age,
                                                           @RequestParam("name") String name){
        return driverService.getByAgeAndName(age,name);
    }

}