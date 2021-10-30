package com.carpark.dao.impl;

import com.carpark.dao.ICarDAO;
import com.carpark.mapper.CarMapper;
import com.carpark.model.Car;
import com.carpark.paging.Pageble;
import org.apache.commons.lang.StringUtils;

import java.util.List;

public class CarDAO extends AbstractDAO<Car> implements ICarDAO {
    @Override
    public Car findOne(long carId) {
        String sql = "SELECT * FROM cars WHERE carId = ?";
        List<Car> carList = query(sql, new CarMapper(), carId);
        return carList.isEmpty() ? null : carList.get(0);
    }

    @Override
    public Long save(Car car) {
        StringBuilder sql = new StringBuilder("INSERT INTO cars (licensePlate, carColor, ");
        sql.append("carType, company, parkId ) ");
        sql.append("VALUES(?,?,?,?,?)");
        return insert(sql.toString(), car.getLicensePlate(), car.getCarColor(), car.getCarType(),
                car.getCompany(), car.getParkId());
    }

    @Override
    public void update(Car updateCar) {
        StringBuilder sql = new StringBuilder("UPDATE cars SET licensePlate = ?, carColor = ?, ");
        sql.append("carType = ?, company = ?, parkId = ? WHERE carId = ?");
        update(sql.toString(), updateCar.getLicensePlate(), updateCar.getCarColor(), updateCar.getCarType(), updateCar.getCompany(),
                updateCar.getParkId(), updateCar.getCarId());
    }

    @Override
    public void delete(long carId) {
        String sql = "DELETE FROM cars WHERE carId = ?";
        update(sql, carId);
    }

    @Override
    public List<Car> findAll(Pageble pageble) {
        StringBuilder sql = new StringBuilder("SELECT * FROM cars AS c ");
//        sql.append("INNER JOIN parkinglots AS p ON c.parkId = p.parkId ");
        if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
            sql.append("ORDER BY "+ pageble.getSorter().getSortName() +" "+ pageble.getSorter().getSortBy()+" ");
        }
        if (pageble.getLimit() != null && pageble.getOffset() != null) {
            sql.append("LIMIT " +pageble.getOffset()+", "+pageble.getLimit()+"");
        }
        return query(sql.toString(), new CarMapper());
    }

    @Override
    public List<Car> findAll() {
        String sql = "SELECT * FROM cars AS c";
        return query(sql, new CarMapper());
    }

    @Override
    public int getTotalItem() {
        String sql = "SELECT count(*) FROM cars";
        return count(sql);
    }
}
