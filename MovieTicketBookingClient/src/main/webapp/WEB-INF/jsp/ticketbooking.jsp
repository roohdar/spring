<%@page
	import="com.cignex.movieticketbooking.mvccontroller.MovieContoller"%>
<%@page import="com.cignex.movieticketbooking.model.MovieShow"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Base64"%>
<%@page import="com.cignex.movieticketbooking.model.Movie"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.btn {
	margin-left: 10px;
}

.content {
	width: 600px;
}
</style>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Movie</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div style="margin: 30px;">

		<%
			List<MovieShow> movieShows = (List<MovieShow>) request.getAttribute("show");
			Movie movie = movieShows.get(0).getMovie();
			movie = MovieContoller.setPoster(movie);
		%>


		<div class="card border black">
			<%
				String image = Base64.getEncoder().encodeToString(movie.getMoviePoster());
			%>
			<div class="row">
				<div class="col">
					<img src="data:image/jpg;base64,<%=image%>" alt="Card image cap"
						class="img-thumbnail">
				</div>
				<div class="col">
					<div class="card-body">

						<div class="card-body" align="center">
							<div class="row">
								<c:forEach items="${show }" var="s">

									<a href="/ticketbooking/bookshow/${s.showId }">
										<button type="button" class="btn btn-success">
											<div class="col">
												<label> ${s.showTime } </label>
											</div>
										</button>
									</a>

								
								</c:forEach>
							</div>
							<div class="row">
								<div class="col" id="seats"></div>
							</div>
						</div>
					</div>

				</div>
			</div>
			<div class="row">
				<div class="col">
					<h5 class="card-title"><%=movie.getMovieName()%></h5>
					<p class="card-text">
						<%=movie.getMovieDescryption()%>
					</p>
				</div>
			</div>

		</div>
	</div>
</body>
</html>