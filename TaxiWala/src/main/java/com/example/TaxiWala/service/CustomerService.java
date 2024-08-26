package com.example.TaxiWala.service;


import com.example.TaxiWala.Enum.Gender;
import com.example.TaxiWala.dto.request.CustomerRequestBody;
import com.example.TaxiWala.dto.response.CustomerResponseBody;
import com.example.TaxiWala.model.Booking;
import com.example.TaxiWala.model.Customer;
import com.example.TaxiWala.repository.CustomerRepository;
import com.example.TaxiWala.transformer.CustomerTransformer;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    public CustomerResponseBody addCustomer(CustomerRequestBody customerRequestBody) {

        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequestBody);
        Customer SavedCustomer = customerRepository.save(customer);

        return CustomerTransformer.customerToCustomerResponse(SavedCustomer);
    }


    public List<CustomerResponseBody> getByGenderAndAgeGreaterThan(String gender, int age) {

        List<Customer> customers = customerRepository.getByGenderAndAgeGreaterThan(gender,age);
        List<CustomerResponseBody> customerResponseBodyList = new ArrayList<>();
        for(Customer customer: customers){
            customerResponseBodyList.add(CustomerTransformer.customerToCustomerResponse(customer));
        }

        return customerResponseBodyList;
    }

    public List<CustomerResponseBody> getByGender(Gender gender) {
        List<Customer> customers = customerRepository.getByGender(gender);
        List<CustomerResponseBody> customerResponseBodyList = new ArrayList<>();
        for(Customer customer: customers){
            customerResponseBodyList.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponseBodyList;

    }

    public List<CustomerResponseBody> getBetweenAge(int startage, int endage) {

        List<Customer> customers = customerRepository.getBetweenAge(startage,endage);
        List<CustomerResponseBody> customerResponseBodyList = new ArrayList<>();
        for(Customer customer: customers){
            customerResponseBodyList.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponseBodyList;

    }

    public CustomerResponseBody getCustomerWithHighestOrLowest(String value) {

        List<Customer> customers;
        Customer customerwith = new Customer();
        if(value.equals("Highest")){
            customers = customerRepository.getCustomerWithHighest();
        }
        else{
            customers = customerRepository.getCustomerWithLowest();
        }

        List<CustomerResponseBody> customerResponseBodyList = new ArrayList<>();
        int maxBookingCount = Integer.MIN_VALUE;
        for(Customer customer: customers){
            List<Booking> bookings = customer.getBookings();
            if(maxBookingCount<bookings.size()){
                maxBookingCount = Math.max(bookings.size(),maxBookingCount);
                customerwith = customer;
            }
            customerResponseBodyList.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return CustomerTransformer.customerToCustomerResponse(customerwith);
    }
}
