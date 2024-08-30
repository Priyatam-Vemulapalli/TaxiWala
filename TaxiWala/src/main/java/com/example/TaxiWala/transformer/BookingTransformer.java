package com.example.TaxiWala.transformer;

import com.example.TaxiWala.Enum.BookingStatus;
import com.example.TaxiWala.dto.request.BookingRequest;
import com.example.TaxiWala.dto.response.BookingResponse;
import com.example.TaxiWala.model.Booking;
import com.example.TaxiWala.model.Cab;

import java.util.UUID;

public class BookingTransformer {
    public static Booking bookingRequestBodyToBooking(BookingRequest bookingRequest,
                                                      Cab cab) {

        return Booking.builder()
                .bookingId(String.valueOf(UUID.randomUUID()))
                .pickUp(bookingRequest.getPickUp())
                .destination(bookingRequest.getDestination())
                .totalFare(cab.getFarePerKm()* bookingRequest.getTotalDistance())
                .status(BookingStatus.Booked)
                .totalDistance(bookingRequest.getTotalDistance())
                .build();
    }

    public static BookingResponse bookingToBookingResponseBody(Booking booking) {

        return BookingResponse.builder()
                .bookingId(booking.getBookingId())
                .pickUp(booking.getPickUp())
                .destination(booking.getDestination())
                .bookedAt(booking.getBookedAt())
                .updatedAt(booking.getUpdatedAt())
                .totalFare(booking.getTotalFare())
                .totalDistance(booking.getTotalDistance())
                .status(booking.getStatus())
                .customerResponseBody(CustomerTransformer.customerToCustomerResponse(booking.getCustomer()))
                .cabResponse(CabTransformer.cabToCabResponseBody(booking.getDriver().getCab()))
                .driverResponseBody(DriverTransformer.driverToDriverResponse(booking.getDriver()))
                .build();
    }
}
