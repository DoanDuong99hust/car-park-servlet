package com.carpark.service;

import com.carpark.model.Car;
import com.carpark.paging.Pageble;

import java.util.List;

public interface ICarService {
    Car save(Car car);
    Car update(Car updateCar);
    void delete(long[] carIds);
    List<Car> findAll(Pageble pageble);
    List<Car> findAll();
    int getTotalItem();
    Car findOne(long carId);
}
