package com.example.TaxiWala.model;

import com.example.TaxiWala.model.Enum.BookingStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String bookingId; //UUID

    String pickUp;

    String destination;

    @CreationTimestamp
    Date bookedAt;

    @UpdateTimestamp
    Date updatedAt;

    double totalFare;

    double totalDistance;

    BookingStatus Status;
}