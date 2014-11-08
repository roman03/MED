	<div class="container table-responsive hiden " id="doctors-table">
		<table id="table1"
			class="table-bordered table bs-example table-hover "
			data-row-style="rowStyle">
			<thead>
				<tr>
					<td id="Id"><strong>Id</strong></td>
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
				<button type="button" class="btn btn-success " style="width:100%" onclick="done;">Done</button>
			</div>
			<div class="col-md-6">
				<button type="button" class="btn btn-info " style="width:100%" onclick="clearDoctorTable();">Cancel</button>
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
			newCheckBox.id = 'ptworkinfo' + y;
			td.appendChild(newCheckBox);
			tr.appendChild(td);

			tbody.appendChild(tr);
		}

	}
	
	function clearDoctorTable() {
		document.getElementById("doctors-table").style.visibility = "hidden";
		table = document.getElementById("table1");
		while(table.tBodies.tableBody.rows.length > 0) {
			  table.deleteRow(1);
			}
	}
	
	</script>