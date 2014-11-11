
<script src="resources/moment.js"></script>
<script src="resources/bootstrap.js"></script>
<script src="resources/bootstrap.min.js"></script>
<script src="resources/bootstrap-datetimepicker.min.js"></script>

<link rel="stylesheet" href="resources/bootstrap-datetimepicker.min.css" />

<div style="display: none; margin-top: 10px;" id="procesuresId">
	<form class="form-horizontal" role="form" >
		<fieldset>
			<legend>Procedures</legend>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="titleProcedurId">Title</label>
				<div class="col-md-8">
					<textarea id="titleProcedurId" style="width: 80%;" name="textarea"></textarea>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-sm-2 control-label" for="placeProcedureId">Room</label>
				<div class="col-md-8">
					<input id="placeProcedureId" name="textinput" type="text" placeholder="Room"
						class="input-xlarge"></input>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="procedureTimeId">Time
				</label>
				<div class='input-group date ' style="width: 60%;">
					<input type='text' class="form-control" style="margin-left: 15px;"
						id="procedureTimeId"></input> <span class="input-group-addon "><span
						class="glyphicon glyphicon-calendar " style="margin-left: 15px;"></span>
					</span>
				</div>
			</div>
			<script>
				$(function() {
					var date = new Date();
					$('#procedureTimeId').datetimepicker(
							{
								defaultDate : date.getMonth() + "/"
										+ date.getDay() + "/"
										+ date.getFullYear()
							});
				});
			</script>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="button" type="submit" id="sendBtn"
						class="btn btn-primary">Submit</button>
				</div>
			</div>

		</fieldset>
	</form>

</div>