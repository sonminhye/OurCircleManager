<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 여기서부터는 언니가 하시면되요오~ -->
	nocircle_view
	my account <%= session.getAttribute("account") %> <!-- 이거는,계정정보를 세션에 넣었어요 이런식으로 필요할때 쓰면 될거같아영 -->
</body>
</html>