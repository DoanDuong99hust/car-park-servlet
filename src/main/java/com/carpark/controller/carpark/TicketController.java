package com.carpark.controller.carpark;

import com.carpark.constant.SystemConstant;
import com.carpark.model.ParkingLot;
import com.carpark.model.Ticket;
import com.carpark.paging.PageRequest;
import com.carpark.paging.Pageble;
import com.carpark.service.ICarService;
import com.carpark.service.ITicketService;
import com.carpark.service.ITripService;
import com.carpark.sort.Sorter;
import com.carpark.utils.FormUtil;
import com.carpark.utils.MessageUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/car-park-ticket-list"})
public class TicketController extends HttpServlet {

    @Inject
    private ITicketService iTicketService;

    @Inject
    private ITripService iTripService;

    @Inject
    private ICarService iCarService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Ticket ticket = FormUtil.toModel(Ticket.class, request);
        String view = "";
        if (ticket.getType().equals(SystemConstant.LIST)) {
            Pageble pageble = new PageRequest(ticket.getPage(), ticket.getMaxPageItem(),
                    new Sorter(ticket.getSortName(), ticket.getSortBy()));
            ticket.setListResult(iTicketService.findAll(pageble));
            ticket.setTotalItem(iTicketService.getTotalItem());
            ticket.setTotalPage((int) Math.ceil((double) ticket.getTotalItem() / ticket.getMaxPageItem()));

            view = "views/carpark_manager/tickets_manager/list.jsp";
        } else if(ticket.getType().equals(SystemConstant.EDIT)) {
            if (ticket.getTicketId() != null) {
                ticket = iTicketService.findOne(ticket.getTicketId());
            }
            request.setAttribute("cars", iCarService.findAll());
            request.setAttribute("trips", iTripService.findAll());
            view = "views/carpark_manager/tickets_manager/edit.jsp";
        }

        MessageUtil.showMessage(request);
        request.setAttribute(SystemConstant.MODEL, ticket);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(view);
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
