
<script src="resources/moment.js"></script>
<script src="resources/bootstrap.js"></script>
<script src="resources/bootstrap.min.js"></script>
<script src="resources/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" href="resources/bootstrap-datetimepicker.min.css" />

<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- Modal Header -->
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Treatment</h4>
			</div>

			<!-- Modal Body -->
			<div class="modal-body">
				<div class="row" align="center">
					<button type="button" class="btn btn-primary"
						onclick="addAnalyzes();">Add Analyzes</button>
					<button type="button" class="btn btn-primary"
						onclick="addProcedyres();">Add Procedyres</button>
					<button type="button" class="btn btn-primary"
						onclick="addRemedies();">Add Remedies</button>
				</div>

				<div style="display: none; margin-top: 10px;" id="analyzesId">
					<form class="form-horizontal" role="form">
						<fieldset>
							<legend>Analizes</legend>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="textarea">Title</label>
								<div class="col-md-8">
									<textarea id="textarea" style="width: 80%;" path="title" name="textarea"></textarea>
								</div>
							</div>

							<!-- Text input-->
							<div class="form-group">
								<label class="col-sm-2 control-label" for="textinput">Room</label>
								<div class="col-md-8">
									<input id="textinput"  name="textinput" type="text"
										placeholder="Room" class="input-xlarge"></input>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label" for="analyzesTimeId">Time
								</label>
								<div class='input-group date ' id='dateArriveId'  style="width: 60%;">
									<input type='text' class="form-control" style="margin-left:15px;"
										id="analyzesTimeId"></input> <span class="input-group-addon "><span
										class="glyphicon glyphicon-calendar " style="margin-left:15px;"></span> </span>
								</div>
							</div>
							<script>
								$(function() {
									var date = new Date();
									$('#analyzesTimeId').datetimepicker(
											{
												
												defaultDate : date.getMonth() + "/" + date.getDay() + "/" + date.getFullYear()
											});
								});
							</script>

							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn btn-primary" data-dismiss="modal" onclick="sendAnalyzes()">Submit</button>
								</div>
							</div>

						</fieldset>
					</form>

				</div>

			</div>

			<!-- Modal Footer -->
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">
					Close</button>
			</div>
		</div>
	</div>
</div>
<script>
	function addAnalyzes() {
		$("#analyzesId").show();
	}
	
	function sendAnalyzes() {
		alert("send");
	}
	
</script>