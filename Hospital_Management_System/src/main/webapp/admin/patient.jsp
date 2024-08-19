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
    <title>List of Patients</title>
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
        UserDao userDao = new UserDao();
        List<User> list = userDao.fetchAll();
        request.setAttribute("UserList", list);
    %>
    <div class="container">
        <div class="header text-center">
            <h1>List of Patients</h1>
        </div>
        <c:forEach var="i" items="${UserList}">
            <div class="row">
                <div class="col-md-12">
                    <h2>${i.name}</h2>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>
