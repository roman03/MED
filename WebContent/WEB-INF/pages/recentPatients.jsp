<%@page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
	</div>
	<%@ include file="patientForm.jsp"%>
	<script>
		$(function() {
			$('.table-hover tr').click(function() {
				$("#table").hide();
				document.getElementById("form").style.visibility = "visible";
				var ob = {}, Id = $(this).attr('id')
				ob.url = "/HelloWeb/showPatient";
				ob.type = "GET";
				ob.data = {
					patientId : Id
				};
				ob.success = function(response) {
					var obj = jQuery.parseJSON(response)
					if (obj.success === "true") {
						fillPatientForm(obj.patient);
					} else {
						alert("Patient not exist");
					}
					//$("#container").html(response);
				};
				$.ajax(ob);
			});
		});

		function fillPatientForm(patientJSON) {
			var patient = jQuery.parseJSON(patientJSON);
			nameId.value = patient.name;
			firstNameId.value = patient.firstName;
			lastNameId.value = patient.lastName;
			ageId.value = patient.age;
			sexId.value = patient.sex;
			adressId.value = patient.address;
			aboutId.value = patient.workplace;
			diagnosisId.value = patient.diagnosis;
		}
	</script>

	<script>
		function submit_form() {
			var ob = {};
			ob.url = "/HelloWeb/DoctorList";
			ob.type = "GET";
			ob.success = function(response) {
				if (response.success === "true") {
					alert("good");
				} else {
					alert("Doctor`s list is empty");
				}
			};

			$.ajax(ob);
		}
	</script>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="resources/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>
</html>