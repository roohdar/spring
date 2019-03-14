<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<style type="text/css">
.bgcolor {
	color: gray;
}
</style>
</head>
<body>
	<div class="container-fluid"">
		<nav class="navbar navbar-expand-lg navbar-dark bg-danger bgcolor">

			<div class="collapse navbar-collapse" id="navbarSupportContent">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="#">HOME</a></li>
				</ul>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="#">HOME</a></li>
				</ul>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="#">HOME</a></li>
				</ul>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="#">HOME</a></li>
				</ul>
			</div>
		</nav>
		<div class="row">
			<div class="form-group">
				<div class="col-md-6">
					<h1 align="center">Add Screen</h1>
				</div>
			</div>
		</div>
		<form:form action="/movie/save" modelAttribute="screen"
			enctype="multipart/form-data" class="form-horizontal bgcolor"
			method="POST">
			<div class="form-group">
				<label class="control-label col-sm-2" for="screenName">screenName:</label>
				<div class="col-sm-6">
					<form:input type="text" class="form-control" id="screenName"
						path="screenName" />
				</div>
			</div>


			<div class="form-group" id="platiniumRows">
				<label class="control-label col-sm-2" for="platiniumRow">platiniumRow
					:</label>
				<div class="col-md-1">
					<form:checkbox class="form-control" id="platiniumRow"
						path="platiniumRow" value="platiniumRow" />
				</div>
			</div>
			<div class="form-group" id="platiniumSeats">
				<label class="control-label col-sm-2" for="platiniumSeats">platiniumSeats
					:</label>
				<div class="col-sm-6">
					<form:input type="number" class="form-control amount"
						id="platiniumSeats" path="platiniumSeats" min="2" max="10" />
				</div>
			</div>
			<div class="form-group" id="silverRows">
				<label class="control-label col-sm-2" for="silverRow">silverRow
					:</label>
				<div class="col-sm-1">
					<form:checkbox class="form-control" id="silverRow" path="silverRow"
						value="silverRow" />
				</div>
			</div>
			<div class="form-group" id="silverSeat">
				<label class="control-label col-sm-2" for="silverSeats">silverSeats
					:</label>
				<div class="col-sm-6">
					<form:input type="number" class="form-control amount"
						id="silverSeats" path="silverSeats" min="2" max="10" />
				</div>
			</div>
			<div class="form-group" id="goldRows">
				<label class="control-label col-sm-2" for="goldRow">goldRow
					:</label>
				<div class="col-sm-1">
					<form:checkbox class="form-control" id="goldRow" path="goldRow"
						value="goldRow" />
				</div>
			</div>
			<div class="form-group" id="goldSeats">
				<label class="control-label col-sm-2" for="goldSeats">goldSeats
					:</label>
				<div class="col-sm-6">
					<form:input type="number" class="form-control amount"
						id="goldSeats" path="goldSeats" min="2" max="10" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="screenCapacity">screenCapacity
					:</label>
				<div class="col-sm-6">
					<form:input type="text" class="form-control" id="screenCapacity"
						path="screenCapacity" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-6">
					<button type="submit" class="btn btn-default btn btn-success">Submit</button>
				</div>
			</div>

		</form:form>

	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#platiniumSeats').hide();
			$('#silverSeat').hide();
			$('#goldSeats').hide();
		});

		$('#goldRow').click(function() {
			if ($(this).prop('checked') === true) {
				$('#goldSeats').show();
			} else {
				$('#goldSeats').hide();
				var s = $('#goldSeats').attr('');
				alert(s);
			}

		});
		$('#platiniumRow').click(function() {
			if ($(this).prop('checked') === true) {
				$('#platiniumSeats').show();
			} else {
				$('#platiniumSeats').hide();
			}

		});
		$('#silverRow').click(function() {
			if ($(this).prop('checked') === true) {
				$('#silverSeat').show();
			} else {
				$('#silverSeat').hide();
			}
		});
		$(function() {
			var total_seats = function() {
				var sum = 0;
				$('.amount').each(function() {
					var num = $(this).val();
					if (num != 0) {
						sum += parseFloat(num);
					}
				});
				$('#screenCapacity').val(sum);
			}
			$('.amount').keyup(function() {
				total_seats();
			});
		});
	</script>
</body>

</html>