<%@page import="com.org.dto.Doctor"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.DoctorDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../components/bootstrap.jsp" %>
</head>
<body>
<%@ include file="../components/admin_navbar.jsp" %>
<%
	DoctorDao doctorDao = new DoctorDao();
	List<Doctor> listOfDoctors = doctorDao.fetchAll();
%>
<h1 class="text-center">Welcome to Admin Home Page</h1>
	
	<h2>No of Doctors <%= listOfDoctors.size()%></h2>
</body>
</html>