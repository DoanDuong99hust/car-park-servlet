<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp"%>
        <c:url var="APIurl" value="/api/employee-list" />
        <c:url var="NewURL" value="/employee-list" />
        <html>

        <head>
            <title>Add Employee</title>
            <!-- Required meta tags -->
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
            <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css" integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous">
            <!-- Bootstrap CSS -->
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>
            <!-- Right content  -->
            <!-- Add profile  -->
            <div class="col-sm-9">
                <h2 class="pt-3">Add Employee</h2>
                <hr class="border">
                <div class="row">
                    <div class="col-sm-3 flex-row">
                        <div>
                            <label class="m-2"><b>Full name <span class="text-danger">(*)</span></b></label>
                        </div>
                        <div>
                            <label class="m-2"><b>Phone number <span class="text-danger">(*)</span></b></label>
                        </div>
                        <div>
                            <label class="m-2"><b>Date of birth <span class="text-danger">(*)</span></b></label>
                        </div>
                        <div>
                            <label class="m-2"><b>Sex <span class="text-danger">(*)</span></b></label>
                        </div>
                        <div>
                            <label class="m-2"><b>Address </b></label>
                        </div>
                        <div>
                            <label class="m-2"><b>Email </b></label>
                        </div>
                        <div>
                            <label class="m-2"><b>Account <span class="text-danger">(*)</span></b></label>
                        </div>
                        <div>
                            <label class="m-2"><b>Password <span class="text-danger">(*)</span></b></label>
                        </div>
                        <div>
                            <label class="m-2"><b>Deparment <span class="text-danger">(*)</span></b></label>
                        </div>
                    </div>
                    <div class="col-sm-6 flex-row">
                        <form id="formSubmit">
                            <div>
                                <input class="p-1 m-1 border rounded" type="text" name="employeeName" id="employeeName" placeholder="Enter full name" value="${model.employeeName}">
                            </div>
                            <div>
                                <input class="p-1 m-1 border rounded" type="text" name="employeePhone" id="employeePhone" placeholder="Enter phone number" value="${model.employeePhone}">
                            </div>
                            <div>
                                <input class="p-1 m-1 border rounded" type="date" name="employeeBirthday" id="employeeBirthday" value="${model.employeeBirthday}">
                            </div>
                            <form>
                                <input class="p-1 m-1 border rounded" type="radio" name="sex" value="male" id="gender_male">
                                <label><b>Male</b></label>
                                <input class="p-1 m-1 border rounded" type="radio" name="sex" value="female" id="gender_female">
                                <label><b>Female</b></label>
                            </form>
                            <div>
                                <input class="p-1 m-1 border rounded" type="text" name="employeeAddress" id="employeeAddress" placeholder="Enter address" value="${model.employeeAddress}">
                            </div>
                            <div>
                                <input class="p-1 m-1 border rounded" type="text" name="employeeEmail" id="employeeEmail" placeholder="Enter email" value="${model.employeeEmail}">
                            </div>
                            <div>
                                <input class="p-1 m-1 border rounded" type="text" name="account" id="account" placeholder="Enter account" value="${model.account}">
                            </div>
                            <div>
                                <input class="p-1 m-1 border rounded" type="password" name="password" id="password" value="${model.password}" placeholder="Enter password">
                                <div id="password-warning" class="text-danger small"></div>
                            </div>
                            <div>
                                <select class="p-1 m-1 border rounded" name="department" id="department">
              <option value="employee">Employee</option>
              <option value="manager">Manager</option>
            </select>
                            </div>
                        </form>

                    </div>
                </div>
                <div class="row ">
                    <div class="col-sm-6 d-flex justify-content-center">
                        <div onclick="goBack()" class="btn btn-info p-1 m-1"><i class="fas fa-backward"></i> Back</div>
                        <div onclick="resetInput()" class="btn btn-warning text-white p-1 m-1"><i class="fas fa-undo-alt"></i> Reset</div>
                        <c:if test="${not empty model.employeeId}">
                            <div onclick="addOrUpdateData()" id="addEmployee" class="btn btn-success p-1 m-1"><i class="fas fa-plus"></i> Update</div>
                        </c:if>
                        <c:if test="${empty model.employeeId}">
                            <div onclick="addOrUpdateData()" id="addEmployee" class="btn btn-success p-1 m-1"><i class="fas fa-plus"></i> Add</div>
                        </c:if>
                    </div>
                    <input type="hidden" value="${model.employeeId}" id="id" name="id" />
                </div>
            </div>
            </div>
            <script>
                function checkPassword(password) {
                    var pattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,}$/;
                    if (pattern.test(password)) {
                        return true;
                    } else {
                        return false;
                    }
                }
                $('#password').change(function() {
                    var password = $('#password').val()
                    console.log("change")
                    console.log(checkPassword(password))
                    if (checkPassword(password)) {
                        $('#password').removeClass('border-danger')
                        $('#password-warning').html("")
                    } else {
                        $('#password').addClass('border-danger')
                        $('#password-warning').html("The password must have at least 6 characters,including uppercase, lowercase and number.")
                    }
                })
                function addOrUpdateData() {
                    var data = {};
                    data["employeeName"] = $('#employeeName').val()
                    data["employeePhone"] = $('#employeePhone').val()
                    data["employeeBirthday"] = $('#employeeBirthday').val()
                    data["sex"] = $("input[name='sex']:checked").val()
                    data["employeeAddress"] = $('#employeeAddress').val()
                    data["employeeEmail"] = $('#employeeEmail').val()
                    data["account"] = $('#account').val()
                    data["password"] = $('#password').val()
                    data["department"] = $('select#department').children("option:selected").val()

                  var checkData = []
                  $.each(data, function(index, value) {
                    checkData.push(value)
                  })
                  // console.log($.inArray("" || undefined, checkData))
                  if ($.inArray("", checkData) >= 0 || $.inArray(undefined, checkData) >= 0) {
                    alert("Please insert full information!")
                  } else {
                    var id = $('#id').val();
                    if (id == "") {
                      addNew(data)
                    } else {
                      data["employeeId"] = id
                      updateNew(data)
                    }
                  }
                }

                function addNew(data) {
                    $.ajax({
                        url: '${APIurl}',
                        type: 'POST',
                        contentType: 'application/json',
                        data: JSON.stringify(data),
                        dataType: 'json',
                        success: function(result) {
                            <%--window.location.href = "${NewURL}?type=edit&id="+result.id+"&message=insert_success";--%>
                            window.location.href = "${NewURL}?type=list&page=1&maxPageItem=3&sortName=employeeId&sortBy=desc"
                        },
                        error: function(error) {
                            window.location.href = "${NewURL}?type=list&maxPageItem=3&page=1&message=error_system";
                        }
                    });
                }

                function updateNew(data) {
                    $.ajax({
                        url: '${APIurl}',
                        type: 'PUT',
                        contentType: 'application/json',
                        data: JSON.stringify(data),
                        dataType: 'json',
                        success: function(result) {
                            window.location.href = "${NewURL}?type=edit&id=" + result.employeeId + "&message=update_success";
                            window.location.href = "${NewURL}?type=type=list&page=1&maxPageItem=3&sortName=employeeId&sortBy=desc"
                        },
                        error: function(error) {
                            window.location.href = "${NewURL}?type=list&maxPageItem=3&page=1&message=error_system";
                        }
                    });
                }

                function resetInput() {
                    $('#employeeName').val(null)
                    $('#employeePhone').val(null)
                    $('#employeeBirthday').val(null)
                    $("input[name='sex']:checked").val(null)
                    $('#employeeAddress').val(null)
                    $('#employeeEmail').val(null)
                    $('#account').val(null)
                    $('#password').val(null)
                    $('select#department').children("option:selected").val(null)
                }

                function goBack() {
                    window.history.back();
                }
            </script>
        </body>

        </html>