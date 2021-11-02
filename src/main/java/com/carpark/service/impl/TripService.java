package com.carpark.service.impl;

import com.carpark.dao.ITripDAO;
import com.carpark.model.Trip;
import com.carpark.paging.Pageble;
import com.carpark.service.ITripService;

import javax.inject.Inject;
import java.util.List;

public class TripService implements ITripService {
    @Inject
    private ITripDAO iTripDAO;

    @Override
    public Trip save(Trip trip) {
        Long tripId = iTripDAO.save(trip);
        return iTripDAO.findOne(tripId);
    }

    @Override
    public Trip update(Trip updateTrip) {
        iTripDAO.update(updateTrip);
        return iTripDAO.findOne(updateTrip.getTripId());
    }

    @Override
    public void delete(long[] ids) {
        for (long id: ids
             ) {
            iTripDAO.delete(id);
        }
    }

    @Override
    public List<Trip> findAll(Pageble pageble) {
        return iTripDAO.findAll(pageble);
    }

    @Override
    public List<Trip> findAll() {
        return iTripDAO.findAll();
    }

    @Override
    public int getTotalItem() {
        return iTripDAO.getTotalItem();
    }

    @Override
    public Trip findOne(long id) {
        return iTripDAO.findOne(id);
    }
}
