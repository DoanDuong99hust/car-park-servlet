<%--
  Created by IntelliJ IDEA.
  User: Shisui
  Date: 10/18/2021
  Time: 6:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Left menu  -->
<div class="col-sm-3 bg-light p-0 border h-auto">
    <div class="bg-light border">
        <div class="row mt-3 mb-3 justify-content-center">
            <span class="text-primary">Dashbroad</span>
        </div>
    </div>
    <div class="dropdown bg-light">
        <div class="btn btn-light d-flex justify-content-center dropdown-toggle" data-toggle="dropdown">
            <span> <i class="fas fa-chart-bar"></i> Employee Management</span>
        </div>
        <div class="dropdown-menu bg-light border-0">
            <a class="dropdown-item" href='<c:url value="/employee-list?type=list&page=1&maxPageItem=3&sortName=employeeId&sortBy=desc"/>'><i class="fas fa-list"></i> Employee list</a>
            <a class="dropdown-item" href='<c:url value="/employee-list?type=edit"/>'><i class="fas fa-plus"></i> Add employee</a>
        </div>
    </div>
</div>
