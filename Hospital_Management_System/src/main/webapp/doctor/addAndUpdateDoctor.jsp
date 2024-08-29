<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Doctor</title>
<%@ include file="../components/bootstrap.jsp"%>
</head>
<body>
    <%@ include file="../components/admin_navbar.jsp"%>
    <div class="container p-5">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <div class="card paint-card">
                    <div class="card-body">
                        <h3 class="text-center">Register Doctor</h3>
                        <form:form action="registerAndUpdateDoctor" modelAttribute="doctor">
                            <div class="mb-3">
                                <label class="form-label">Name</label>
                                <form:input path="name" class="form-control"/>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Date of Birth</label>
                                <form:input path="dob" type="date" class="form-control"/>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Qualification</label>
                                <form:input path="qualification" class="form-control"/>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Specialist</label>
                                <form:select path="specialist" class="form-control">
                                    <c:forEach var="spec" items="${list}">
                                        <form:option value="${spec.name}">${spec.name}</form:option>
                                    </c:forEach>
                                </form:select>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Email</label>
                                <form:input path="email" type="email" class="form-control"/>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Mobile</label>
                                <form:input path="mobile" type="number" class="form-control"/>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Password</label>
                                <form:input path="password" type="password" class="form-control"/>
                            </div>
                            <div class="text-center">
                                <form:button class="btn btn-primary">Submit</form:button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
