package com.carpark.controller.carpark.api;

import com.carpark.model.BookingOffice;
import com.carpark.model.Employee;
import com.carpark.service.IBookingOfficeService;
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

@WebServlet(urlPatterns = {"/car-park/api/booking-office-list"})
public class BookingOfficeApi extends HttpServlet {

    @Inject
    private IBookingOfficeService iBookingOfficeService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        BookingOffice bookingOffice = FormUtil.toModel(BookingOffice.class, request);
        bookingOffice.setListResult(iBookingOfficeService.findAll());
        mapper.writeValue(response.getOutputStream(), bookingOffice);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        BookingOffice bookingOffice = HttpUtil.of(request.getReader()).toModel(BookingOffice.class);
        bookingOffice = iBookingOfficeService.save(bookingOffice);
        mapper.writeValue(response.getOutputStream(), bookingOffice);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        BookingOffice updateBooking = HttpUtil.of(request.getReader()).toModel(BookingOffice.class);
        updateBooking = iBookingOfficeService.update(updateBooking);
        mapper.writeValue(response.getOutputStream(), updateBooking);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        BookingOffice deleteBooking = HttpUtil.of(request.getReader()).toModel(BookingOffice.class);
        iBookingOfficeService.delete(deleteBooking.getIds());
        mapper.writeValue(response.getOutputStream(), "{}");
    }
}
