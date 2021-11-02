package com.carpark.mapper;

import com.carpark.model.Ticket;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketMapper implements RowMapper<Ticket>{
    @Override
    public Ticket mapRow(ResultSet resultSet) {
        try {
            Ticket ticket = new Ticket();
            ticket.setTicketId(resultSet.getLong("ticketId"));
            ticket.setBookingTime(resultSet.getString("bookingTime"));
            ticket.setCustomerName(resultSet.getString("customerName"));
            ticket.setLicensePlate(resultSet.getString("licensePlate"));
            ticket.setTripId(resultSet.getLong("tripId"));
            return ticket;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
