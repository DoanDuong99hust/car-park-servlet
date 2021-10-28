package com.carpark.service.impl;

import com.carpark.dao.IBookingOfficeDAO;
import com.carpark.model.BookingOffice;
import com.carpark.paging.Pageble;
import com.carpark.service.IBookingOfficeService;

import javax.inject.Inject;
import java.util.List;

public class BookingOfficeService implements IBookingOfficeService {

    @Inject
    private IBookingOfficeDAO iBookingOfficeDAO;

    @Override
    public BookingOffice save(BookingOffice bookingOffice) {
        Long bookingOfficeId = iBookingOfficeDAO.save(bookingOffice);
        return iBookingOfficeDAO.findOne(bookingOfficeId);
    }

    @Override
    public BookingOffice update(BookingOffice updateBookingOffice) {
        iBookingOfficeDAO.update(updateBookingOffice);
        return iBookingOfficeDAO.findOne(updateBookingOffice.getOfficeId());
    }

    @Override
    public void delete(long[] ids) {
        for (long id:ids
             ) {
            iBookingOfficeDAO.delete(id);
        }
    }

    @Override
    public List<BookingOffice> findAll(Pageble pageble) {
        return iBookingOfficeDAO.findAll(pageble);
    }

    @Override
    public List<BookingOffice> findAll() {
        return iBookingOfficeDAO.findAll();
    }

    @Override
    public int getTotalItem() {
        return iBookingOfficeDAO.getTotalItem();
    }

    @Override
    public BookingOffice findOne(long id) {
        return iBookingOfficeDAO.findOne(id);
    }
}
