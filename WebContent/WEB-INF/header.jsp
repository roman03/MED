<div class="container">
	<!-- Static navbar -->
	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="">MED System</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="addNewPatient">Add new patient</a></li>
					<li><a href="">Show recent patient</a></li>
					<li><a href="" id="searchStuff">Search stuff</a></li>

					<form class="navbar-form navbar-left" action="Search" method='GET'>
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
</script>
