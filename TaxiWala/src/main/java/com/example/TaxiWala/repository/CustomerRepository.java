package com.example.TaxiWala.repository;

import com.example.TaxiWala.Enum.Gender;
import com.example.TaxiWala.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

//    @Query(value = "select c from Customer c where c.gender = :gender and c.age >= :age") //HQL query but Gender is an enum hence the type should be a Gender instead of String
    @Query(value = "select * from customer where gender = :gender and age >= :age",nativeQuery = true)
    public List<Customer> getByGenderAndAgeGreaterThan(String gender,int age);

    @Query(value = "select * from customer where gender= :gender",nativeQuery = true)
    List<Customer> getByGender(Gender gender);

    @Query(value = "select * from customer where age >= :startage and age <= :endage",nativeQuery = true)
    List<Customer> getBetweenAge(int startage, int endage);

    @Query(value = "select * from customers",nativeQuery = true)
    List<Customer> getCustomerWithHighest();

    @Query(value = "select * from customers",nativeQuery = true)
    List<Customer> getCustomerWithLowest();
}
