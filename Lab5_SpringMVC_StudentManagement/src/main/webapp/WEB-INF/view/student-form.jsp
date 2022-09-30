<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Student Form</title>
</head>
<body>
	
	<div class="container">
		<h3>Students Directory</h3>
		<hr>
		
		<h4>Student Form</h4>
		
		<form action="/Lab5_SpringMVC_StudentManagement/students/save" method="POST">
			<input type="hidden" name="id" value="${student.id}" />
			
			<div class="form-inline">
				<input type="text" name="firstName" value="${student.firstName}"
					class="form-control mb-4 col-4" placeholder="FirstName">
			</div>
			
			<div class="form-inline">
				<input type="text" name="lastName" value="${student.lastName}"
					class="form-control mb-4 col-4" placeholder="LastName">
			</div>

			<div class="form-inline">
				<input type="text" name="department" value="${student.department}"
					class="form-control mb-4 col-4" placeholder="Department">
			</div>

			<div class="form-inline">
				<input type="text" name="country" value="${student.country}"
					class="form-control mb-4 col-4" placeholder="Country">
			</div>
			
			<button type="submit" class="btn btn-info col-2">Save</button>
		</form>
		
		<hr>
		<a href="/Lab5_SpringMVC_StudentManagement/students/list">Back to Students List</a>
		
	</div>
	
</body>
</html>