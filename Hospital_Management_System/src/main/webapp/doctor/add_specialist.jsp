<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../components/bootstrap.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@ include file="../components/admin_navbar.jsp"%>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="car paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Add Specialist</p>
						<c:if test="${not empty success}">
							<h3 class="text-success text-center">${success}</h3>
						</c:if>
						
						<form action="add_specialist" method="post">
							<div class="mb-3">
								<label class="form-label">Specialist Name</label> <input
									name="name" type="text" class="form-control" required>
							</div>

							<button type="submit" class="btn bg-primary text-white col-md-12">Add</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>