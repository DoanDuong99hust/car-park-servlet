package com.carpark.dao;

import com.carpark.model.Trip;
import com.carpark.paging.Pageble;

import java.util.List;

public interface ITripDAO {
    Trip findOne(Long id);
    Long save(Trip trip);
    void update(Trip updateTrip);
    void delete(long id);
    List<Trip> findAll(Pageble pageble);
    List<Trip> findAll();
    int getTotalItem();
}
