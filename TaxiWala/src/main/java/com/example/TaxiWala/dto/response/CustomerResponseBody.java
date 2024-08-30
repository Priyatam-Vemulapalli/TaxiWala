package com.example.TaxiWala.dto.response;


import com.example.TaxiWala.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerResponseBody {
    String name;
    String emailId;
    Gender gender;
    Date RegisteredOn;

}
