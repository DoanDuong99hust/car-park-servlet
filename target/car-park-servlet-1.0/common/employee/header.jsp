<%--
  Created by IntelliJ IDEA.
  User: Shisui
  Date: 10/18/2021
  Time: 6:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="w-100 bg-light border border-5 border-bottom-secondary">
    <div class="d-flex justify-content-between p-2">
        <span id="backto-edit" class="text-secondary"><i class="fas fa-users"></i> Employee</span>
        <div class="user-option text-primary">
            <span>Welcome, ${USERMODEL.fullName}</span>
            <a href="<c:url value="/logout?action=logout"/> ">Logout <i class="fas fa-sign-out-alt"></i></a>
        </div>
    </div>
</div>