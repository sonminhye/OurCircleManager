<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
$(document).ready(function(){
    $(".push_menu").click(function(){
         $(".circle-wrapper").toggleClass("active");
    });
    
    $(".menu li").click(function(event){
    	$("a").removeClass("active");
    	$(this).children().toggleClass("active");
    });
    
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="circle-container">
	<div class="circle-row">
		<div class="circle-wrapper">
    	    <div class="side-bar">
                <ul>
                    <li class="menu-head">
                        MOMENT <a href="#" class="push_menu"><span class="glyphicon glyphicon-align-justify pull-right"></span></a>
                    </li>
                    <div class="menu">
                        <li>
                            <a href="#">동아리 소개 <span class="glyphicon glyphicon-dashboard pull-right"></span></a>
                        </li>
                        <li>
                            <a href="#" class="active">행사관리<span class="glyphicon glyphicon-heart pull-right"></span></a>
                        </li>
                        <li>
                            <a href="#">방명록 <span class="glyphicon glyphicon-star pull-right"></span></a>
                        </li>
                        <li>
                            <a href="#">관리하기 <span class="glyphicon glyphicon-cog pull-right"></span></a>
                        </li>
                    </div>
                    
                </ul>
    	    </div>   
            
		</div>
	</div>
</div>
</body>
</html>