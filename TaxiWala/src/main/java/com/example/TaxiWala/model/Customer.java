package com.example.TaxiWala.model;

import com.example.TaxiWala.model.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

//import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @Column(unique = true, nullable = false)
    String emailId; // MySQL column name will be email_id
    int age;
    @Enumerated(EnumType.STRING) // JPA will map the enum to vachar in mysql instead of default int in mysql
    Gender gender; //enum

    Date registeredOn;
}
