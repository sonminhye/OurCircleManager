<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>

    <div id="top" class="main">
        <div class="text-vertical-center">
            <h2>우리학교엔 이런 동아리들이 있어요 !</h2>
            <br>

		     <c:forEach items="${list}" var="dto">

		        <a href="#">
		            <h3>
		                ${dto.name}
		            </h3>
		        </a>
		        <hr>
		    </c:forEach>
        </div>
        

    </div>
    
	
<jsp:include page="footer.jsp"></jsp:include> 
</body>
</html>

<!--   my account <%= session.getAttribute("account") %> -->