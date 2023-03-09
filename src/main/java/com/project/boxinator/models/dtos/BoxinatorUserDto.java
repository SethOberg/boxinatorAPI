package com.project.boxinator.models.dtos;

import com.project.boxinator.enums.TypeOfUser;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class BoxinatorUserDto {
    private int Id;
    private String firstName;
    private String lastName;
    private String password;
    private String dateOfBirth;
    private String country;
    private Integer zipCode;
    private String contactNumber;
    private TypeOfUser typeOfUser;
    private Set<Integer> shipmentsByUser = new HashSet<>();




}
