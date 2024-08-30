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

    public List<CustomerResponseBody> getByGender(String gender) {
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

        List<Customer> customers = customerRepository.getAllCustomers();

        int maxBookingCount = Integer.MIN_VALUE;
        int minBookingCount = Integer.MAX_VALUE;
        Customer customerwithValue = new Customer();
        for(Customer customer: customers){
            List<Booking> bookings = customer.getBookings();
            if(value.equals("Highest")){
                if(maxBookingCount<bookings.size()) {
                    maxBookingCount = bookings.size();
                    customerwithValue = customer;
                }
            }
            else{
                if(minBookingCount>bookings.size()) {
                    minBookingCount = bookings.size();
                    customerwithValue = customer;
                }
            }
        }
        return CustomerTransformer.customerToCustomerResponse(customerwithValue);
    }
}
