package com.example.TaxiWala.transformer;

import com.example.TaxiWala.dto.request.CabRequestBody;
import com.example.TaxiWala.dto.response.CabResponseBody;
import com.example.TaxiWala.model.Cab;
import com.example.TaxiWala.model.Driver;

public class CabTransformer {
    public static CabResponseBody cabToCabResponseBody(Cab cab){
        return CabResponseBody.builder()
                .cabNo(cab.getCabNo())
                .cabType(cab.getCabType())
                .cabModel(cab.getCabModel())
                .farePerKm(cab.getFarePerKm())
                .build();
    }
    public static Cab cabRequestBodyToCab(CabRequestBody cabRequestBody){
        return Cab.builder()
                .cabNo(cabRequestBody.getCabNo())
                .cabModel(cabRequestBody.getCabModel())
                .cabType(cabRequestBody.getCabType())
                .build();
    }
}
