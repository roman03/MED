
<div class="container hiden bs-example" id="form"
	style="width: screen.width;">
	<div class="row">
		<div class="col-xs-6 botton_margin">
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="NameID">Name</label>
				<div class="col-md-6">
					<input id="nameId" name="NameID" type="text"
						class="form-control input-md" readonly></input>
				</div>
			</div>
		</div>
		<div class="col-xs-6 botton_margin">
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="firstNameId">First
					Name</label>
				<div class="col-md-6">
					<input id="firstNameId" name="firstNameId" type="text"
						class="form-control input-md" readonly></input>
				</div>
			</div>
		</div>
		<div class="col-xs-6 botton_margin">
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="lastNameID">Last
					Name</label>
				<div class="col-md-6">
					<input id="lastNameId" name="lastNameID" type="text"
						class="form-control input-md" readonly></input>
				</div>
			</div>
		</div>

		<div class="col-xs-6 botton_margin">
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="ageId">Age</label>
				<div class="col-md-2">
					<input id="ageId" name="ageId" type="text"
						class="form-control input-md" readonly></input>
				</div>
			</div>
		</div>

		<div class="col-xs-6 botton_margin">
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="sexId">Sex</label>
				<div class="col-md-2">
					<input id="sexId" name="ageId" type="text"
						class="form-control input-md" readonly></input>
				</div>
			</div>

		</div>

		<div class="col-xs-6 botton_margin">
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="adressId">Address</label>
				<div class="col-md-6">
					<input id="adressId" name="adressId" type="text"
						class="form-control input-md" readonly></input>
				</div>
			</div>

		</div>
		<div class="col-xs-6 botton_margin">
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="aboutId">Work
					Place/position</label>
				<div class="col-md-6">
					<input id="aboutId" name="aboutId" type="text"
						class="form-control input-md" readonly></input>
				</div>
			</div>

		</div>

		<div class="col-xs-6 botton_margin">
			<!-- Textarea -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="hospitalId">Hospital
				</label>
				<div class="col-md-6">
					<input id="hospitalId" name="hospitalId" type="text"
						class="form-control input-md" readonly></input>
				</div>
			</div>

		</div>
	</div>
	<hr class="divider">
	<dl>
		<dt>DiagnosisId at arrived</dt>
		<dd id="did"></dd>
	</dl>
	<div id="appointmentId">
		<!-- appointment -->
	</div>
	<hr class="divider">
	<hr class="divider">
	
			<div class="row">
			<div class="col-md-6">
				<button type="button" class="btn btn-primary " style="width:100%" onclick="submit_form();" >addDoctor</button>
			</div>
			<div class="col-md-6">
				<button type="button" class="btn btn-primary " style="width:100%" onclick="show_calendar();">showCalendar</button>
			</div>
		</div>
</div>