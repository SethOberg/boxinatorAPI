package com.project.boxinator.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.boxinator.enums.WeightOption;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column(length = 150, nullable = false)
    private String recieverName;
    @Column(nullable = false)
    private WeightOption weightOption;
    @Column(length = 50, nullable = false)
    private String boxColour;
    @Column(nullable = false)
    private String destinationCountry;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id", referencedColumnName = "userId")
//    @JsonIgnoreProperties("shipments")
//    private User user;

//    @OneToMany(mappedBy = "shipment")
//    private Set<ShipmentStatusHistory> shipmentHistory = new HashSet<>();

    public Shipment(int id, String recieverName, WeightOption weightOption, String boxColour, String destinationCountry, Set<ShipmentStatusHistory> shipmentHistory) {
        Id = id;
        this.recieverName = recieverName;
        this.weightOption = weightOption;
        this.boxColour = boxColour;
        this.destinationCountry = destinationCountry;
//        this.shipmentHistory = shipmentHistory;
    }

    public void addUserToShipment(User user) {
        user.addShipmentToUser(this);
    }


}
