package com.carpark.service;

import com.carpark.model.Ticket;
import com.carpark.paging.Pageble;

import java.util.List;

public interface ITicketService {
    Ticket save(Ticket ticket);
    Ticket update(Ticket updateTicket);
    void delete(long[] ids);
    List<Ticket> findAll(Pageble pageble);
    List<Ticket> findAll();
    int getTotalItem();
    Ticket findOne(long id);
}
