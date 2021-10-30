package com.carpark.controller.carpark.api;

import com.carpark.model.Car;
import com.carpark.service.ICarService;
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

@WebServlet(urlPatterns = {"/car-park/api/car-list"})
public class CarApi extends HttpServlet {
    @Inject
    private ICarService iCarService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Car car = FormUtil.toModel(Car.class, request);
        car.setListResult(iCarService.findAll());
        mapper.writeValue(response.getOutputStream(), car);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Car car = HttpUtil.of(request.getReader()).toModel(Car.class);
        car = iCarService.save(car);
        mapper.writeValue(response.getOutputStream(), car);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Car updateCar = HttpUtil.of(request.getReader()).toModel(Car.class);
        updateCar = iCarService.update(updateCar);
        mapper.writeValue(response.getOutputStream(), updateCar);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Car deleteCar = HttpUtil.of(request.getReader()).toModel(Car.class);
        iCarService.delete(deleteCar.getIds());
        mapper.writeValue(response.getOutputStream(), "{}");
    }
}
