
<script src="resources/moment.js"></script>
<script src="resources/bootstrap.js"></script>
<script src="resources/bootstrap.min.js"></script>
<script src="resources/bootstrap-datetimepicker.min.js"></script>

<link rel="stylesheet" href="resources/bootstrap-datetimepicker.min.css" />

<div style="display: none; margin-top: 10px;" id="remediesId">
	<form class="form-horizontal" role="form">
		<fieldset>
			<legend>Remedies</legend>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="titleRemediesId">Title</label>
				<div class="col-md-8">
					<textarea id="titleRemediesId" style="width: 80%;" name="textarea"></textarea>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="dosageId">Dosage</label>
				<div class="col-md-8">
					<textarea id="dosageId" style="width: 80%;" name="textarea"></textarea>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="remediesTimeId">Time
				</label>
				<div class='input-group date ' style="width: 60%;">
					<input type='text' class="form-control" style="margin-left: 15px;"
						id="remediesTimeId"></input> <span class="input-group-addon "><span
						class="glyphicon glyphicon-calendar " style="margin-left: 15px;"></span>
					</span>
				</div>
			</div>
			<script>
				$(function() {
					var date = new Date();
					$('#remediesTimeId').datetimepicker(
							{
								defaultDate : date.getMonth() + "/"
										+ date.getDay() + "/"
										+ date.getFullYear()
							});
				});
			</script>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="button" type="submit" id="sendBtn2"
						class="btn btn-primary">Submit</button>
				</div>
			</div>

		</fieldset>
	</form>

</div>
<script>
	$(function() {
		$('#sendBtn2').click(
				function(e) {
					e.preventDefault();

					var ob = {};
					ob.url = "/HelloWeb/sendRemedies";
					ob.type = "POST";
					docId = document.getElementById("myModal").getAttribute(
							"data-doctorId");
					patId = document.getElementById("myModal").getAttribute(
							"data-patientId");
					ob.data = {
						title : titleRemediesId.value,
						dosage : dosageId.value,
						time : remediesTimeId.value,
						patientId : patId,
						doctorId : docId
					};
					ob.success = function(response) {
						$('#myModal').modal('toggle');
					};

					$.ajax(ob);
				});
	});
</script>