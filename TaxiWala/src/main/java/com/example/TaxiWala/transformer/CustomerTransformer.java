package com.example.TaxiWala.transformer;

import com.example.TaxiWala.dto.request.CustomerRequestBody;
import com.example.TaxiWala.dto.response.CustomerResponseBody;
import com.example.TaxiWala.model.Customer;

public class CustomerTransformer {
    public static Customer customerRequestToCustomer(CustomerRequestBody customerRequestBody){
        // using builder
        return Customer.builder()
                .age(customerRequestBody.getAge())
                .name(customerRequestBody.getName())
                .emailId(customerRequestBody.getEmailId())
                .gender(customerRequestBody.getGender())
                .build();
    }

    public static CustomerResponseBody customerToCustomerResponse(Customer customer){
        // using builder
        return CustomerResponseBody.builder()
                .emailId(customer.getEmailId())
                .RegisteredOn(customer.getRegisteredOn())
                .gender(customer.getGender())
                .name(customer.getName())
                .build();
    }
}
