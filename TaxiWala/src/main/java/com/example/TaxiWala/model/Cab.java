package com.example.TaxiWala.model;

import com.example.TaxiWala.Enum.CabType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true, nullable = false)
    String cabNo;

    String cabModel;

    CabType cabType;

    double farePerKm;

    boolean available;

    @OneToOne
    @JoinColumn
    @JsonIgnore
    Driver driver;
}
