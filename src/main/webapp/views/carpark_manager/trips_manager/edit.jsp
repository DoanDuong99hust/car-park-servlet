<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp"%>
        <c:url var="APIurl" value="/car-park/api/trip-list" />
        <c:url var="NewURL" value="/car-park-trip-list" />
        <html>

        <head>
            <title>Add trip</title>
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
                <h2 class="pt-3">Add Trip</h2>
                <hr class="border">
                <div class="row">
                    <div class="col-sm-3 flex-row">
                        <div>
                            <label class="m-2"><b>Destination <span class="text-danger">(*)</span></b></label>
                        </div>
                        <div>
                            <label class="m-2"><b>Departure time <span class="text-danger">(*)</span></b></label>
                        </div>
                        <div>
                            <label class="m-2"><b>Driver <span class="text-danger">(*)</span></b></label>
                        </div>
                        <div>
                            <label class="m-2"><b>Car type <span class="text-danger">(*)</span></b></label>
                        </div>
                        <div>
                            <label class="m-2"><b>Maximum online ticket number <span class="text-danger">(*)</span></b></label>
                        </div>
                        <div>
                            <label class="m-2"><b>Departure date <span class="text-danger">(*)</span></b></label>
                        </div>
                    </div>
                    <div class="col-sm-6 flex-row">
                        <form id="formSubmit">
                            <div>
                                <input class="p-1 m-1 border rounded" type="text" name="destination" id="destination" placeholder="Enter destination" value="${model.destination}">
                            </div>
                            <div>
                                <input class="p-1 m-1 border rounded" type="time" name="departureTime" id="departureTime" value="${model.departureTime}">
                            </div>
                            <div>
                                <input class="p-1 m-1 border rounded" type="text" name="driverName" id="driverName" placeholder="Enter driver" value="${model.driverName}">
                            </div>
                            <div>
                                <input class="p-1 m-1 border rounded" type="text" name="carType" id="carType" placeholder="Enter car type" value="${model.carType}">
                            </div>
                            <div>
                                <input class="p-1 m-1 border rounded" type="number" name="maximumOnlineTicketNumber" id="maximumOnlineTicketNumber" placeholder="Enter maximum online ticket number" value="${model.maximumOnlineTicketNumber}">
                            </div>
                            <div>
                                <input class="p-1 m-1 border rounded" type="date" name="departureDate" id="departureDate" value="${model.departureDate}">
                            </div>
                        </form>

                    </div>
                </div>
                <div class="row ">
                    <div class="col-sm-6 d-flex justify-content-center">
                        <div onclick="goBack()" class="btn btn-info p-1 m-1"><i class="fas fa-backward"></i> Back</div>
                        <div onclick="resetInput()" class="btn btn-warning text-white p-1 m-1"><i class="fas fa-undo-alt"></i> Reset</div>
                        <c:if test="${not empty model.tripId}">
                            <div onclick="addOrUpdateData()" id="addEmployee" class="btn btn-success p-1 m-1"><i class="fas fa-plus"></i> Update</div>
                        </c:if>
                        <c:if test="${empty model.tripId}">
                            <div onclick="addOrUpdateData()" id="addEmployee" class="btn btn-success p-1 m-1"><i class="fas fa-plus"></i> Add</div>
                        </c:if>
                    </div>
                    <input type="hidden" value="${model.tripId}" id="id" name="id" />
                </div>
            </div>
            </div>
            <script>
                function addOrUpdateData() {
                    var data = {};
                    data["destination"] = $('#destination').val()
                    var departureTime = $('#departureTime').val()
                    data["departureTime"] = departureTime
                    data["driverName"] = $('#driverName').val()
                    data["carType"] = $('#carType').val()
                    data["maximumOnlineTicketNumber"] = parseInt($('#maximumOnlineTicketNumber').val())
                    var departureDate = $('#departureDate').val()
                    data["departureDate"] = moment(departureDate, 'YYYY-MM-DD').format("YYYY-MM-DD")


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
                            data["tripId"] = id
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
                            window.location.href = "${NewURL}?type=list&page=1&maxPageItem=2&sortName=tripId&sortBy=desc"
                        },
                        error: function(error) {
                            window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";
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
                            window.location.href = "${NewURL}?type=list&page=1&maxPageItem=2&sortName=tripId&sortBy=desc"
                        },
                        error: function(error) {
                            window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";
                        }
                    });
                }

                function resetInput() {
                    $('#destination').val(null)
                    $('#departureTime').val(null)
                    $('#driver').val(null)
                    $('#carType').val(null)
                    $('#maximumOnlineTicketNumber').val(null)
                    $('#departureDate').val(null)
                }

                function goBack() {
                    window.history.back();
                }
            </script>
        </body>

        </html>