<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Movie</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div style="margin: 100px;" class="card mb-3">
		<form:form modelAttribute="movie" action="movies/addmovie" enctype="multipart/form-data" style="margin: 20px;"
			method="post">
			<div class="row">
				<div class="col">
					<label for="formGroupExampleInput">Movie Name</label>
					<form:input path="movieName" type="text" class="form-control"
						placeholder="Enter Movie name" required="required"/>
				</div>
				<div class="col">
					<label for="formGroupExampleInput">Movie category</label>
					<form:input path="movieCategory" type="text" class="form-control"
						placeholder="Enter Movie category" required="required" />
				</div>
			</div>
			<div class="form-group">
				<label for="formGroupExampleInput">Movie Discryption</label>
				<form:textarea path="movieDescryption" type="text"
					class="form-control" id="formGroupExampleInput"
					placeholder="Movie Discryption" required="required"/>
			</div>
			<div class="row">
				<div class="col">
					<label for="formGroupExampleInput">release date</label>
					<form:input path="movieReleaseDate" type="date"
						class="form-control" required="required"/>
				</div>
				<div class="col">
					<label for="formGroupExampleInput">Movie Director</label>
					<form:input path="movieDirector" type="text" class="form-control"
						placeholder="Enter Movie Director" required="required"/>
				</div>

				<div class="col">
					<label for="formGroupExampleInput">Movie Duration</label>
					<form:input path="movieLength" type="text" class="form-control" required="required" value="2.5"/>
				</div>
			</div>
			<div class="form-group">
				<label for="formGroupExampleInput">Movie actors</label>
				<form:input path="movieActors" type="text" class="form-control"
					id="formGroupExampleInput" placeholder="Enter Movie actors" required="required"/>
			</div>
			<div class="form-group">
				<label for="exampleFormControlFile1">Movie Poster</label> <input
					type="file" class="form-control-file" id="exampleFormControlFile1" name="poster" required>
			</div>
			<button type="submit" class="btn btn-primary mb-2">Submit</button>
		</form:form>


	</div>
</body>
</html>