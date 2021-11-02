<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp"%>
        <c:url var="APIurl" value="/car-park/api/ticket-list" />
        <c:url var="NewURL" value="/car-park-ticket-list" />
        <html>

        <head>
            <title>Add ticket</title>
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
                <h2 class="pt-3">Add Ticket</h2>
                <hr class="border">
                <div class="row">
                    <div class="col-sm-3 flex-row">
                        <div>
                            <label class="m-2"><b>Customer <span class="text-danger">(*)</span></b></label>
                        </div>
                        <div>
                            <label class="m-2"><b>Booking time <span class="text-danger">(*)</span></b></label>
                        </div>
                        <div>
                            <label class="m-2"><b>Trip <span class="text-danger">(*)</span></b></label>
                        </div>
                        <div>
                            <label class="m-2"><b>License plate <span class="text-danger">(*)</span></b></label>
                        </div>
                    </div>
                    <div class="col-sm-6 flex-row">
                        <form id="formSubmit">
                            <div>
                                <input class="p-1 m-1 border rounded" type="text" name="customerName" id="customerName" placeholder="Enter customer name" value="${model.customerName}">
                            </div>
                            <div>
                                <input class="p-1 m-1 border rounded" type="time" name="bookingTime" id="bookingTime" value="${model.bookingTime}">
                            </div>
                            <div>
                                <select class="p-1 m-1 border rounded" name="tripId" id="tripId">
                                    <c:forEach var="item" items="${trips}">
                                        <option value="${item.tripId}">${item.destination}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div>
                                <select class="p-1 m-1 border rounded" name="licensePlate" id="licensePlate">
                                    <c:forEach var="item" items="${cars}">
                                        <option value="${item.licensePlate}">${item.licensePlate}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </form>

                    </div>
                </div>
                <div class="row ">
                    <div class="col-sm-6 d-flex justify-content-center">
                        <div onclick="goBack()" class="btn btn-info p-1 m-1"><i class="fas fa-backward"></i> Back</div>
                        <div onclick="resetInput()" class="btn btn-warning text-white p-1 m-1"><i class="fas fa-undo-alt"></i> Reset</div>
                        <c:if test="${not empty model.ticketId}">
                            <div onclick="addOrUpdateData()" id="addEmployee" class="btn btn-success p-1 m-1"><i class="fas fa-plus"></i> Update</div>
                        </c:if>
                        <c:if test="${empty model.ticketId}">
                            <div onclick="addOrUpdateData()" id="addEmployee" class="btn btn-success p-1 m-1"><i class="fas fa-plus"></i> Add</div>
                        </c:if>
                    </div>
                    <input type="hidden" value="${model.ticketId}" id="id" name="id" />
                </div>
            </div>
            </div>
            <script>
                function addOrUpdateData() {
                    var data = {};
                    data["customerName"] = $('#customerName').val()
                    var bookingTime = $('#bookingTime').val()
                    data["bookingTime"] = bookingTime
                    data["tripId"] = $('select#tripId').children("option:selected").val()
                    data["licensePlate"] = $('select#licensePlate').children("option:selected").val()

                    console.log(data)
                    var checkData = []
                    $.each(data, function(index, value) {
                        checkData.push(value)
                    })
                    if ($.inArray("", checkData) >= 0 || $.inArray(undefined, checkData) >= 0) {
                        alert("Please insert full information!")
                    } else {
                        var id = $('#id').val();
                        if (id == "") {
                            addNew(data)
                        } else {
                            data["parkId"] = id
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
                            window.location.href = "${NewURL}?type=list&page=1&maxPageItem=2&sortName=ticketId&sortBy=desc"
                        },
                        error: function(error) {
                            <%--window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";--%>
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
                            <%--window.location.href = "${NewURL}?type=edit&id=" + result.officeId + "&message=update_success";--%>
                            window.location.href = "${NewURL}?type=list&page=1&maxPageItem=2&sortName=parkId&sortBy=desc"
                        },
                        error: function(error) {
                            window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";
                        }
                    });
                }

                function resetInput() {
                    $('#customerName').val(null)
                    $('#parkArea').val(null)
                    $('select#tripId').children("option:selected").val(null)
                    $('select#licensePlate').children("option:selected").val(null)
                }

                function goBack() {
                    window.history.back();
                }
            </script>
        </body>

        </html>