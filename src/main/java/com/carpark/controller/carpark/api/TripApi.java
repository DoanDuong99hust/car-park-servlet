package com.carpark.controller.carpark.api;

import com.carpark.model.ParkingLot;
import com.carpark.model.Ticket;
import com.carpark.model.Trip;
import com.carpark.service.ITripService;
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

@WebServlet(urlPatterns = {"/car-park/api/trip-list"})
public class TripApi extends HttpServlet {

    @Inject
    private ITripService iTripService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Trip trip = FormUtil.toModel(Trip.class, request);
        trip.setListResult(iTripService.findAll());
        mapper.writeValue(response.getOutputStream(), trip);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Trip trip = HttpUtil.of(request.getReader()).toModel(Trip.class);
        trip = iTripService.save(trip);
        mapper.writeValue(response.getOutputStream(), trip);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Trip updateTrip = HttpUtil.of(request.getReader()).toModel(Trip.class);
        updateTrip = iTripService.update(updateTrip);
        mapper.writeValue(response.getOutputStream(), updateTrip);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        ParkingLot deleteParkingLot = HttpUtil.of(request.getReader()).toModel(ParkingLot.class);
        iTripService.delete(deleteParkingLot.getIds());
        mapper.writeValue(response.getOutputStream(), "{}");
    }
}
