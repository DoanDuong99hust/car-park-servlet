<%@include file="/common/taglib.jsp"%>
    <c:url var="APIurl" value="/car-park/api/ticket-list" />
    <c:url var="NewURL" value="/car-park-ticket-list" />
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Ticket list</title>
        </head>

        <body>
            <div class="col-sm-9">
                <h2 class="pt-3">Ticket list</h2>
                <hr class="border">
                <div class="d-flex justify-content-between">
                    <div class="search-filter d-flex">
                        <div class="filter m-1 border rounded bg-light">
                            <label class="m-0 pl-1"><i class="fas fa-filter"></i> Filter By</label>
                            <select class="h-100 p-1 border-left border-bottom-0 border-right-0 border-top-0" name="deparment" id="deparment">
                                <option value="employee">Name</option>
                                <option value="manager">Phone</option>
                            </select>
                        </div>
                        <div class="search m-1 border rounded bg-light">
                            <form class="" action="/action_page.php">
                                <label class="m-0 pl-1" for="gsearch"><i class="fas fa-search"></i></label>
                                <input class="h-100 p-1 border-left border-bottom-0 border-right-0 border-top-0" type="search" id="gsearch" name="gsearch" placeholder="User search">
                            </form>
                        </div>
                        <div class="btn btn-primary pt-0 pb-0  m-1">Search</div>
                        <div id="btnDelete" class="btn btn-danger m-1" data-toggle="tooltip" title="Xoá bài viết">
                            <i class="fas fa-trash-alt"></i> Delete
                        </div>
                    </div>
                </div>

                <form action="<c:url value='/car-park-ticket-list'/>" id="formSubmit" method="get">
                    <div class="main-content-inner">
                        <div class="page-content">
                            <!-- Add profile  -->
                            <c:if test="${not empty messageResponse}">
                                <div class="alert alert-${alert}">
                                    ${messageResponse}
                                </div>
                            </c:if>
                            <div class="table-responsive">
                                <table class="table table-bordered">
                                    <thead>
                                        <tr>
                                            <th><input type="checkbox" id="checkAll"></th>
                                            <th>No</th>
                                            <th>Trip</th>
                                            <th>License plate</th>
                                            <th>Customer</th>
                                            <th>Booking time</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="item" items="${model.listResult}">
                                            <tr>
                                                <td><input type="checkbox" id="checkbox_${item.ticketId}" value="${item.ticketId}"></td>
                                                <td>${item.ticketId}</td>
                                                <td>${item.tripId}</td>
                                                <td>${item.licensePlate}</td>
                                                <td>${item.customerName}</td>
                                                <td>${item.bookingTime}</td>
                                                <td>
                                                    <c:url var="editURL" value="/car-park-ticket-list">
                                                        <c:param name="type" value="edit" />
                                                        <c:param name="ticketId" value="${item.ticketId}" />
                                                    </c:url>
                                                    <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip" title="Cập nhật bài viết" href='${editURL}'>
                                                        <i class="far fa-edit"></i> Edit
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                <ul class="pagination" id="pagination"></ul>
                                <input type="hidden" value="" id="page" name="page" />
                                <input type="hidden" value="" id="maxPageItem" name="maxPageItem" />
                                <input type="hidden" value="" id="sortName" name="sortName" />
                                <input type="hidden" value="" id="sortBy" name="sortBy" />
                                <input type="hidden" value="" id="type" name="type" />
                            </div>
                        </div>
                    </div>
                </form>
            </div>

            <!-- /.main-content -->
            <script type="text/javascript">
                var totalPages = ${
                    model.totalPage
                };
                var currentPage = ${
                    model.page
                };
                var limit = 2;
                $(function() {
                    $('#pagination').twbsPagination({
                        totalPages: totalPages,
                        visiblePages: 10,
                        startPage: currentPage,
                        onPageClick: function(event, page) {
                            if (currentPage != page) {
                                $('#maxPageItem').val(limit);
                                $('#page').val(page);
                                $('#sortName').val('ticketId');
                                $('#sortBy').val('desc');
                                $('#type').val('list');
                                $('#formSubmit').submit();
                            }
                        }
                    });
                });

                $("#btnDelete").click(function() {
                    var data = {};
                    var ids = $('tbody input[type=checkbox]:checked').map(function () {
                        return $(this).val();
                    }).get();
                    data['ids'] = ids;
                    deleteNew(data);
                });

                function deleteNew(data) {
                    $.ajax({
                        url: '${APIurl}',
                        type: 'DELETE',
                        contentType: 'application/json',
                        data: JSON.stringify(data),
                        success: function (result) {
                            window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=delete_success";
                        },
                        error: function (error) {
                            window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";
                        }
                    });
                }
            </script>
        </body>

        </html>