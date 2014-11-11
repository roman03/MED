
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
						onclick="addProcedyres();">Add Procedures</button>
					<button type="button" class="btn btn-primary"
						onclick="addRemedies();">Add Remedies</button>
				</div>

				<div style="display: none; margin-top: 10px;" id="analyzesId">
					<form class="form-horizontal" role="form"  id="h">
						<fieldset>
							<legend>Analyzes</legend>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="titleId">Title</label>
								<div class="col-md-8">
									<textarea id="titleId" style="width: 80%;" name="textarea"></textarea>
								</div>
							</div>

							<!-- Text input-->
							<div class="form-group">
								<label class="col-sm-2 control-label" for="placeId">Room</label>
								<div class="col-md-8">
									<input id="placeId" name="textinput" type="text"
										placeholder="Room" class="input-xlarge"></input>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label" for="analyzesTimeId">Time
								</label>
								<div class='input-group date ' id='dateArriveId'
									style="width: 60%;">
									<input type='text' class="form-control"
										style="margin-left: 15px;" id="analyzesTimeId"></input> <span
										class="input-group-addon "><span
										class="glyphicon glyphicon-calendar "
										style="margin-left: 15px;"></span> </span>
								</div>
							</div>
							<script>
								$(function() {
									var date = new Date();
									$('#analyzesTimeId').datetimepicker(
											{
												defaultDate : date.getMonth()
														+ "/" + date.getDay()
														+ "/"
														+ date.getFullYear()
											});
								});
							</script>

							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="button" type="submit" id="sendBtn"
										class="btn btn-primary" >Submit</button>
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

	$(function() {
		$('#sendBtn').click(function(e) {
			e.preventDefault();

			var ob = {};
			ob.url = "/HelloWeb/sendAnalyzes";
			ob.type = "POST";
			docId = document.getElementById("myModal").getAttribute("data-doctorId");
			patId = document.getElementById("myModal").getAttribute("data-patientId");
			ob.data = {
				title : titleId.value,
				place : placeId.value,
				time : analyzesTimeId.value,
				patientId : patId,
				doctorId : docId
			};
			ob.success = function(response) {
				$('#myModal').modal('toggle');
			};

			$.ajax(ob);
		});
	});
	
	$('#myModal').on('hidden.bs.modal', function () {
		$("#analyzesId").hide();
	})
		
	/*$('#myModal').on('show.bs.modal', function(e) {

	    //get data-id attribute of the clicked element
	    var bookId = $(e.relatedTarget).data('book-id');

	    //populate the textbox
	});*/
</script>