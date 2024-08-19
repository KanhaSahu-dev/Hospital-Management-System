<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Login</title>
<%@ include file="components/bootstrap.jsp" %>
<style type="text/css">
.paint-card {
    box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
    <%@ include file="components/index_navbar.jsp" %>

    <div class="container p-5">
        <div class="row">
            <div class="col-md-4 offset-md-4">
                <div class="card paint-card">
                    <div class="card-body">
                        <p class="fs-4 text-center">Doctor Login</p>

                        <c:if test="${not empty failure}">
                            <h2 class="text-danger text-center">${failure}</h2>
                        </c:if>

                        <form action="doctor_login" method="post">
                            <div class="mb-3">
                                <label class="form-label">Email Address</label>
                                <input name="email" type="email" class="form-control" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Password</label>
                                <input name="password" type="password" class="form-control" required>
                            </div>
                            <button type="submit" class="btn bg-primary text-white col-md-12">Login</button>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
