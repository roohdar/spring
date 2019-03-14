<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Movie Shows</title>
</head>
<body>



	<jsp:include page="header.jsp"></jsp:include>
	<div class="card mb-3">
		<div style="margin: 100px;" class="border border-dark">
			<div class="card-header" style="margin-bottom: 30px;" align="center">Add
				Movie Show</div>

			<%
				String action = (String) request.getAttribute("action");
				if (action.equals("moviedetail")) {
			%>
			<form action="/show/addshow" method="post" style="margin: 20px;">
				<div class="row">
					<div class="col">
						<label for="formGroupExampleInput">Movie Name</label> <select
							name="movieId" class="form-control"
							id="exampleFormControlSelect2">
							<c:forEach items="${movies }" var="m">
								<option value="${m.movieId }">${m.movieName }</option>
							</c:forEach>
							<select>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<label for="formGroupExampleInput">Total Shows</label> <input
							type="number" name="shownumber" class="form-control"
							id="exampleInputEmail1" max="5" min="1">
					</div>
					<div class="col">
						<label for="formGroupExampleInput">Date</label> <input type="date"
							name="showdate" class="form-control" id="exampleInputEmail1">
					</div>
				</div>
				<br> <br>

				<button type="submit" class="btn btn-primary btn-lg btn-block">Submit</button>
				<form>
					<%
						} else {
					%>
					<div align="left" style="margin-left: 20px;">
						<label for="formGroupExampleInput"><b>Movie Name : </b></label>
						${show.movie.movieName }<br> <label
							for="formGroupExampleInput"><b>Total Shows : </b></label>
						${shownumber }<br> <label for="formGroupExampleInput"><b>Date
								: </b></label> ${show.showDate }<br>
					</div>
					
						<form:form action="/show/submitshow" method="post" modelAttribute="show"
							style="margin: 20px;">

							<%
								for (int i = 0; i < (Integer) request.getAttribute("shownumber"); i++) {
							%>
							<div class="border card mb-3">
							<form:hidden path="showDate" />
							<input type="hidden" name="showNumber" value="${shownumber }">
							<div class="row"
								style="margin: 20px; color: black; font-weight: bold">
								<div class="col">
								<label for="formGroupExampleInput">Show <%=i + 1%></label>
								</div>
								<div class="col">
									<label for="formGroupExampleInput">Screen</label> <select
										name="screen<%=i%>">
										<c:forEach items="${screen }" var="s">
											<option value="${s.screenNumber }">${s.screenNumber }</option>
										</c:forEach>
									</select>
								</div>
								<div class="col">
									 <input type="time" value="11:00"
										class="form-control" name="showtime<%=i%>"><label for="formGroupExampleInput">Show Time</label>
								</div>
							</div>
							<div class="row" style="margin: 20px; color: black; font-weight: bold">
							<label for="formGroupExampleInput">Ticket Pricing</label><br>
							<div class="col"><label for="formGroupExampleInput">Patinum</label>
									 <input type="number" value="200"
										class="form-control" name="platinum<%=i%>">
								</div>
								<div class="col"><label for="formGroupExampleInput">Gold</label>
									 <input type="number" value="150"
										class="form-control" name="gold<%=i%>">
								</div>
								<div class="col"><label for="formGroupExampleInput">Silver</label>
									 <input type="number" value="100"
										class="form-control" name="silver<%=i%>">
								</div>
							</div>
							</div>
							<%
								}
							%>
							<button type="submit" class="btn btn-primary mb-2">Submit</button>

						</form:form>
						<%
							}
						%>
					
		</div>
	</div>

</body>
</html>