<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="includes.jsp"%>

<script src="resources/moment.js"></script>
<script src="resources/bootstrap.js"></script>
<script src="resources/bootstrap.min.js"></script>
<script src="resources/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" href="resources/bootstrap-datetimepicker.min.css" />


</head>
<body>

	<div id="header" style="width: screen.width;">
		<%@ include file="header.jsp"%>
	</div>

	<form:form class="form-horizontal" method="POST" commandName="patient">
		<fieldset>

			<!-- Form Name -->
			<legend>Add new Patient</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="NameID">Name</label>
				<div class="col-md-6">
					<form:input id="nameId" path="name" name="NameID" type="text"
						placeholder="Name" class="form-control input-md"></form:input>
						<form:errors class="alert alert-error" role="alert" path="name"/>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="firstNameId">First
					Name</label>
				<div class="col-md-6">
					<form:input id="firstNameId" path="firstname" name="firstNameId"
						type="text" placeholder="First Name" class="form-control input-md"></form:input>
					<form:errors class="alert alert-error" role="alert" path="firstname"/>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="lastNameID">Last
					Name</label>
				<div class="col-md-6">
					<form:input id="lastNameId" path="lastname" name="lastNameID"
						type="text" placeholder="Last Name" class="form-control input-md"></form:input>
						<form:errors class="alert alert-error" role="alert" path="lastname"/>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="ageId">Age</label>
				<div class="col-md-2">
					<form:input id="ageId" path="age" name="ageId" type="text"
						placeholder="Age" class="form-control input-md"></form:input>
				</div>
			</div>

			<!-- Multiple Radios (inline) -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="sexId">Sex</label>
				<div class="col-md-4">
					<form:radiobutton path="sex" class="radio-inline" value="Male"
						checked="checked" />
					Male
					<form:radiobutton path="sex" class="radio-inline" value="Female" />
					Female
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="adressId">Address</label>
				<div class="col-md-6">
					<form:input id="adressId" path="address" name="adressId"
						type="text" placeholder="Address" class="form-control input-md"></form:input>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="aboutId">Work
					Place/position</label>
				<div class="col-md-6">
					<form:input id="aboutId" path="workplace" name="aboutId"
						type="text" placeholder="Work Place/position"
						class="form-control input-md"></form:input>
				</div>
			</div>

			<!-- Textarea -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="diagnosisId">DiagnosisId
					at arrived</label>
				<div class="col-md-4">
					<form:textarea class="form-control" path="diagnosis"
						id="diagnosisId" name="diagnosisId"></form:textarea>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="datetimepicker7">Date/Time
					arrived</label>
				<div class='input-group date '
					style="width: 450px; padding-left: 10px;" id='dateArriveId'>
					<form:input type='text' path="dateArrived" class="form-control"
						id="dateArrivedId"></form:input>
					<span class="input-group-addon "><span
						class="glyphicon glyphicon-calendar "></span> </span>
				</div>
			</div>
			<script>
				$(function() {
					$('#dateArriveId').datetimepicker(
							{
								defaultDate : "11/1/2013",
								disabledDates : [ ("12/25/2013"),
										new Date(2013, 11 - 1, 21),
										"11/22/2013 00:53" ]
							});
				});
			</script>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="submitId"></label>
				<div class="col-md-4">
					<button id="submitId" name="submitId" class="btn btn-primary">Submit</button>
				</div>
			</div>

		</fieldset>
	</form:form>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="resources/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>
</html>
