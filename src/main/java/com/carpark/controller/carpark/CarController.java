package com.carpark.controller.carpark;

import com.carpark.constant.SystemConstant;
import com.carpark.model.Car;
import com.carpark.paging.PageRequest;
import com.carpark.paging.Pageble;
import com.carpark.service.ICarService;
import com.carpark.service.IParkingLotService;
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

@WebServlet(urlPatterns = {"/car-park-car-list"})
public class CarController extends HttpServlet {
    @Inject
    private ICarService iCarService;

    @Inject
    private IParkingLotService iParkingLotService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Car car = FormUtil.toModel(Car.class, request);
        String view = "";
        if (car.getType().equals(SystemConstant.LIST)) {
            Pageble pageble = new PageRequest(car.getPage(), car.getMaxPageItem(),
                    new Sorter(car.getSortName(), car.getSortBy()));
            car.setListResult(iCarService.findAll(pageble));
            car.setTotalItem(iCarService.getTotalItem());
            car.setTotalPage((int) Math.ceil((double) car.getTotalItem() / car.getMaxPageItem()));
            request.setAttribute("parkingLots", iParkingLotService.findAll());
            view = "views/carpark_manager/car_management/list.jsp";
        } else if(car.getType().equals(SystemConstant.EDIT)) {
            if (car.getCarId() != null) {
                car = iCarService.findOne(car.getCarId());
            }
            request.setAttribute("parkingLots", iParkingLotService.findAll());
            view = "views/carpark_manager/car_management/edit.jsp";
        }

        MessageUtil.showMessage(request);
        request.setAttribute(SystemConstant.MODEL, car);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(view);
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
