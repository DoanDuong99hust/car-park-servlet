package com.carpark.mapper;

import com.carpark.model.BookingOffice;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingOfficeMapper implements RowMapper<BookingOffice> {
    @Override
    public BookingOffice mapRow(ResultSet resultSet) { ;
        try {
            BookingOffice bookingOffice = new BookingOffice();
            bookingOffice.setOfficeId(resultSet.getLong("officeId"));
            bookingOffice.setEndContractDate(resultSet.getString("endContractDate"));
            bookingOffice.setOfficeName(resultSet.getString("officeName"));
            bookingOffice.setOfficePhone(resultSet.getString("officePhone"));
            bookingOffice.setOfficePlace(resultSet.getString("officePlace"));
            bookingOffice.setOfficePrice(resultSet.getLong("officePrice"));
            bookingOffice.setTripId(resultSet.getLong("tripId"));
            return bookingOffice;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
