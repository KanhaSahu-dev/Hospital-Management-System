<%@ page import="com.org.dto.User"%>
<%@ page import="java.util.List"%>
<%@ page import="com.org.dao.UserDao"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <%@ include file="../components/bootstrap.jsp" %> 
</head>
<body>
    <%@ include file="../components/admin_navbar.jsp" %>
    
    <%
        UserDao UserDao = new UserDao();
        List<User> list = UserDao.fetchAll();
        request.setAttribute("UserList", list);  // Corrected attribute name
    %> 
    
    <h1>List of Patients:</h1>
    <h2>
        
        <c:forEach var="i" items="${UserList}">
            ${i.name}<br>
        </c:forEach>
    </h2>
</body>
</html>
