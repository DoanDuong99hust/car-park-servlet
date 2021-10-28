package com.carpark.service;

import com.carpark.model.BookingOffice;
import com.carpark.paging.Pageble;

import java.util.List;

public interface IBookingOfficeService {
    BookingOffice save(BookingOffice bookingOffice);
    BookingOffice update(BookingOffice updateBookingOffice);
    void delete(long[] ids);
    List<BookingOffice> findAll(Pageble pageble);
    List<BookingOffice> findAll();
    int getTotalItem();
    BookingOffice findOne(long id);
}
