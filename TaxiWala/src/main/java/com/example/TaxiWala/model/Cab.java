package com.example.TaxiWala.model;

import com.example.TaxiWala.model.Enum.CabType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String cabNo;
    String cabModel;
    CabType cabType;
    double farePerKm;
    boolean available;

}
