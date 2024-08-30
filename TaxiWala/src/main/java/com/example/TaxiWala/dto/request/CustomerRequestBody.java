package com.example.TaxiWala.dto.request;

import com.example.TaxiWala.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRequestBody {

    String name;
    int age;
    String emailId;
    Gender gender;

}
