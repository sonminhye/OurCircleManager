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
<jsp:include page="header.jsp"></jsp:include>

<div class="main">
<jsp:include page="sidebar.jsp"></jsp:include>
<div class="circle-content">
                <div class="col-md-12">
                    <div class="panel panel-default">
                    	<div>가입하기</div>
                        <div class="panel-heading">${dto.name }</div>
                        <div class="panel-body">
                            ${dto.intro }
                            <img alt="이미지 없음" src="img/circle/${dto.image }">
                        </div>
                    </div>
                </div>
            </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>