package com.example.TaxiWala.controller;


import com.example.TaxiWala.dto.request.BookingRequest;
import com.example.TaxiWala.dto.response.BookingResponse;
import com.example.TaxiWala.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping()
    public ResponseEntity bookCab(@RequestBody BookingRequest bookingRequest){

        try {
            return new ResponseEntity(bookingService.bookCab(bookingRequest), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
        }
    }
}
