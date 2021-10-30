package com.carpark.dao;

import com.carpark.model.Car;
import com.carpark.model.ParkingLot;
import com.carpark.paging.Pageble;

import java.util.List;

public interface ICarDAO extends GenericDAO<Car>{
    Car findOne(long carId);
    Long save(Car car);
    void update(Car updateCar);
    void delete(long carId);
    List<Car> findAll(Pageble pageble);
    List<Car> findAll();
    int getTotalItem();
}
