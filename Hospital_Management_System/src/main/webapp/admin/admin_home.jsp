<%@page import="com.org.dto.Doctor"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.DoctorDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home Page</title>
<%@ include file="../components/bootstrap.jsp" %>
<style>
    .container {
        margin-top: 50px;
    }
    .header {
        margin-bottom: 30px;
    }
</style>
</head>
<body>
<%@ include file="../components/admin_navbar.jsp" %>
<%
    DoctorDao doctorDao = new DoctorDao();
    List<Doctor> listOfDoctors = doctorDao.fetchAll();
%>
<div class="container">
    <div class="header text-center">
        <h1>Welcome to Admin Home Page</h1>
    </div>
    <div class="row">
        <div class="col-md-12">
            <h2 class="text-center">Number of Doctors: <%= listOfDoctors.size() %></h2>
        </div>
    </div>
</div>
</body>
</html>
