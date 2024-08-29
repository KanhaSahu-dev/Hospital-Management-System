<%@ page import="com.org.dto.Doctor"%>
<%@ page import="java.util.List"%>
<%@ page import="com.org.dao.DoctorDao"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Doctors</title>
<%@ include file="../components/bootstrap.jsp"%>
<style>
    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
        width: 100%;
    }
    th, td {
        text-align: center;
        padding: 5px;
    }
    .container {
        margin-top: 50px;
    }
    h1 {
        margin-bottom: 30px;
    }
</style>
</head>
<body>
<%@ include file="../components/admin_navbar.jsp"%>
<%
    DoctorDao doctorDao = new DoctorDao();
    List<Doctor> list = doctorDao.fetchAll();
    request.setAttribute("doctorList", list);
%>
<div class="container">
    <h1 class="text-center">List of Doctors</h1>
    <c:forEach var="i" items="${doctorList}">
        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>Doctor Name</th>
                    <th>Specialization</th>
                    <th>Email</th>
                    <th>Password</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${i.name}</td>
                    <td>${i.specialist}</td>
                    <td>${i.email}</td>
                    <td>${i.password}</td>
                </tr>
            </tbody>
        </table>
    </c:forEach>
</div>
</body>
</html>
