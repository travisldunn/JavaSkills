window.onload = function() {
	funct();
}

function funct(data) {
	document.fatForm.submit.addEventListener("click", clicked);
}

var clicked = function(event) {
	event.preventDefault();
	createData();
	getData(display);
	clearForm(document.fatForm);
}

function getData() {
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "http://localhost:8080/EventTracker/rest/fat1");
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status < 400) {
			display(JSON.parse(xhr.responseText));
		}
	}
	xhr.send(null);
}

function createData() {
	var xhr = new XMLHttpRequest();
	var obj = {
		Current_Weight : document.getElementById("cFat").value,
		Goal_Weight : document.getElementById("gFat").value,
		Diet : document.getElementById("Diet").value,
	}
	xhr.open("PUT", "http://localhost:8080/EventTracker/rest/fat1");
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.onreadystatechange = function() {
	}
	xhr.send(JSON.stringify(obj));
}

function display(info) {
	var body = document.querySelector("body");
	var table = document.getElementById("table");
	table.innerHTML = "";
	var orderNumber = 1;
	var left = 0;
	for (var i = 0; i < info.length; i++) {
		var tr = document.createElement("tr");
		total = total + info[i].Goal_Weight;
		for ( var propt in info[i]) {
			var td = document.createElement("td");
			var id = info[i].id;
			if (propt != "total") {
				if (propt == "id") {
					td.innerHTML = orderNumber;
					tr.appendChild(td);
					orderNumber = orderNumber + 1;
				} else {
					td.innerHTML = propt + ":" + info[i][propt];
					tr.appendChild(td);
				}
			} else {
				td.innerHTML = total;
				tr.appendChild(td);
			}
		}
		var td = document.createElement("td");
		var deleter = document.createElement("input");
		deleter.setAttribute("type", "submit");
		deleter.setAttribute("value", "delete");
		deleter.setAttribute("id", id);
		deleter.addEventListener("click", function(e) {
			var xhr = new XMLHttpRequest();
			xhr.open("DELETE", "http://localhost:8080/EventController/rest/fat1");
			xhr.setRequestHeader("Content-Type", "application/json");

			xhr.onreadystatechange = function() {

			}
			xhr.send(e.target.getAttribute("id"));
			getData();
		})

		td.appendChild(deleter);
		tr.appendChild(td);
		table.appendChild(tr);
	}
}

var clearForm = function(form) {
	form.parentNode.removeChild(form);
};