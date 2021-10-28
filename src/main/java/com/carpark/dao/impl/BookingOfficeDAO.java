package com.carpark.dao.impl;

import com.carpark.dao.IBookingOfficeDAO;
import com.carpark.mapper.BookingOfficeMapper;
import com.carpark.mapper.EmployeeMapper;
import com.carpark.model.BookingOffice;
import com.carpark.model.Employee;
import com.carpark.paging.Pageble;
import org.apache.commons.lang.StringUtils;

import java.util.List;

public class BookingOfficeDAO extends AbstractDAO<BookingOffice> implements IBookingOfficeDAO {
    @Override
    public BookingOffice findOne(Long id) {
        String sql = "SELECT * FROM bookingoffice WHERE officeId = ?";
        List<BookingOffice> bookingOfficeList = query(sql, new BookingOfficeMapper(), id);
        return bookingOfficeList.isEmpty() ? null : bookingOfficeList.get(0);
    }

    @Override
    public Long save(BookingOffice bookingOffice) {
        StringBuilder sql = new StringBuilder("INSERT INTO bookingoffice (officeName, tripId,");
        sql.append(" officePhone, officePlace, officePrice, startContractDate, endContractDate)");
        sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");
        return insert(sql.toString(), bookingOffice.getOfficeName(), bookingOffice.getTripId(),
        bookingOffice.getOfficePhone(), bookingOffice.getOfficePlace(), bookingOffice.getOfficePrice(),
                bookingOffice.getStartContractDate(), bookingOffice.getEndContractDate());
    }

    @Override
    public void update(BookingOffice updateBookingOffice) {
        StringBuilder sql = new StringBuilder("UPDATE bookingoffice SET officeName = ?, tripId = ?");
        sql.append("officePhone = ?, officePlace = ?, officePrice = ?, startContractDate = ?, endContractDate");
        update(sql.toString(), updateBookingOffice.getOfficeName(), updateBookingOffice.getTripId(),
                updateBookingOffice.getOfficePhone(), updateBookingOffice.getOfficePlace(), updateBookingOffice.getOfficePrice(),
                updateBookingOffice.getStartContractDate(), updateBookingOffice.getEndContractDate());
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM bookingoffice WHERE officeId = ?";
        update(sql, id);
    }

    @Override
    public List<BookingOffice> findAll(Pageble pageble) {
        StringBuilder sql = new StringBuilder("SELECT * FROM bookingoffice AS b ");
//        sql.append(" INNER JOIN trips AS t ON b.tripId = t.tripId ");
        if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
            sql.append("ORDER BY "+ pageble.getSorter().getSortName() +" "+ pageble.getSorter().getSortBy()+" ");
        }
        if (pageble.getLimit() != null && pageble.getOffset() != null) {
            sql.append("LIMIT " +pageble.getOffset()+", "+pageble.getLimit()+"");
        }
        return query(sql.toString(), new BookingOfficeMapper());
    }

    @Override
    public List<BookingOffice> findAll() {
        String sql = "SELECT * FROM bookingoffice";
        return query(sql, new BookingOfficeMapper());
    }

    @Override
    public int getTotalItem() {
        String sql = "SELECT count(*) FROM employee";
        return count(sql);
    }
}
