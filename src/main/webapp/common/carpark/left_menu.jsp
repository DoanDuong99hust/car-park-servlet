<%--
  Created by IntelliJ IDEA.
  User: Shisui
  Date: 10/24/2021
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Left menu  -->
<div class="col-sm-3 bg-light p-0 border h-auto">
    <div class="bg-light border">
        <div class="row mt-3 mb-3 justify-content-center">
            <span class="text-primary"><i class="fas fa-home"></i> Car park manager</span>
        </div>
    </div>
    <div class="dropdown bg-light" style="height: 110px">
        <div class="btn btn-light d-flex justify-content-center dropdown-toggle" data-toggle="dropdown">
            <span> <i class="fas fa-car"></i> Car Management</span>
        </div>
        <div class="dropdown-menu bg-light border-0">
            <a class="dropdown-item" href='<c:url value="/car-park-car-list?type=list&page=1&maxPageItem=2&sortName=carId&sortBy=desc"/>'><i class="fas fa-list"></i> Car list</a>
            <a class="dropdown-item" href='<c:url value="/car-park-car-list?type=edit"/>'><i class="fas fa-plus"></i> Add car</a>
        </div>
    </div>
    <div class="dropdown bg-light" style="height: 110px">
        <div class="btn btn-light d-flex justify-content-center dropdown-toggle" data-toggle="dropdown">
            <span> <i class="fas fa-cart-arrow-down"></i> Booking office Management</span>
        </div>
        <div class="dropdown-menu bg-light border-0">
            <a class="dropdown-item" href='<c:url value="/car-park-booking-office-list?type=list&page=1&maxPageItem=2&sortName=officeId&sortBy=desc"/>'><i class="fas fa-list"></i> Booking office list</a>
            <a class="dropdown-item" href='<c:url value="/car-park-booking-office-list?type=edit"/>'><i class="fas fa-plus"></i> Add Booking office</a>
        </div>
    </div>
    <div class="dropdown bg-light" style="height: 110px">
        <div class="btn btn-light d-flex justify-content-center dropdown-toggle" data-toggle="dropdown">
            <span> <i class="fas fa-map-marker-alt"></i> Parking lot Management</span>
        </div>
        <div class="dropdown-menu bg-light border-0">
            <a class="dropdown-item" href='<c:url value="/car-park-parking-lot-list?type=list&page=1&maxPageItem=2&sortName=parkId&sortBy=desc"/>'><i class="fas fa-list"></i> Parking lot list</a>
            <a class="dropdown-item" href='<c:url value="/car-park-parking-lot-list?type=edit"/>'><i class="fas fa-plus"></i> Add Parking lot</a>
        </div>
    </div>
</div>
