<%@page import="com.org.dto.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dto.Doctor"%>
<%@page import="com.org.dao.DoctorDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../components/bootstrap.jsp"%>
</head>
<body>
	<%@include file="../components/doctor_navbar.jsp" %>
	<h1 class="text-center ">Welcome to doctor Home page</h1>
<!-- Doctor_home.jsp -->
	<%
	int doctorId = (int) session.getAttribute("doctorId");
	DoctorDao doctorDao = new DoctorDao();
	Doctor doctor = doctorDao.fetchDoctor(doctorId);
	List<Appointment> list = doctor.getAppointment();
	%>
	<div class="d-flex justify-content-center">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Age</th>
					<th scope="col">Gender</th>
					<th scope="col">Email</th>
					<th scope="col">Mobile</th>
					<th scope="col">Aadhar</th>
					<th scope="col">Address</th>
					<th scope="col">Appointment Date</th>
					<th scope="col">Disease</th>
					<th scope="col">Doctor</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ap" items="<%=list%>">
					<tr scope="row">
						<td>${ap.name}</td>
						<td>${ap.age}</td>
						<td>${ap.gender}</td>
						<td>${ap.email}</td>
						<td>${ap.phone}</td>
						<td>${ap.aadhar}</td>
						<td>${ap.address}</td>
						<td>${ap.appointmentDate}</td>
						<td>${ap.diseases}</td>
						<td>${ap.doctor.name}</td>
						<c:if test="${ap.status.equals('pending')}">
							<td class="bg-warning text-light">${ap.status}</td>
						</c:if>
						<c:if test="${ap.status.equals('accepted')}">
							<td class="bg-success text-light">${ap.status}</td>
						</c:if>
						<c:if test="${ap.status.equals('rejected')}">
							<td class="bg-danger text-light">${ap.status}</td>
						</c:if>


						<td><a class="btn btn-md btn-success"
							href="updateAccept?id=${ap.id}">Accept</a> <a
							class="btn btn-md btn-danger">Reject</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>