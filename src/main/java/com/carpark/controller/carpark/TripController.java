package com.carpark.controller.carpark;

import com.carpark.constant.SystemConstant;
import com.carpark.model.Ticket;
import com.carpark.model.Trip;
import com.carpark.paging.PageRequest;
import com.carpark.paging.Pageble;
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

@WebServlet(urlPatterns = {"/car-park-trip-list"})
public class TripController extends HttpServlet {

    @Inject
    private ITripService iTripService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Trip trip = FormUtil.toModel(Trip.class, request);
        String view = "";
        if (trip.getType().equals(SystemConstant.LIST)) {
            Pageble pageble = new PageRequest(trip.getPage(), trip.getMaxPageItem(),
                    new Sorter(trip.getSortName(), trip.getSortBy()));
            trip.setListResult(iTripService.findAll(pageble));
            trip.setTotalItem(iTripService.getTotalItem());
            trip.setTotalPage((int) Math.ceil((double) trip.getTotalItem() / trip.getMaxPageItem()));

            view = "views/carpark_manager/trips_manager/list.jsp";
        } else if(trip.getType().equals(SystemConstant.EDIT)) {
            if (trip.getTripId() != null) {
                trip = iTripService.findOne(trip.getTripId());
            }
            view = "views/carpark_manager/trips_manager/edit.jsp";
        }

        MessageUtil.showMessage(request);
        request.setAttribute(SystemConstant.MODEL, trip);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(view);
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
