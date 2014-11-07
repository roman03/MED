
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
				<label class="col-md-4 control-label" for="diagnosisId">DiagnosisId
					at arrived</label>
				<div class="col-md-4">
					<textarea class="form-control" id="diagnosisId" name="diagnosisId"
						style="width: 250px;"></textarea>

				</div>
			</div>

		</div>
	</div>
	<hr class="divider">
	<div id="appointmentId">
		<!-- appointment -->
	</div>
	<hr class="divider">
	<div>
		<!-- Button -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="addDoctorId"></label>
			<div class="col-md-4">
				<input type="button" class="btn btn-primary" id="addDoctorId"
					name="submit" value="addDoctor" onclick="submit_form();" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-md-4 control-label" for="showCalendarId"></label>
			<div class="col-md-4">
				<input type="button" class="btn btn-primary" id="showCalendarId"
					name="submit" value="showCalendar" onclick="show_calendar();" />
			</div>
		</div>
	</div>
</div>