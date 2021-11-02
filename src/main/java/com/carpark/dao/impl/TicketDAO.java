package com.carpark.dao.impl;

import com.carpark.dao.ITicketDAO;
import com.carpark.mapper.TicketMapper;
import com.carpark.model.Ticket;
import com.carpark.paging.Pageble;
import org.apache.commons.lang.StringUtils;

import java.util.List;

public class TicketDAO extends AbstractDAO<Ticket> implements ITicketDAO {
    @Override
    public Ticket findOne(Long id) {
        String sql = "SELECT * FROM tickets WHERE ticketId = ?";
        List<Ticket> ticketList = query(sql, new TicketMapper(), id);
        return ticketList.isEmpty() ? null : ticketList.get(0);
    }

    @Override
    public Long save(Ticket ticket) {
        StringBuilder sql = new StringBuilder("INSERT INTO tickets (bookingTime, customerName, licensePlate, tripId) ") ;
        sql.append("VALUES(?, ?, ?, ?)");
        return insert(sql.toString(), ticket.getBookingTime(), ticket.getCustomerName(), ticket.getLicensePlate(), ticket.getTripId());
    }

    @Override
    public void update(Ticket updateTicket) {
        StringBuilder sql = new StringBuilder("UPDATE tickets SET bookingTime = ?, customerName = ?, licensePlate = ?, ");
        sql.append("tripId = ? WHERE ticketId = ?");
        update(sql.toString(), updateTicket.getBookingTime(), updateTicket.getCustomerName(),
                updateTicket.getLicensePlate(), updateTicket.getTripId(), updateTicket.getTicketId());
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM tickets WHERE ticketId = ?";
        update(sql, id);
    }

    @Override
    public List<Ticket> findAll(Pageble pageble) {
        StringBuilder sql = new StringBuilder("SELECT * FROM tickets AS b ");
        if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
            sql.append("ORDER BY "+ pageble.getSorter().getSortName() +" "+ pageble.getSorter().getSortBy()+" ");
        }
        if (pageble.getLimit() != null && pageble.getOffset() != null) {
            sql.append("LIMIT " +pageble.getOffset()+", "+pageble.getLimit()+"");
        }
        return query(sql.toString(), new TicketMapper());
    }

    @Override
    public List<Ticket> findAll() {
        String sql = "SELECT * FROM tickets";
        return query(sql, new TicketMapper());
    }

    @Override
    public int getTotalItem() {
        String sql = "SELECT count(*) FROM tickets";
        return count(sql);
    }
}
