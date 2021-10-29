package com.carpark.dao;

import com.carpark.model.ParkingLot;
import com.carpark.paging.Pageble;

import java.util.List;

public interface IParkingLotDAO extends GenericDAO<ParkingLot>{
    ParkingLot findOne(Long id);
    Long save(ParkingLot parkingLot);
    void update(ParkingLot updateParkingLot);
    void delete(long id);
    List<ParkingLot> findAll(Pageble pageble);
    List<ParkingLot> findAll();
    int getTotalItem();
}
