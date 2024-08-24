package com.example.TaxiWala.model;

import com.example.TaxiWala.Enum.BookingStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String bookingId; // UUID

    String pickUp;

    String destination;

    @CreationTimestamp
    Date bookedAt;  // both date and time - Util

    @UpdateTimestamp
    Date updatedAt;

    double totalFare;

    double totalDistance;

    BookingStatus status;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Customer customer;

    @ManyToOne
    @JoinColumn
    @JsonIgnore // avoids Jackson infinite recursion
    Driver driver;
}