<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp"%>
        <c:url var="APIurl" value="/car-park/api/parking-lot-list" />
        <c:url var="NewURL" value="/car-park-parking-lot-list" />
        <html>

        <head>
            <title>Add Parking lot</title>
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
                <h2 class="pt-3">Add Parking lot</h2>
                <hr class="border">
                <div class="row">
                    <div class="col-sm-3 flex-row">
                        <div>
                            <label class="m-2"><b>Parking name <span class="text-danger">(*)</span></b></label>
                        </div>
                        <div>
                            <label class="m-2"><b>Place <span class="text-danger">(*)</span></b></label>
                        </div>
                        <div>
                            <label class="m-2"><b>Area <span class="text-danger">(*)</span></b></label>
                        </div>
                        <div>
                            <label class="m-2"><b>Price <span class="text-danger">(*)</span></b></label>
                        </div>
                        <div>
                            <label class="m-2"><b>Status <span class="text-danger">(*)</span></b></label>
                        </div>
                    </div>
                    <div class="col-sm-6 flex-row">
                        <form id="formSubmit">
                            <div>
                                <input class="p-1 m-1 border rounded" type="text" name="parkName" id="parkName" placeholder="Enter park name" value="${model.parkName}">
                            </div>
                            <div>
                                <select class="p-1 m-1 border rounded" name="parkPlace" id="parkPlace">
                                    <option value="Khu Đông">Khu Đông</option>
                                    <option value="Khu Tây">Khu Tây</option>
                                    <option value="Khu Bắc">Khu Bắc</option>
                                    <option value="Khu Nam">Khu Nam</option>
                                </select>
                            </div>
                            <div>
                                <input class="p-1 m-1 border rounded" type="text" name="parkArea" id="parkArea" placeholder="Enter area" value="${model.parkArea}">
                            </div>
                            <div>
                                <input class="p-1 m-1 border rounded" type="text" name="parkPrice" id="parkPrice" placeholder="Enter price" value="${model.parkPrice}">
                            </div>
                            <div>
                                <select class="p-1 m-1 border rounded" name="parkStatus" id="parkStatus">
                                    <option value="Blank">Blank</option>
                                    <option value="Full">Full</option>
                                </select>
                            </div>
                        </form>

                    </div>
                </div>
                <div class="row ">
                    <div class="col-sm-6 d-flex justify-content-center">
                        <div onclick="goBack()" class="btn btn-info p-1 m-1"><i class="fas fa-backward"></i> Back</div>
                        <div onclick="resetInput()" class="btn btn-warning text-white p-1 m-1"><i class="fas fa-undo-alt"></i> Reset</div>
                        <c:if test="${not empty model.parkId}">
                            <div onclick="addOrUpdateData()" id="addEmployee" class="btn btn-success p-1 m-1"><i class="fas fa-plus"></i> Update</div>
                        </c:if>
                        <c:if test="${empty model.parkId}">
                            <div onclick="addOrUpdateData()" id="addEmployee" class="btn btn-success p-1 m-1"><i class="fas fa-plus"></i> Add</div>
                        </c:if>
                    </div>
                    <input type="hidden" value="${model.parkId}" id="id" name="id" />
                </div>
            </div>
            </div>
            <script>
                function addOrUpdateData() {
                    var data = {};
                    data["parkName"] = $('#parkName').val()
                    data["parkPlace"] = $('select#parkPlace').children("option:selected").val()
                    data["parkArea"] = parseInt($('#parkArea').val())
                    data["parkPrice"] = parseInt($('#parkPrice').val())
                    data["parkStatus"] = $('select#parkStatus').children("option:selected").val()

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
                            window.location.href = "${NewURL}?type=list&page=1&maxPageItem=2&sortName=parkId&sortBy=desc"
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
                            window.location.href = "${NewURL}?type=list&page=1&maxPageItem=2&sortName=parkId&sortBy=desc"
                        },
                        error: function(error) {
                            window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";
                        }
                    });
                }

                function resetInput() {
                    $('#parkName').val(null)
                    $('select#parkPlace').children("option:selected").val(null)
                    $('#parkArea').val(null)
                    $('#parkPrice').val(null)
                    $('select#parkStatus').children("option:selected").val(null)
                }

                function goBack() {
                    window.history.back();
                }
            </script>
        </body>

        </html>