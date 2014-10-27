<jsp:include page="addNewPatient.jsp" />
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>MED System</title>

<!-- Bootstrap core CSS -->
<link href="resources/bootstrap.min.css" rel="stylesheet">
<link href="resources/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="resources/navbar.css" rel="stylesheet">
<link href="resources/bootstrap-datetimepicker.min.css" rel="stylesheet">
<link href="resources/font-awesome/4.0.1/css/font-awesome.css"
	rel="stylesheet">


<script src="resources/jquery-2.1.1.min.js"></script>
<script src="resources/bootstrap.js"></script>
<script src="resources/bootstrap.min.js"></script>
<script src="resources/moment.js"></script>
<script src="resources/bootstrap-datetimepicker.min.js"></script>

</head>

<body>

	<div class="container">
		<!-- Static navbar -->
		<div class="navbar navbar-default navbar-fixed-top" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="">MED System</a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="" id="newPatient">Add new patient</a></li>
						<li><a href="">Show recent patient</a></li>
						<li><a href="">Search stuff</a></li>

						<form class="navbar-form navbar-left" type='search'
							action="Search" method='GET'>
							<div class="form-group">
								<input type="text" class="form-control"
									placeholder="Search Patient">
							</div>
							<button type="submit" class="btn btn-default">Search</button>
						</form>

						<form class="navbar-form navbar-right" id="logoutForm"
							action="j_spring_security_logout" method='POST'>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>

						<li><a href="javascript:formSubmit()">Logout</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</div>
	</div>
	<!-- /container -->

	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}

		$("#ss").click(function() {
			$("#form1").css("display", "block");
		});
	</script>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<script src="resources/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>
</html>