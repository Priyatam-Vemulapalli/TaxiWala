package com.example.TaxiWala.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DriverRequestBody {
    String name;
    int age;
    long mobNo;
}
