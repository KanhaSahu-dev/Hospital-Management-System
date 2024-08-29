<%@ page import="com.org.dto.Appointment"%>
<%@ page import="java.util.List"%>
<%@ page import="com.org.dto.Doctor"%>
<%@ page import="com.org.dao.DoctorDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Home</title>
<%@ include file="../components/bootstrap.jsp"%>
</head>
<body>
    <%@ include file="../components/doctor_navbar.jsp" %>
    <h1 class="text-center">Welcome to Doctor Home Page</h1>
    
    <%
        int doctorId = (int) session.getAttribute("doctorId");
        DoctorDao doctorDao = new DoctorDao();
        Doctor doctor = doctorDao.fetchDoctor(doctorId);
        List<Appointment> list = doctor.getAppointment();
    %>
    
    <div class="d-flex justify-content-center">
        <table class="table table-striped">
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
                <c:forEach var="ap" items="${list}">
                    <tr>
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
                        <c:choose>
                            <c:when test="${ap.status == 'pending'}">
                                <td class="bg-warning text-light">${ap.status}</td>
                            </c:when>
                            <c:when test="${ap.status == 'accepted'}">
                                <td class="bg-success text-light">${ap.status}</td>
                            </c:when>
                            <c:otherwise>
                                <td class="bg-danger text-light">${ap.status}</td>
                            </c:otherwise>
                        </c:choose>
                        <td>
                            <a class="btn btn-success" href="updateAccept?id=${ap.id}">Accept</a>
                            <a class="btn btn-danger" href="updateReject?id=${ap.id}">Reject</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
