<%@ page import="com.org.dto.Doctor"%>
<%@ page import="java.util.List"%>
<%@ page import="com.org.dao.DoctorDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Appointment</title>
<%@ include file="../components/bootstrap.jsp" %>
</head>
<body>
    <%@ include file="../components/user_navbar.jsp" %>
    <%
        DoctorDao dao = new DoctorDao();
        List<Doctor> list = dao.fetchAll();
        int userId = (int) session.getAttribute("userId");
    %>
    
    <div class="d-flex justify-content-center">
        <form action="add_appointment" method="post">
            <div class="mb-3">
                <label class="form-label">Name</label>
                <input type="text" name="name" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Age</label>
                <input type="text" name="age" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Gender</label>
                <select name="gender" class="form-control" required>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                    <option value="Others">Others</option>
                </select>
            </div>
            <div class="mb-3">
                <label class="form-label">Email</label>
                <input type="email" name="email" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Diseases</label>
                <input type="text" name="diseases" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Appointment Date</label>
                <input type="date" name="appointmentDate" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Phone</label>
                <input type="text" name="phone" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Address</label>
                <input type="text" name="address" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Aadhar</label>
                <input type="text" name="aadhar" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Doctor</label>
                <select name="doctorId" class="form-control" required>
                    <c:forEach var="d" items="${list}">
                        <option value="${d.id}">${d.name} (${d.specialist})</option>
                    </c:forEach>
                </select>
            </div>
            <input type="hidden" name="userId" value="${userId}">
            <button type="submit" class="btn btn-primary">Add Appointment</button>
        </form>
    </div>
</body>
</html>
