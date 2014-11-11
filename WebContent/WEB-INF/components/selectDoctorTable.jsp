<%@ include file="addTreatment.jsp"%>
<div class="container table-responsive hiden " id="doctors-table">
	<table id="table1" class="table-bordered table bs-example table-hover "
		data-row-style="rowStyle">
		<thead>
			<tr>
				<td><strong>Id</strong></td>
				<td><strong>Name</strong></td>
				<td><strong>Last Name</strong></td>
				<td><strong>Post</strong></td>
				<td><strong>Calendar</strong></td>
				<td><strong>Select</strong></td>
			</tr>
		</thead>
		<tbody id="tableBody">
		</tbody>
	</table>

	<div class="row">
		<div class="col-md-6">
			<button type="button" class="btn btn-success " style="width: 100%"
				onclick="Done();">Done</button>
		</div>
		<div class="col-md-6">
			<button type="button" class="btn btn-info " style="width: 100%"
				onclick="clearDoctorTable();">Cancel</button>
		</div>
	</div>
</div>

<script>
	function createDoctorsTable(doctorList) {
		var tbody = document.getElementById("tableBody"), tr, td, i;

		for (y = 0; y < doctorList.length; ++y) {
			tr = document.createElement("tr");
			td = document.createElement("td");
			td.innerHTML = doctorList[y].id;
			tr.appendChild(td);

			td = document.createElement("td");
			td.innerHTML = doctorList[y].name;
			tr.appendChild(td);

			td = document.createElement("td");
			td.innerHTML = doctorList[y].lastName;
			tr.appendChild(td);

			td = document.createElement("td");
			td.innerHTML = doctorList[y].post;
			tr.appendChild(td);

			var a = document.createElement('a');
			var linkText = document.createTextNode("Calendar");
			a.appendChild(linkText);
			a.href = "/HelloWeb/GetCalendar/" + doctorList[y].calendarId;

			td = document.createElement("td");
			td.appendChild(a);
			tr.appendChild(td);
			td = document.createElement("td");

			var newCheckBox = document.createElement('input');
			newCheckBox.type = 'checkbox';
			newCheckBox.id = 'checkbox' + y;
			td.appendChild(newCheckBox);
			tr.appendChild(td);

			tbody.appendChild(tr);
		}

	}

	function clearDoctorTable() {
		document.getElementById("doctors-table").style.visibility = "hidden";
		table = document.getElementById("table1");
		while (table.tBodies.tableBody.rows.length > 0) {
			table.deleteRow(1);
		}
	}

	function Done() {
		var selectedDoctors = [];
		table = document.getElementById("table1");
		for (i = 0, y = 0; i < table.tBodies.tableBody.rows.length; i++) {
			if (document.getElementById("checkbox" + i).checked === true) {
				selectedDoctors[y] = getDoctorId(table.tBodies.tableBody.children[i]);
				y++;
			}
		}
		var ob = {};
		ob.url = "/HelloWeb/addDoctor"
		ob.type = "POST";
		ob.data = {
			doctors : selectedDoctors,
			patient : patientId.value
		};
		ob.success = function(response) {
			var obj = jQuery.parseJSON(response)
			if (obj.sucess === true) {
				var list = getSelectedDoctors();
				clearDoctorTable();
				createTreatment(list);
			} else {
				alert("Can`t add doctor to patient");
			}
			//$("#container").html(response);
		};
		$.ajax(ob);

	}

	function getDoctorId(row) {
		return row.children[0].innerText
	}

	function createTreatment(list) {
		if(list.length === 0) {
			return
		}
		var tbody = document.getElementById("appointmentId");
		for (i = 0; i < list.length; i++) {
			var dl = document.createElement("dl");
			dl.className="dl-horizontal";
			var dt = document.createElement("dt");
			var dd = document.createElement("dd");

			dt.innerHTML = "Doctor initials:";
			dd.innerHTML = list[i].name + " " + list[i].lastName;
			dl.appendChild(dt);
			dl.appendChild(dd);

			var dt = document.createElement("dt");
			var dd = document.createElement("dd");

			dt.innerHTML = "Post";
			dd.innerHTML = list[i].post;
			dl.appendChild(dt);
			dl.appendChild(dd);

			var dt = document.createElement("dt");
			var dd = document.createElement("dd");

			dt.innerHTML = "Calendar";
			if (list[i].calendarId.toString().indexOf('a') === -1) {
				$('<a href= /HelloWeb/GetCalendar/' + list[i].calendarId +'>'+ "Calendar" +'</a>').appendTo($(dd));
			} else {
				dd.innerHTML = list[i].calendarId;
			}
			dl.appendChild(dt);
			dl.appendChild(dd);

			var dt = document.createElement("dt");
			var dd = document.createElement("dd");
			dt.innerHTML = "Treatment";
			dl.appendChild(dt);

			var div = document.createElement("div");
			div.className="row";
			$(div).css("margin-left", "auto");

			var element = document.createElement("input");
			element.type = "button";
			element.value = "Add";
			element.setAttribute("data-doctorId", list[i].id);
			element.setAttribute("data-patientId", patientId.value);
			element.onclick = addTreatment;
			element.className = "btn btn-primary";

			div.appendChild(element);

			var element = document.createElement("input");
			element.type = "button";
			element.value = "View";
			element.setAttribute("data-doctorId", list[i].id);
			element.setAttribute("data-patientId", patientId.value);
			element.onclick = viewTreatment;
			element.className = "btn btn-success";
			$(element).css("margin-left", "5px");
			div.appendChild(element);

			dd.appendChild(div);
			dl.appendChild(dd);
			tbody.appendChild(dl);
		}
	}

	function getSelectedDoctors() {
		var doctorList = [];
		table = document.getElementById("table1");
		for (i = 1; i <= table.tBodies.tableBody.rows.length; i++) {
			if (table.rows[i].cells[5].firstChild.checked === true) {
				var singleObj = {}
				singleObj['name'] = table.rows[i].cells[1].innerHTML;
				singleObj['lastName'] = table.rows[i].cells[2].innerHTML;
				singleObj['post'] = table.rows[i].cells[3].innerHTML;
				singleObj['calendarId'] = table.rows[i].cells[4].innerHTML;
				doctorList.push(singleObj);
			}
		}
		return doctorList;
	}

	function viewTreatment() {
		//alert(this.getAttribute("data-doctorId"));
	}

	function addTreatment() {
		$("#myModal").modal("show");
		document.getElementById("myModal").setAttribute("data-doctorId", this.getAttribute("data-doctorId"));
		document.getElementById("myModal").setAttribute("data-patientId", this.getAttribute("data-patientId"));
	}
</script>