package com.carpark.dao.impl;

import com.carpark.dao.IParkingLotDAO;
import com.carpark.mapper.ParkingLotMapper;
import com.carpark.model.ParkingLot;
import com.carpark.paging.Pageble;
import org.apache.commons.lang.StringUtils;

import java.util.List;

public class ParkingLotDAO extends AbstractDAO<ParkingLot> implements IParkingLotDAO {
    @Override
    public ParkingLot findOne(Long id) {
        String sql = "SELECT * FROM parkinglots WHERE parkId = ?";
        List<ParkingLot> parkingLot = query(sql, new ParkingLotMapper(), id);
        return parkingLot.isEmpty() ? null : parkingLot.get(0);
    }

    @Override
    public Long save(ParkingLot parkingLot) {
        StringBuilder sql = new StringBuilder("INSERT INTO parkinglots (parkArea, parkName, parkPlace, parkPrice, parkStatus) ") ;
        sql.append("VALUES(?, ?, ?, ?, ?)");
        return insert(sql.toString(), parkingLot.getParkArea(), parkingLot.getParkName(), parkingLot.getParkPlace(),
                parkingLot.getParkPrice(), parkingLot.getParkStatus());
    }

    @Override
    public void update(ParkingLot updateParkingLot) {
        StringBuilder sql = new StringBuilder("UPDATE parkinglots SET parkArea = ?, parkName = ?, parkPlace= ?, ");
        sql.append("parkPrice = ?, parkStatus = ? WHERE parkId = ?");
        update(sql.toString(), updateParkingLot.getParkArea(), updateParkingLot.getParkName(),
                updateParkingLot.getParkPlace(), updateParkingLot.getParkPrice(), updateParkingLot.getParkStatus(), updateParkingLot.getParkId());
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM parkinglots WHERE parkId = ?";
        update(sql, id);
    }

    @Override
    public List<ParkingLot> findAll(Pageble pageble) {
        StringBuilder sql = new StringBuilder("SELECT * FROM parkinglots AS b ");
        if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
            sql.append("ORDER BY "+ pageble.getSorter().getSortName() +" "+ pageble.getSorter().getSortBy()+" ");
        }
        if (pageble.getLimit() != null && pageble.getOffset() != null) {
            sql.append("LIMIT " +pageble.getOffset()+", "+pageble.getLimit()+"");
        }
        return query(sql.toString(), new ParkingLotMapper());
    }

    @Override
    public List<ParkingLot> findAll() {
        String sql = "SELECT * FROM parkinglots";
        return query(sql, new ParkingLotMapper());
    }

    @Override
    public int getTotalItem() {
        String sql = "SELECT count(*) FROM parkinglots";
        return count(sql);
    }
}
