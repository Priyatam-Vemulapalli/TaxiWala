package com.example.TaxiWala.dto.request;

import com.example.TaxiWala.Enum.CabType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CabRequestBody {
    String cabNo;

    String cabModel;

    CabType cabType;

    double farePerKm;

    int driverId;
}
