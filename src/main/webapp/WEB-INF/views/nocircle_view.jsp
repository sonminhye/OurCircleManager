<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>

    <div id="top" class="main">
        <div class="text-vertical-center">
            <h1>지금 바로 모임에 가입해 보세요 !</h1>
            <br>
            <a href="addcircle_view" class="btn btn-dark btn-lg">시작하기</a>
        </div>
    </div>
	
<jsp:include page="footer.jsp"></jsp:include> 
</body>
</html>

<!--   my account <%= session.getAttribute("account") %> -->