package com.carpark.dao.impl;

import com.carpark.dao.ITripDAO;
import com.carpark.mapper.TripMapper;
import com.carpark.model.Trip;
import com.carpark.paging.Pageble;
import org.apache.commons.lang.StringUtils;

import java.util.List;

public class TripDAO extends AbstractDAO<Trip> implements ITripDAO {
    @Override
    public Trip findOne(Long id) {
        String sql = "SELECT * FROM trips WHERE tripId = ?";
        List<Trip> tripList = query(sql, new TripMapper(), id);
        return tripList.isEmpty() ? null : tripList.get(0);
    }

    @Override
    public Long save(Trip trip) {
        StringBuilder sql = new StringBuilder("INSERT INTO trips (carType, departureDate, ") ;
        sql.append("departureTime, destination, driverName, maximumOnlineTicketNumber)");
        sql.append("VALUES(?, ?, ?, ?, ?, ?)");
        return insert(sql.toString(), trip.getCarType(), trip.getDepartureDate(),
                trip.getDepartureTime(), trip.getDestination(), trip.getDriverName(), trip.getMaximumOnlineTicketNumber());
    }

    @Override
    public void update(Trip updateTrip) {
        StringBuilder sql = new StringBuilder("UPDATE trips SET carType = ?, departureDate = ?, ") ;
        sql.append("departureTime = ?, destination = ?, driverName = ?, maximumOnlineTicketNumber = ? ");
        sql.append("WHERE tripId = ?");
        update(sql.toString(), updateTrip.getCarType(), updateTrip.getDepartureDate(),
                updateTrip.getDepartureTime(), updateTrip.getDestination(), updateTrip.getDriverName(), updateTrip.getMaximumOnlineTicketNumber(),
                updateTrip.getTripId());
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM trips WHERE tripId = ?";
        update(sql, id);
    }

    @Override
    public List<Trip> findAll(Pageble pageble) {
        StringBuilder sql = new StringBuilder("SELECT * FROM trips AS b ");
        if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
            sql.append("ORDER BY "+ pageble.getSorter().getSortName() +" "+ pageble.getSorter().getSortBy()+" ");
        }
        if (pageble.getLimit() != null && pageble.getOffset() != null) {
            sql.append("LIMIT " +pageble.getOffset()+", "+pageble.getLimit()+"");
        }
        return query(sql.toString(), new TripMapper());
    }

    @Override
    public List<Trip> findAll() {
        String sql = "SELECT * FROM trips";
        return query(sql, new TripMapper());
    }

    @Override
    public int getTotalItem() {
        String sql = "SELECT count(*) FROM trips";
        return count(sql);
    }
}
