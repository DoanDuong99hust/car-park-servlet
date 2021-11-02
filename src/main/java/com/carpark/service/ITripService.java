package com.carpark.service;

import com.carpark.model.Ticket;
import com.carpark.model.Trip;
import com.carpark.paging.Pageble;

import java.util.List;

public interface ITripService {
    Trip save(Trip trip);
    Trip update(Trip updateTrip);
    void delete(long[] ids);
    List<Trip> findAll(Pageble pageble);
    List<Trip> findAll();
    int getTotalItem();
    Trip findOne(long id);
}
