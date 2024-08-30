package com.example.TaxiWala.dto.response;

import com.example.TaxiWala.Enum.CabType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CabResponseBody {
    String cabNo;

    String cabModel;

    CabType cabType;

    double farePerKm;
}
