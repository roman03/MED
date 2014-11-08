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

</head>
<body>

	<div id="header" style="width: screen.width;">
		<%@ include file="header.jsp"%>
	</div>
	<div class="table-responsive " id="table">
		<table id="events-table"
			class="table-bordered table bs-example table-hover"
			data-row-style="rowStyle">
			<thead>
				<tr>
					<td id="Id"><strong>Id</strong></td>
					<td><strong>Name</strong></td>
					<td><strong>First Name</strong></td>
					<td><strong>Last Name</strong></td>
					<td><strong>Age</strong></td>
					<td><strong>Diagnosis</strong></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${object}" var="patient">
					<tr id="${patient.id}" class="clickableRow">
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
	<div class="table-responsive" style="width: 1200px;" id="tableDiv">
	</div>



	<%@ include file="../components/patientInfo.jsp"%>
	<%@ include file="../components/selectDoctorTable.jsp"%>


	<script>
		jQuery(document).ready(function($) {
			$(".clickableRow").click(function() {
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
			$('#did').text(patient.diagnosis);
			hospitalId.value = patient.hospitalName;
		}

		function submit_form() {
			var ob = {};
			ob.url = "/HelloWeb/DoctorList";
			ob.type = "GET";
			var hospitalID = hospitalId.value;
			ob.data = {
				hospital : hospitalID
			};
			ob.success = function(response) {
				var resp = jQuery.parseJSON(response);
				if (resp.sucess === "true") {
					clearDoctorTable();
					document.getElementById("doctors-table").style.visibility = "visible";
					createDoctorsTable(resp.doctors)
				} else {
					alert("Doctor`s list is empty");
				}
			};

			$.ajax(ob);
		}

		function show_calendar() {
			//window.location = "/HelloWeb/GetCalendar";
			window.open('/HelloWeb/GetCalendar', 'Calendar',
					'width=750,height=550');
			//var ob = {};
			//ob.url = "/HelloWeb/GetCalendar";
			//ob.type = "GET";
			//ob.success = function(response) {
			//var resp = jQuery.parseJSON(response);
			//if (resp.sucess === "true") {
			//document.getElementById("form").style.visibility = "hidden";
			//	alert("ok");
			//} else {
			//	alert("Doctor`s list is empty");
			//}
			//};

			//$.ajax(ob);
		}


	</script>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="resources/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>
</html>