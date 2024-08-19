<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../components/bootstrap.jsp"%>
</head>
<body>
	<%@ include file="../components/admin_navbar.jsp"%>

	<form:form action="registerAndUpdateDoctor" modelAttribute="doctor">
		<h3>Name:</h3>
		<form:input path="name"/>
		<br> <br>
		
		<h3>dob;</h3>
		<form:input path="dob" type="date"/>
		<br> <br>
		
		<h3>qualification;</h3>
		<form:input path="qualification"/>

		<h3>specialist;</h3>
		<form:select path="specialist">
			<c:forEach var="spec" items="${list}">
				<form:option value="${spec.name}"></form:option>
			</c:forEach>
		</form:select>

		<h3>email;</h3>
		<form:input path="email" type="email"/>
		<br> <br>

		<h3>mobile;</h3>
		<form:input path="mobile" type="number"/>
		<br> <br>
		
		<h3>password;</h3>
		<form:input path="password" type="password"/>
		<br> <br>
		
		<form:button>Submit</form:button>
	</form:form>

</body>
</html>