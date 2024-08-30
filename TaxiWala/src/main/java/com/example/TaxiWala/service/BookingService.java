package com.example.TaxiWala.service;

import com.example.TaxiWala.dto.request.BookingRequest;
import com.example.TaxiWala.dto.response.BookingResponse;
import com.example.TaxiWala.exception.CabNotAvailableException;
import com.example.TaxiWala.exception.CustomerNotValidException;
import com.example.TaxiWala.model.Booking;
import com.example.TaxiWala.model.Cab;
import com.example.TaxiWala.model.Customer;
import com.example.TaxiWala.repository.BookingRepository;
import com.example.TaxiWala.repository.CabRepository;
import com.example.TaxiWala.repository.CustomerRepository;
import com.example.TaxiWala.repository.DriverRepository;
import com.example.TaxiWala.transformer.BookingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class BookingService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    CabRepository cabRepository;

    public BookingResponse bookCab(BookingRequest bookingRequest) {

        // check if the customer email is valid or not.

        Customer customer = customerRepository.findByEmailId(bookingRequest.getCustomerEmail());

        if(ObjectUtils.isEmpty(customer)){
           throw new CustomerNotValidException("Customer mail id is not found");
        }

        Cab cab = cabRepository.getRandomAvailableCab();

        if(ObjectUtils.isEmpty(cab)){
            throw new CabNotAvailableException("It seems to be busier than usual");
        }

        Booking booking = BookingTransformer.bookingRequestBodyToBooking(bookingRequest, cab);

        booking.setDriver(cab.getDriver());
        booking.setCustomer(customer);
        Booking savedBooking = bookingRepository.save(booking);
        customer.getBookings().add(savedBooking);
//        cab.getDriver().getBookings().add(savedBooking);

        customerRepository.save(customer); // This will save customer + booking
        driverRepository.save(cab.getDriver()); // This will save driver + cab + booking
        cab.setAvailable(false);
        sendMail(savedBooking);

        return BookingTransformer.bookingToBookingResponseBody(savedBooking);
    }

    public  void sendMail(Booking savedBooking){
        String text= "Hi "+ savedBooking.getCustomer().getName() + "! your cab booking is confirmed" +
                "\n"
                + savedBooking.getDriver().getName()+ " is arriving at your location soon!\n"
                + savedBooking.getPickUp() + "ETA of arrival: 15 minutes";


        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("learnerpree@gmail.com");
        simpleMailMessage.setTo(savedBooking.getCustomer().getEmailId());
        simpleMailMessage.setSubject("Cab Booked! (DO NOT REPLY THIS IS AN AUTOMATED MAIL)");
        simpleMailMessage.setText(text);

        javaMailSender.send(simpleMailMessage);

    }
}
