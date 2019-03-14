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
	<div style="margin: 100px;">

		<%
			Movie movie = (Movie) request.getAttribute("movie");
		%>
		<div class="row">
			<div class="col" align="center">
				<form:form modelAttribute="movie" action="/movies/updateposter" method="post" enctype="multipart/form-data">
				<form:hidden path="movieId" />
				<form:hidden path="movieCategory"/>
				<form:hidden path="movieDescryption"/>
				<form:hidden path="movieReleaseDate"/>
				<form:hidden path="movieActors"/>
				<form:hidden path="movieDirector"/>
				<form:hidden path="movieLength"/>
				<form:hidden path="movieName"/>
				<label for="exampleFormControlFile1">Movie Poster Update</label>
					<%
						String image = Base64.getEncoder().encodeToString(movie.getMoviePoster());
					%><div class="card" style="width: 18rem;" align="center">
						<img class="card-img-top" height="250px;" 
							src="data:image/jpg;base64,<%=image%>">
							<br>
					<input
					type="file" class="form-control-file" id="exampleFormControlFile1" name="poster" required>
					<button type="submit" class="btn btn-primary">Update</button>
					</div>
				</form:form>
			</div>
			<div class="col">
				<form:form modelAttribute="movie" action="/movies/updatemovie"
					method="post">
					<form:hidden path="moviePoster"/>
					<form:hidden path="movieId" />
					<div class="row">
						<div class="col">
							<label for="formGroupExampleInput">Movie Name</label>
							<form:input path="movieName" type="text" class="form-control"
								placeholder="Enter Movie name" />
						</div>
						<div class="col">
							<label for="formGroupExampleInput">Movie category</label>
							<form:input path="movieCategory" type="text" class="form-control"
								placeholder="Enter Movie category" />
						</div>
					</div>
					<div class="form-group">
						<label for="formGroupExampleInput">Movie Discryption</label>
						<form:textarea path="movieDescryption" type="text"
							class="form-control" id="formGroupExampleInput"
							placeholder="Movie Discryption" />
					</div>
					<div class="row">
						<div class="col">
							<label for="formGroupExampleInput">release date</label>
							<form:input path="movieReleaseDate" type="date"
								class="form-control" />
						</div>
						<div class="col">
							<label for="formGroupExampleInput">Movie Director</label>
							<form:input path="movieDirector" type="text" class="form-control"
								placeholder="Enter Movie Director" />
						</div>

						<div class="col">
							<label for="formGroupExampleInput">Movie Duration</label>
							<form:input path="movieLength" type="text" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="formGroupExampleInput">Movie actors</label>
						<form:input path="movieActors" type="text" class="form-control"
							id="formGroupExampleInput" placeholder="Enter Movie actors" />
					</div>
					<button type="submit" class="btn btn-primary">Update</button>
					<a href="/movies/showall"><button type="button"
							class="btn btn-primary">Cancel</button></a>
				</form:form>

			</div>
		</div>
	</div>
</body>
</html>