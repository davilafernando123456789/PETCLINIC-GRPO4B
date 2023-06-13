package com.tecsup.petclinic.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VetTO {
    private Integer id;
    private String firstName;
    private String lastName;
}






