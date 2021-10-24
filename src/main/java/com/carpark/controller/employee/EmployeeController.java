package com.carpark.controller.employee;


import com.carpark.constant.SystemConstant;
import com.carpark.model.Employee;
import com.carpark.paging.PageRequest;
import com.carpark.paging.Pageble;
import com.carpark.service.IEmployeeService;
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

@WebServlet(urlPatterns = {"/employee-list"})
public class EmployeeController extends HttpServlet {
    @Inject
    private IEmployeeService iEmployeeService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee model = FormUtil.toModel(Employee.class, request);
//        Employee model = new Employee();
        String view = "";
        if (model.getType().equals(SystemConstant.LIST)) {
            Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
                    new Sorter(model.getSortName(), model.getSortBy()));
            model.setListResult(iEmployeeService.findAll(pageble));
            model.setTotalItem(iEmployeeService.getTotalItem());
            model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
            view = "/views/employee/list.jsp";
        } else if (model.getType().equals(SystemConstant.EDIT)) {
            if (model.getEmployeeId() != null) {
                model = iEmployeeService.findOne(model.getEmployeeId());
            }
//            request.setAttribute("categories", categoryService.findAll());
            view = "/views/employee/edit.jsp";
        }
//        if (model.getType().equals(SystemConstant.LIST)) {
//            model.setListResult(iEmployeeService.findAll());
//            view = "/views/employee/list.jsp";
//        } else if (model.getType().equals(SystemConstant.EDIT)) {
//            view = "/views/employee/edit.jsp";
//        }

        MessageUtil.showMessage(request);
        request.setAttribute(SystemConstant.MODEL, model);
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
