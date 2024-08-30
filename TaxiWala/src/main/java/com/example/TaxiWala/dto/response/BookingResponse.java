package com.example.TaxiWala.dto.response;

import com.example.TaxiWala.Enum.BookingStatus;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingResponse {

    String bookingId;

    String pickUp;

    String destination;

    Date bookedAt;

    Date updatedAt;

    double totalFare;

    double totalDistance;

    BookingStatus status;

    CustomerResponseBody customerResponseBody;

    CabResponseBody cabResponse;

    DriverResponseBody driverResponseBody;
}
