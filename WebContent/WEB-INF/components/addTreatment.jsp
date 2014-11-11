



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

				<%@ include file="analyzes.jsp"%>

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