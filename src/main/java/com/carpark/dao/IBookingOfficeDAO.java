package com.carpark.dao;

import com.carpark.model.BookingOffice;
import com.carpark.model.Trip;
import com.carpark.paging.Pageble;

import java.util.List;

public interface IBookingOfficeDAO extends GenericDAO<BookingOffice> {
    BookingOffice findOne(Long id);
    Long save(BookingOffice bookingOffice);
    void update(BookingOffice updateBookingOffice);
    void delete(long id);
    List<BookingOffice> findAll(Pageble pageble);
    List<BookingOffice> findAll();
    int getTotalItem();
}
