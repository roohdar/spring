<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>


 <nav class="navbar navbar-expand-lg navbar-light bg-light">

	<div class="collapse navbar-collapse" id="navbarNavDropdown">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="/movies">Add
					Movie</a></li>
			<li class="nav-item"><a class="nav-link" href="/movies/showall">Movies</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="/movies/booking">Book
					Ticket</a></li>
			<li class="nav-item"><a class="nav-link"
				href="/show/addshowmoviedetails">Add Show</a></li>
		</ul>
	</div>
	<form class="form-inline">
		<input class="form-control mr-sm-2" type="search" placeholder="Search"
			name="searchtext" value=""
			onkeyup="sendAjaxSearchRequest(this.value,showdetails)"
			aria-label="Search">
		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
	</form>
</nav> 

<!--  <nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Movie Ticket Booking</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a class="nav-link" href="/movies">Add
					Movie</a></li>
			<li><a class="nav-link" href="/movies/showall">Movies</a></li>
			<li><a class="nav-link" href="/movies/booking">Book Ticket</a></li>
			<li><a class="nav-link" href="/show/addshowmoviedetails">Add
					Show</a></li>
		</ul>
	</div>
</nav>  -->