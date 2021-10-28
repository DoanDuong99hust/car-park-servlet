package com.carpark.controller.carpark;

import com.carpark.constant.SystemConstant;
import com.carpark.model.BookingOffice;
import com.carpark.paging.PageRequest;
import com.carpark.paging.Pageble;
import com.carpark.service.IBookingOfficeService;
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

@WebServlet(urlPatterns = {"/car-park-booking-office-list"})
public class BookingOfficeController extends HttpServlet {

    @Inject
    private IBookingOfficeService iBookingOfficeService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookingOffice bookingOffice = FormUtil.toModel(BookingOffice.class, request);
        String view = "";
        if (bookingOffice.getType().equals(SystemConstant.LIST)) {
            Pageble pageble = new PageRequest(bookingOffice.getPage(), bookingOffice.getMaxPageItem(),
                    new Sorter(bookingOffice.getSortName(), bookingOffice.getSortBy()));
            bookingOffice.setListResult(iBookingOfficeService.findAll(pageble));
            bookingOffice.setTotalItem(iBookingOfficeService.getTotalItem());
            bookingOffice.setTotalPage((int) Math.ceil((double) bookingOffice.getTotalItem() / bookingOffice.getMaxPageItem()));

            view = "views/carpark_manager/booking_office/list.jsp";
        } else if (bookingOffice.getType().equals(SystemConstant.EDIT)) {
            if (bookingOffice.getOfficeId() != null) {
                bookingOffice = iBookingOfficeService.findOne(bookingOffice.getOfficeId());
            }
            view = "views/carpark_manager/booking_office/edit.jsp";
        }

        MessageUtil.showMessage(request);
        request.setAttribute(SystemConstant.MODEL, bookingOffice);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(view);
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
