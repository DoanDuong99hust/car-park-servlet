// function addData() {
//     // e.preventDefault();
//     var data = {};
//     // var formData = $('#formSubmit').serializeArray();
//     // $.each(formData, function (index, value) {
//     //     data[""+value.name+""] = value.value;
//     // })
//     data["employeeName"] = $('#employeeName').val()
//     data["employeePhone"] = $('#employeePhone').val()
//     data["employeeBirthday"] = $('#employeeBirthday').val()
//     data["sex"] = $("input[name='sex']:checked").val()
//     data["employeeAddress"] = $('#employeeAddress').val()
//     data["employeeEmail"] = $('#employeeEmail').val()
//     data["account"] = $('#account').val()
//     data["password"] = $('#password').val()
//     data["department"] = $('select#department').children("option:selected").val()
//     addNew(data)
// }
// function addNew(data) {
//     $.ajax({
//         url: '${APIurl}',
//         type: 'POST',
//         contentType: 'application/json',
//         data: JSON.stringify(data),
//         dataType: 'json',
//         success: function (result) {
//             // <%--window.location.href = "${NewURL}?type=edit&id="+result.id+"&message=insert_success";--%>
//         window.location.href = "${NewURL}?type=list"
//       },
//       error: function (error) {
//         window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";
//       }
//     });
//   }
//   function updateNew(data) {
//     $.ajax({
//       url: '${APIurl}',
//       type: 'PUT',
//       contentType: 'application/json',
//       data: JSON.stringify(data),
//       dataType: 'json',
//       success: function (result) {
//         window.location.href = "${NewURL}?type=edit&id="+result.id+"&message=update_success";
//       },
//       error: function (error) {
//         window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";
//       }
//     });
//   }
//   function resetInput() {
//     $('#employeeName').val(null)
//     $('#employeePhone').val(null)
//     $('#employeeBirthday').val(null)
//     $("input[name='sex']:checked").val(null)
//     $('#employeeAddress').val(null)
//     $('#employeeEmail').val(null)
//     $('#account').val(null)
//     $('#password').val(null)
//     $('select#department').children("option:selected").val(null)
//   }
//   function goBack() {
//     window.history.back();
//   }