package com.carpark.mapper;

import com.carpark.model.Car;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements RowMapper<Car> {
    @Override
    public Car mapRow(ResultSet resultSet) {

        try {
            Car car = new Car();
            car.setCarId(resultSet.getLong("carId"));
            car.setLicensePlate(resultSet.getString("licensePlate"));
            car.setCarColor(resultSet.getString("carColor"));
            car.setCarType(resultSet.getString("carType"));
            car.setCompany(resultSet.getString("company"));
            car.setParkId(resultSet.getLong("parkId"));
            return car;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
