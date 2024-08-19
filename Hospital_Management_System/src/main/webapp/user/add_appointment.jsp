<%@page import="com.org.dto.Doctor"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.DoctorDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../components/bootstrap.jsp" %>
</head>
<body>
<!-- add_appointment.jsp -->
	<%@ include file="../components/user_navbar.jsp" %>
	<%
		DoctorDao dao = new DoctorDao();
		List<Doctor> list = dao.fetchAll();
		
		int userId = (int)session.getAttribute("userId");
	%>
	
	<div class="d-flex justify-content-center">
		<form action="add_appointment" method="post">
		
			<label>name;</label>
				<input type="text" name="name">	 <br> <br>
			<label>age;</label>
				<input type="text" name="age"><br> <br>
			
			<label>gender;</label>
				<select name="gender">
					<option >Male</option>
					<option>Female</option>
					<option >Others</option>
				</select><br> <br>
			<label>email;</label>
				<input type="email" name="email"><br> <br>
			
			<label>diseases;</label>
				<input type="text" name="diseases"><br> <br>
			
			<label>AppointmentDate;</label>
				<input type="text" name="appointmentDate"><br> <br>
			
			<label>phone;</label>
				<input type="text" name="phone"><br> <br>
			
			<label>address;</label>
				<input type="text" name="address"><br> <br>
			
			<label>aadhar;</label>
				<input type="text" name="aadhar"><br> <br>
				
<!-- add_appointment.jsp contd-->
			<label>Doctor</label>
				<select name="doctorId">
						<c:forEach var="d" items="<%=list%>">
							<option value="${d.id}">${d.name}(${d.specialist})</option>
						</c:forEach>
				</select>
				<input type="hidden" name="userId" value="<%=userId%>">
				
			<input type="submit" value="Add">
				
		
		
		</form>
	
	</div>
</body>
</html>