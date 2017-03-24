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
<%
	//동아리 카테고리 출력을 위한 배열 
	String[] arr = {"예술,창작", "봉사", "연구", "체육", "공연", "사회", "학술", "종교"};
	request.setAttribute("circle_category", arr);
%>

    <div id="top">
    

       
        <div class="text-container">
            <h2>우리학교엔 이런 동아리들이 있어요 !</h2>
            <br>
            
		    <!-- 임시버튼 -->  
		    <h4>내가 찾는 동아리가 없나요?</h4>  
   			<a class="btn btn-info" href="addcircle_view">동아리 만들기<span class="glyphicon glyphicon-chevron-right"></span></a>
    		
		    <!-- 전체 카테고리별로 돌아가면서 출력 -->
		    <c:forEach items="${circle_category}" var="category" varStatus="status">
		    
		    <!-- 동아리 카테고리 이름 출력 -->
		    <div class="row">
	            <div class="col-lg-12">
	                <h2 class="page-header"> ${category} </h2>
	           	</div>
       		</div>
				<!-- 카테고리에 맞는 동아리 출력 -->
			    <c:forEach items="${list}" var="dto">
					<c:if test="${dto.circle_category_id eq status.count}">
					<!-- 동아리 개별 출력부분 -->
					<div class="row">
			            <div class="col-md-7">
			                <a href="circle_main?circle_id=${dto.circle_id}">
			                    <img class="img-responsive" src="img/circle/${dto.image}" alt="">
			                </a>
			            </div>
			            <div class="col-md-5">
			                <a class="circle-title" href="circle_main?circle_id=${dto.circle_id}" >
			                	<h3>${dto.name}</h3>
			                </a>
			                <h4>${dto.membercount} 명의 회원</h4>
			                <p>${dto.intro} </p>
			                <a class="btn btn-info" href="circle_main?circle_id=${dto.circle_id}">동아리 구경하기<span class="glyphicon glyphicon-chevron-right"></span></a>
			            </div>
			        </div>
			        <hr>
					</c:if>
			    </c:forEach>
			 		    
		    </c:forEach>
        </div>
        

    </div>
    
	
<jsp:include page="footer.jsp"></jsp:include> 
</body>
</html>

<!--   my account <%= session.getAttribute("account") %> -->