package com.project.boxinator.models;

import com.project.boxinator.enums.TypeOfUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoxinatorUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastName;
    @Column(length = 50, nullable = false)
    private String email;
    @Column(length = 50)
    private String password;
    @Column(length = 50)
    private String dateOfBirth; //Kanske vill byta till date
    @Column(length = 50, nullable = false)
    private String country;
    @Column(length = 50)
    private Integer zipCode;
    @Column(length = 50)
    private String contactNumber;
    @Column(nullable = false)
    private TypeOfUser typeOfUser;
    @OneToMany(mappedBy = "boxinatorUser")
    private Set<Shipment> shipments = new HashSet<>();

    public BoxinatorUser(String firstName, String lastName, String email, String password, String dateOfBirth, String country, Integer zipCode, String contactNumber, TypeOfUser typeOfUser) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.zipCode = zipCode;
        this.contactNumber = contactNumber;
        this.typeOfUser = typeOfUser;
    }

    public void addShipmentToUser(Shipment shipment) { shipments.add(shipment); }

}
