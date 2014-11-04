<%@page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="includes.jsp"%>

<script src="resources/bootstrap.js"></script>
<script src="resources/bootstrap.min.js"></script>


<style type="text/css">
.bs-example {
	margin: 60px;
}
</style>

</head>
<body>

	<div id="header" style="width: screen.width;">
		<%@ include file="header.jsp"%>
	</div>
	<div class="table-responsive" style="width: 1200px;" id="table">
		<table id="events-table" class="table bs-example table-hover"
			data-row-style="rowStyle">
			<thead>
				<tr>
					<td id="Id">Id</td>
					<td>Name</td>
					<td>First Name</td>
					<td>Last Name</td>
					<td>Age</td>
					<td>Diagnosis</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${object}" var="patient">
					<tr id="${patient.id}">
						<td>${patient.id}</td>
						<td>${patient.name}</td>
						<td>${patient.firstname}</td>
						<td>${patient.lastname}</td>
						<td>${patient.age}</td>
						<td>${patient.diagnosis}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="form-horizontal" id="pat" style="display: none;">
			Hello</div>
		<script>
			$(function() {
				$('.table-hover tr').click(function() {
					$("#table").hide();
					var ob = {}, Id = $(this).attr('id')
					ob.url = "/HelloWeb/showPatient";
					ob.type = "GET";
					ob.data = {
						patientId : Id
					};
					ob.success = function(response) {
						debugger
						if (response.success === "true") {
							alert("good");
						} else {
							alert("not good");
						}
						//$("#container").html(response);
					};
					$.ajax(ob);
				});
			});
		</script>

	</div>

	<div></div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="resources/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>
</html>