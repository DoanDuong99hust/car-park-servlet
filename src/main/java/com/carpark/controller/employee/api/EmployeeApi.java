package com.carpark.controller.employee.api;

import com.carpark.model.Employee;
import com.carpark.model.JsonResult;
import com.carpark.paging.PageRequest;
import com.carpark.paging.Pageble;
import com.carpark.service.IEmployeeService;
import com.carpark.sort.Sorter;
import com.carpark.utils.FormUtil;
import com.carpark.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/api/employee-list"})
public class EmployeeApi extends HttpServlet {
    @Inject
    private IEmployeeService iEmployeeService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Employee newModel = HttpUtil.of(request.getReader()).toModel(Employee.class);
        // convert model to json -> tra ve client
        mapper.writeValue(response.getOutputStream(), newModel);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Employee newModel = HttpUtil.of(request.getReader()).toModel(Employee.class);
        // luu vao db
        newModel = iEmployeeService.save(newModel);
        // convert model to json -> tra ve client
        mapper.writeValue(response.getOutputStream(), newModel);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Employee updateNew = HttpUtil.of(request.getReader()).toModel(Employee.class);
        updateNew = iEmployeeService.update(updateNew);
        // convert model to json -> tra ve client
        mapper.writeValue(response.getOutputStream(), updateNew);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Employee deleteNew = HttpUtil.of(request.getReader()).toModel(Employee.class);
        iEmployeeService.delete(deleteNew.getIds());
        mapper.writeValue(response.getOutputStream(), "{}");
    }
}
