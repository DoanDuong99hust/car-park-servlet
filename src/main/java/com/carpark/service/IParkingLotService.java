package com.carpark.service;

import com.carpark.model.ParkingLot;
import com.carpark.paging.Pageble;

import java.util.List;

public interface IParkingLotService {
    ParkingLot save(ParkingLot parkingLot);
    ParkingLot update(ParkingLot updateParkingLot);
    void delete(long[] ids);
    List<ParkingLot> findAll(Pageble pageble);
    List<ParkingLot> findAll();
    int getTotalItem();
    ParkingLot findOne(long id);
}
