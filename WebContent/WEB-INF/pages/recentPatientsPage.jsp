<%@page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../components/includes.jsp"%>

<script src="resources/bootstrap.js"></script>
<script src="resources/bootstrap.min.js"></script>

</head>
<body>

	<div id="header" style="width: screen.width;">
		<%@ include file="../components/header.jsp"%>
	</div>
	<div class="table-responsive " id="table" style="width:90%;">
		<table id="events-table"
			class="table-bordered table bs-example table-hover"
			data-row-style="rowStyle"  style="margin-left: 5%">
			<thead>
				<tr>
					<td id="Id"><strong>Id</strong></td>
					<td><strong>Name</strong></td>
					<td><strong>First Name</strong></td>
					<td><strong>Last Name</strong></td>
					<td><strong>Age</strong></td>
					<td><strong>Timestamp</strong></td>
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
						<td>${patient.dateArrived}</td>
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
						fillPatientForm(obj.patient, obj.hospital, Id);
						var value = fillProgressBar();
						setProgressText(value);
						createTreatment(obj.doctors);
					} else {
						alert("Patient not exist");
					}
					//$("#container").html(response);
				};
				$.ajax(ob);
			});
		});

		

		function submit_form() {
			var ob = {};
			ob.url = "/HelloWeb/DoctorList";
			ob.type = "GET";
			var hospitalID = hospitalId.value;
			if(hospitalID === "undefined") {
				hospitalID = null;
			}
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
			window.open('/HelloWeb/GetCalendar', 'Calendar',
					'width=750,height=550');
		}


	</script>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="resources/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>
</html>