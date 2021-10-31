package com.carpark.controller;

import com.carpark.model.User;
import com.carpark.service.IUserService;
import com.carpark.utils.FormUtil;
import com.carpark.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/home-page", "/login", "/logout"})
public class AccessController extends HttpServlet {
    @Inject
    private IUserService iUserService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("login")) {
            RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
            rd.forward(request, response);
        } else if (action != null && action.equals("logout")) {
            SessionUtil.getInstance().removeValue(request, "USERMODEL");
            response.sendRedirect(request.getContextPath()+"/home-page");
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/views/home.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("login")) {
            User model = FormUtil.toModel(User.class, request);
            model = iUserService.findByUserNameAndPasswordAndStatus(model.getUserName(), model.getPassword(), 1);
            if (model != null) {
                SessionUtil.getInstance().putValue(request, "USERMODEL", model);
                if (model.getRole().getCode().equals("HUMAN_RESOURCE")) {
                    response.sendRedirect(request.getContextPath()+"/employee-home");
                } else if (model.getRole().getCode().equals("CAR_ADMIN")) {
                    response.sendRedirect(request.getContextPath()+"/car-park");
                }
            } else {
                response.sendRedirect(request.getContextPath()+"/login?action=login&message=username_password_invalid&alert=danger");
            }
        }
    }
}
