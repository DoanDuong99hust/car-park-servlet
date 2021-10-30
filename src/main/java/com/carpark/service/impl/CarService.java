package com.carpark.service.impl;

import com.carpark.dao.ICarDAO;
import com.carpark.model.Car;
import com.carpark.paging.Pageble;
import com.carpark.service.ICarService;

import javax.inject.Inject;
import java.util.List;

public class CarService implements ICarService {

    @Inject
    private ICarDAO iCarDAO;

    @Override
    public Car save(Car car) {
        Long carId = iCarDAO.save(car);
        return iCarDAO.findOne(carId);
    }

    @Override
    public Car update(Car updateCar) {
        iCarDAO.update(updateCar);
        return iCarDAO.findOne(updateCar.getCarId());
    }

    @Override
    public void delete(long[] carIds) {
        for (long id: carIds
             ) {
            iCarDAO.delete(id);
        }
    }

    @Override
    public List<Car> findAll(Pageble pageble) {
        return iCarDAO.findAll(pageble);
    }

    @Override
    public List<Car> findAll() {
        return iCarDAO.findAll();
    }

    @Override
    public int getTotalItem() {
        return iCarDAO.getTotalItem();
    }

    @Override
    public Car findOne(long carId) {
        return iCarDAO.findOne(carId);
    }
}
