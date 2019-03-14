<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.cignex.movieticketbooking.model.Screen"%>
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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Movie</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>



	<div style="margin: 30px;">


		<%
			MovieShow show = (MovieShow) request.getAttribute("show");
			Movie movie = show.getMovie();
			movie = MovieContoller.setPoster(movie);
			Screen screen = show.getScreen();
			List<String> seats = new ArrayList();
			seats.addAll(Arrays.asList(screen.getPlatinumSeats()));
			seats.addAll(Arrays.asList(screen.getGoldSeats()));
			seats.addAll(Arrays.asList(screen.getSilverSeats()));
			List<String> bookedSeats = new ArrayList();
			if (show.getBookedseats() != null) {
				bookedSeats.addAll(Arrays.asList(show.getBookedseats()));
			}
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
							<div class="row border" align="center" style="margin: 10px;">
								<div class="col-sm">
									Platinum :
									<%=show.getPlatinumPrice()%>
								</div>
								<div class="col-sm"></div>
								Gold :
								<%=show.getGoldPrice()%>
								<div class="col-sm">
									Silver :
									<%=show.getSilverPrice()%>
								</div>
							</div>
							<div class="row">
								<div class="col">
									<form action="/ticketbooking/bookseats" method="post">
										<input type="hidden" name="showId"
											value="<%=show.getShowId()%>">
										<%
											int n = 0;
											for (int i = 0; i < 6; i++) {
										%>

										<div class="btn-group" data-toggle="buttons">
											<%
												for (int j = 0; j < 10; j++) {
											%>
											<%
												if (bookedSeats.contains(seats.get(n))) {
											if(i<2){
											%>
											<label class="btn btn-danger active"> <%} else if(i<4 && i>=2){%>
												<label class="btn btn-success active"> <%}else{ %> <label
													class="btn btn-secondary active"> <%} %> <input
														height="20px;" width="20px;" id="materialInline1"
														name="seat<%=n%>" type="checkbox" checked="checked"
														disabled autocomplete="off" value="<%=seats.get(n)%>"><%=seats.get(n)%>
												</label> <%
												} else {if(i<2){
													%> <label class="btn btn-danger active"> <%} else if(i<4 && i>=2){%>
														<label class="btn btn-success active"> <%}else{ %> <label
															class="btn btn-secondary active"> <%} %> <input
																id="materialInline1" name="seat<%=n%>" type="checkbox"
																autocomplete="off" value="<%=seats.get(n)%>"><%=seats.get(n)%>
														</label> <%
												}
											%> <%
												n++;
													}
											%> <br>
										</div>
										<%
											}
										%>
										<br>
										<button type="submit" class="btn btn-primary">Book</button>

									</form>
								</div>

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