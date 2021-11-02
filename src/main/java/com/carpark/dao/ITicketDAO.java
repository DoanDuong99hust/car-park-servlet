package com.carpark.dao;

import com.carpark.model.Ticket;
import com.carpark.paging.Pageble;

import java.util.List;

public interface ITicketDAO {
    Ticket findOne(Long id);
    Long save(Ticket ticket);
    void update(Ticket updateTicket);
    void delete(long id);
    List<Ticket> findAll(Pageble pageble);
    List<Ticket> findAll();
    int getTotalItem();
}
