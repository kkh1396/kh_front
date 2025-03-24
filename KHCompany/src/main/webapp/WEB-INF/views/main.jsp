<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html5>
<html>
<head>
<meta charset="UTF-8">
<title>KH Company </title>
</head>


<body>
		<h1>* KH Company *</h1>
		<%-- main.jsp 페이지로 포워딩 --%>
		

		<%-- header.jsp 페이지 페이지 포함 --%>
		<jsp:include page="common/header.jsp"/>
		<main></main>
		<%-- footer.jsp 페이지 페이지 포함 --%>
		<jsp:include page="common/footer.jsp"/>
</body>


</html>