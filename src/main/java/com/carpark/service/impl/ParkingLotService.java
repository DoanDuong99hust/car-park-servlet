package com.carpark.service.impl;

import com.carpark.dao.IParkingLotDAO;
import com.carpark.model.ParkingLot;
import com.carpark.paging.Pageble;
import com.carpark.service.IParkingLotService;

import javax.inject.Inject;
import java.util.List;

public class ParkingLotService implements IParkingLotService {

    @Inject
    private IParkingLotDAO iParkingLotDAO;

    @Override
    public ParkingLot save(ParkingLot parkingLot) {
        Long pakingLotId = iParkingLotDAO.save(parkingLot);
        return iParkingLotDAO.findOne(pakingLotId);
    }

    @Override
    public ParkingLot update(ParkingLot updateParkingLot) {
        iParkingLotDAO.update(updateParkingLot);
        return iParkingLotDAO.findOne(updateParkingLot.getParkId());
    }

    @Override
    public void delete(long[] ids) {
        for (long id:ids
             ) {
            iParkingLotDAO.delete(id);
        }
    }

    @Override
    public List<ParkingLot> findAll(Pageble pageble) {
        return iParkingLotDAO.findAll(pageble);
    }

    @Override
    public List<ParkingLot> findAll() {
        return iParkingLotDAO.findAll();
    }

    @Override
    public int getTotalItem() {
        return iParkingLotDAO.getTotalItem();
    }

    @Override
    public ParkingLot findOne(long id) {
        return iParkingLotDAO.findOne(id);
    }
}
