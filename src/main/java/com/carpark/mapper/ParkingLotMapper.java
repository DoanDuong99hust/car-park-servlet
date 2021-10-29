package com.carpark.mapper;

import com.carpark.model.ParkingLot;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParkingLotMapper implements RowMapper<ParkingLot>{
    @Override
    public ParkingLot mapRow(ResultSet resultSet) {
        try {
            ParkingLot parkingLot = new ParkingLot();
            parkingLot.setParkId(resultSet.getLong("parkId"));
            parkingLot.setParkArea(resultSet.getLong("parkArea"));
            parkingLot.setParkName(resultSet.getString("parkName"));
            parkingLot.setParkPlace(resultSet.getString("parkPlace"));
            parkingLot.setParkPrice(resultSet.getLong("parkPrice"));
            parkingLot.setParkStatus(resultSet.getString("parkStatus"));
            return parkingLot;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
