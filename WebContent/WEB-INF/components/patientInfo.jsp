
<div class="container hiden bs-example" id="form"
	style="width: screen.width;">

	<dl>
		<dt>Pation card filed at:</dt>
		<dd>
			<div class="progress">
				<div class="progress-bar" role="progressbar" aria-valuenow="0"
					aria-valuemin="0" aria-valuemax="100" id="progressBarId"><p id="progressValueId"></p></div>
			</div>
		</dd>
	</dl>
	<hr class="divider">

	<div class="row" id="patientInfoId">
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
			<button type="button" class="btn btn-primary " style="width: 100%"
				onclick="submit_form();">addDoctor</button>
		</div>
		<div class="col-md-6">
			<button type="button" class="btn btn-primary " style="width: 100%"
				onclick="show_calendar();">showCalendar</button>
		</div>
	</div>
</div>

<script>
	function fillPatientForm(patientJSON) {
		var patient = jQuery.parseJSON(patientJSON);
		nameId.value = patient.name;
		firstNameId.value = patient.firstName;
		lastNameId.value = patient.lastName;
		ageId.value = patient.age;
		sexId.value = patient.sex;
		adressId.value = patient.address;
		aboutId.value = patient.workplace;
		$('#did').text(patient.diagnosis);
		hospitalId.value = patient.hospitalName;
	}

	function fillProgressBar() {
		var patientInfo = document.getElementById("patientInfoId");
		emptyFields = 0;
		for (i = 0; i < patientInfo.childElementCount; i++) {
			if (patientInfo.children[i].children[0].children[1].children[0].value.length === 0) {
				emptyFields++;
			}
		}

		if (emptyFields === 0) {
			value = 100
		} else {
			value = 100 - (emptyFields / patientInfo.childElementCount) * 100;
		}

		$('.progress-bar').css('width', value + '%').attr('aria-valuenow',
				value);
		
		return value
	}
	function setProgressText(value) {
		$('#progressValueId').text(value + "%");
	}
</script>