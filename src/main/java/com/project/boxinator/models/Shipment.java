package com.project.boxinator.models;

import com.project.boxinator.enums.WeightOption;
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
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 150, nullable = false)
    private String recieverName;
    @Column(nullable = false)
    private WeightOption weightOption;

    @Column(length = 50, nullable = false)
    private String boxColour;
    @Column(nullable = false)
    private String destinationCountry;

    @ManyToOne
    @JoinColumn(name="user_id")
    private BoxinatorUser boxinatorUser;


    @OneToMany(mappedBy = "shipment")
    private Set<ShipmentStatusHistory> shipmentHistory = new HashSet<>();

    public Shipment(String recieverName, WeightOption weightOption, String boxColour, String destinationCountry, Set<ShipmentStatusHistory> shipmentHistory) {
        this.recieverName = recieverName;
        this.weightOption = weightOption;
        this.boxColour = boxColour;
        this.destinationCountry = destinationCountry;
        this.shipmentHistory = shipmentHistory;
    }

    public void addUserToShipment(BoxinatorUser boxinatorUser) {
        setBoxinatorUser(boxinatorUser);
    }



}
