package com.carpark.controller.carpark.api;

import com.carpark.model.ParkingLot;
import com.carpark.service.IParkingLotService;
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

@WebServlet(urlPatterns = {"/car-park/api/parking-lot-list"})
public class ParkingLotApi extends HttpServlet {

    @Inject
    private IParkingLotService iParkingLotService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        ParkingLot parkingLot = FormUtil.toModel(ParkingLot.class, request);
        parkingLot.setListResult(iParkingLotService.findAll());
        mapper.writeValue(response.getOutputStream(), parkingLot);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        ParkingLot parkingLot = HttpUtil.of(request.getReader()).toModel(ParkingLot.class);
        parkingLot = iParkingLotService.save(parkingLot);
        mapper.writeValue(response.getOutputStream(), parkingLot);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        ParkingLot updateParkingLot = HttpUtil.of(request.getReader()).toModel(ParkingLot.class);
        updateParkingLot = iParkingLotService.update(updateParkingLot);
        mapper.writeValue(response.getOutputStream(), updateParkingLot);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        ParkingLot deleteParkingLot = HttpUtil.of(request.getReader()).toModel(ParkingLot.class);
        iParkingLotService.delete(deleteParkingLot.getIds());
        mapper.writeValue(response.getOutputStream(), "{}");
    }
}
