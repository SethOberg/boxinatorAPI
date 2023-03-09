package com.project.boxinator.mappers;

import com.project.boxinator.models.Shipment;
import com.project.boxinator.models.BoxinatorUser;
import com.project.boxinator.models.dtos.BoxinatorUserDto;
import com.project.boxinator.services.ShipmentService;
import com.project.boxinator.services.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    @Autowired
    private UserService userService;
    @Autowired
    private ShipmentService shipmentService;

    @Mapping(target = "shipmentsByUser", source = "shipments", qualifiedByName = "shipmentsToIds")
    public abstract BoxinatorUserDto userToUserDto(BoxinatorUser boxinatorUser);

    public abstract Collection<BoxinatorUserDto> userToUserDto(Collection<BoxinatorUser> boxinatorUsers);

    public abstract BoxinatorUser userDtoToUser(BoxinatorUserDto boxinatorUserDto);

    @Named("shipmentsToIds")
    Set<Integer> mapShipmentsToIds(Set<Shipment> source) {
        if (source == null) {
            return null;
        }
        return source.stream()
                .map(Shipment::getId)
                .collect(Collectors.toSet());
    }

    @Named("shipments")
    Set<Shipment> mapShipments(Set<Shipment> source) {
        if(source == null)
            return null;
        return source.stream().collect(Collectors.toSet());


    }




}
