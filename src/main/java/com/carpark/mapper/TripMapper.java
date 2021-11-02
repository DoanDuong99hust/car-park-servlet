package com.carpark.mapper;

import com.carpark.model.Trip;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TripMapper implements RowMapper<Trip>{
    @Override
    public Trip mapRow(ResultSet resultSet) {
        try {
            Trip trip = new Trip();
            trip.setTripId(resultSet.getLong("tripId"));
            trip.setBookedTicketNumber(resultSet.getInt("bookedTicketNumber"));
            trip.setCarType(resultSet.getString("carType"));
            trip.setDepartureDate(resultSet.getString("departureDate"));
            trip.setDepartureTime(resultSet.getString("departureTime"));
            trip.setDestination(resultSet.getString("destination"));
            trip.setDriverName(resultSet.getString("driverName"));
            trip.setMaximumOnlineTicketNumber(resultSet.getInt("maximumOnlineTicketNumber"));
            return trip;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
