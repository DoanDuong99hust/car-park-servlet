package com.carpark.service.impl;

import com.carpark.dao.ITicketDAO;
import com.carpark.model.Ticket;
import com.carpark.paging.Pageble;
import com.carpark.service.ITicketService;

import javax.inject.Inject;
import java.util.List;

public class TicketService implements ITicketService {
    @Inject
    private ITicketDAO iTicketDAO;

    @Override
    public Ticket save(Ticket ticket) {
        Long pakingLotId = iTicketDAO.save(ticket);
        return iTicketDAO.findOne(pakingLotId);
    }

    @Override
    public Ticket update(Ticket updateTicket) {
        iTicketDAO.update(updateTicket);
        return iTicketDAO.findOne(updateTicket.getTicketId());
    }

    @Override
    public void delete(long[] ids) {
        for (long id:ids
        ) {
            iTicketDAO.delete(id);
        }
    }

    @Override
    public List<Ticket> findAll(Pageble pageble) {
        return iTicketDAO.findAll(pageble);
    }

    @Override
    public List<Ticket> findAll() {
        return iTicketDAO.findAll();
    }

    @Override
    public int getTotalItem() {
        return iTicketDAO.getTotalItem();
    }

    @Override
    public Ticket findOne(long id) {
        return iTicketDAO.findOne(id);
    }
}
