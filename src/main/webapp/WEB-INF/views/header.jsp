<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>  
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/common.css" >
</head> 
<body>
    <div>
        <nav class="navbar navbar-default navigation-clean-button">
            <div class="container">
                <div class="navbar-header"><a class="navbar-brand" href="/main"><img src="img/logo.png" style="width:40%; height:auto;"/></a>
                    <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
                </div>
                <div class="collapse navbar-collapse" id="navcol-1">
                    <ul class="nav navbar-nav">
                        <li class="active" role="presentation"><a href="#">First Item</a></li>
                        <li role="presentation"><a href="#">Second Item</a></li>
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false" href="#">Dropdown <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li role="presentation"><a href="#">First Item</a></li>
                                <li role="presentation"><a href="#">Second Item</a></li>
                                <li role="presentation"><a href="#">Third Item</a></li>
                            </ul>
                        </li>
                    </ul>
                    
                    <p class="navbar-text navbar-right actions">
                    	<!-- 로그인 정보가 존재할 때 -->
                    	<sec:authorize access="isAuthenticated()">
							<a class="btn btn-default action-button" role="button" href="j_spring_security_logout" target="_self">Logout</a>
							<a class="navbar-link login" href="#">My Info</a>
						</sec:authorize>
						<!-- 로그인 정보가 존재하지 않을 때. 익명의 사용자 -->
						<sec:authorize access="isAnonymous()">
                   	 		<a class="navbar-link login" href="signin_view">Sign In</a> 
                   	 		<a class="btn btn-default action-button" role="button" href="signup_view">Sign Up</a>
                   		</sec:authorize>	
                  
                    </p>
                </div>
            </div>
        </nav>
    </div>
    
    <!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> --->
</body>


</html>