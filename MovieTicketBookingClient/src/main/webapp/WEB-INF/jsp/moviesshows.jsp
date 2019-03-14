<%@page import="java.util.Base64.Decoder"%>
<%@page import="java.util.Base64"%>
<%@page import="com.cignex.movieticketbooking.model.Movie"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>






	<jsp:include page="header.jsp"></jsp:include>



	<div style="margin: 50px;" class="card mb-3">


		<%
			List<Movie> movies = (List<Movie>) request.getAttribute("movies");
		%>
		<div class="row" align="center">
			<%
				for (Movie m : movies) {
					String image = Base64.getEncoder().encodeToString(m.getMoviePoster());
			%>

			<div class="col-sm-4" style="margin-bottom: 10px; margin-top: 10px;">
				<div class="card" style="width: 18rem;">
					<img class="card-img-top" height="250px;"
						src="data:image/jpg;base64,<%=image%>">
					<div class="card-body">
						<h5 class="card-title"><%=m.getMovieName()%></h5>
						<p class="card-text"><%=m.getMovieDirector()%></p>
						<div align="center">
							<a href="/ticketbooking/request/<%=m.getMovieId()%>"><button
									type="button" class="btn btn-primary">Book</button></a>

						</div>

					</div>
				</div>


			</div>

			<%
				}
			%>
		</div>

	</div>
</body>
</html>

