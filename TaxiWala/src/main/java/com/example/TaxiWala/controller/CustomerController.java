package com.example.TaxiWala.controller;


import com.example.TaxiWala.Enum.Gender;
import com.example.TaxiWala.dto.request.CustomerRequestBody;
import com.example.TaxiWala.dto.response.CustomerResponseBody;
import com.example.TaxiWala.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerRequestBody customerRequestBody){
        try{
            CustomerResponseBody customerResponseBody = customerService.addCustomer(customerRequestBody);
            return new ResponseEntity(customerResponseBody, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/gender/{gender}/age/{age}")
    public ResponseEntity getByGenderAndAgeGreaterThan(@PathVariable String gender,
                                                       @PathVariable int age){

        List<CustomerResponseBody> customerResponseBodyList = customerService.getByGenderAndAgeGreaterThan(gender,age);
        return new ResponseEntity(customerResponseBodyList,HttpStatus.ACCEPTED);

    }

    //get all customers of a particular gender
    @GetMapping("/gender/{gender}")
    public ResponseEntity getByGender(@PathVariable String gender){
        List<CustomerResponseBody> customerResponseBodyList = customerService.getByGender(gender);
        return new ResponseEntity(customerResponseBodyList,HttpStatus.ACCEPTED);
    }

//    get all customers who registered after a particular date
//    @GetMapping("/date/{date}")
//    public ResponseEntity getByDate(@PathVariable Date date){
//        List<CustomerResponseBody> customerResponseBodyList = customerService.getByDate(date);
//        return new ResponseEntity(customerResponseBodyList,HttpStatus.ACCEPTED);
//
//    }

    // get all customers between a particular age

    @GetMapping("/startage/{startage}/endage/{endage}")
    public ResponseEntity getBetweenAge(@PathVariable("startage") int startage,
                                        @PathVariable("endage") int endage){
        List<CustomerResponseBody> customerResponseBodyList = customerService.getBetweenAge(startage,endage);
        return new ResponseEntity(customerResponseBodyList,HttpStatus.ACCEPTED);

    }

    // get customers with the highest number of bookings or lowest bookings
    @GetMapping("/booking/{value}")
    public ResponseEntity getHighestBooking(@PathVariable("value") String value){

        CustomerResponseBody customerResponseBody = customerService.getCustomerWithHighestOrLowest(value);
        return new ResponseEntity(customerResponseBody,HttpStatus.ACCEPTED);
    }

}
