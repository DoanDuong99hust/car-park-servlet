package com.carpark.controller.carpark;

import com.carpark.constant.SystemConstant;
import com.carpark.model.ParkingLot;
import com.carpark.paging.PageRequest;
import com.carpark.paging.Pageble;
import com.carpark.service.IParkingLotService;
import com.carpark.sort.Sorter;
import com.carpark.utils.FormUtil;
import com.carpark.utils.HttpUtil;
import com.carpark.utils.MessageUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/car-park-parking-lot-list"})
public class ParkingLotController extends HttpServlet {

    @Inject
    private IParkingLotService iParkingLotService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ParkingLot parkingLot = FormUtil.toModel(ParkingLot.class, request);
        String view = "";
        if (parkingLot.getType().equals(SystemConstant.LIST)) {
            Pageble pageble = new PageRequest(parkingLot.getPage(), parkingLot.getMaxPageItem(),
                    new Sorter(parkingLot.getSortName(), parkingLot.getSortBy()));
            parkingLot.setListResult(iParkingLotService.findAll(pageble));
            parkingLot.setTotalItem(iParkingLotService.getTotalItem());
            parkingLot.setTotalPage((int) Math.ceil((double) parkingLot.getTotalItem() / parkingLot.getMaxPageItem()));

            view = "views/carpark_manager/parking_lot/list.jsp";
        } else if(parkingLot.getType().equals(SystemConstant.EDIT)) {
            if (parkingLot.getParkId() != null) {
                parkingLot = iParkingLotService.findOne(parkingLot.getParkId());
            }
            view = "views/carpark_manager/parking_lot/edit.jsp";
        }

        MessageUtil.showMessage(request);
        request.setAttribute(SystemConstant.MODEL, parkingLot);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(view);
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
