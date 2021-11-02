package com.carpark.controller.carpark.api;

import com.carpark.model.ParkingLot;
import com.carpark.model.Ticket;
import com.carpark.service.ITicketService;
import com.carpark.utils.FormUtil;
import com.carpark.utils.HttpUtil;
import org.codehaus.jackson.map.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/car-park/api/ticket-list"})
public class TicketApi extends HttpServlet {
    @Inject
    private ITicketService iTicketService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Ticket ticket = FormUtil.toModel(Ticket.class, request);
        ticket.setListResult(iTicketService.findAll());
        mapper.writeValue(response.getOutputStream(), ticket);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Ticket ticket = HttpUtil.of(request.getReader()).toModel(Ticket.class);
        ticket = iTicketService.save(ticket);
        mapper.writeValue(response.getOutputStream(), ticket);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Ticket updateTicket = HttpUtil.of(request.getReader()).toModel(Ticket.class);
        updateTicket = iTicketService.update(updateTicket);
        mapper.writeValue(response.getOutputStream(), updateTicket);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        ParkingLot deleteParkingLot = HttpUtil.of(request.getReader()).toModel(ParkingLot.class);
        iTicketService.delete(deleteParkingLot.getIds());
        mapper.writeValue(response.getOutputStream(), "{}");
    }
}
