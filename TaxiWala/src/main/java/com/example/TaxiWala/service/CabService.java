package com.example.TaxiWala.service;
import com.example.TaxiWala.exception.DriverNotValidException;
import com.example.TaxiWala.model.Cab;
import com.example.TaxiWala.model.Driver;
import com.example.TaxiWala.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class CabService {

    @Autowired
    DriverRepository driverRepository;

    public String addCab(Cab cab) {
        int driverId = cab.getDriver().getId();
        Optional<Driver> driverOptional =
                driverRepository.findById(driverId);
        if(driverOptional.isEmpty()) {
            throw new DriverNotValidException("Invalid driver id");
        }

        Driver driver = driverOptional.get();
        cab.setAvailable(true);
        driver.setCab(cab);

        driverRepository.save(driver);
        return "Cab added";
    }
}