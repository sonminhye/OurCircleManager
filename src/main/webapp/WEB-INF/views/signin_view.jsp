<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
$(function(){
	
	$("#signinform").submit(function(event){
			
		var account = $("#account").val();
		var password = $("#password").val();
		var formData = {"account" :account, "password" :password};
		var jsonStr = JSON.stringify(formData); //json 으로 바꿔주는 이런 작업이 없어서 400 에러가 떴었음.
		
		event.preventDefault(); 
		
		$.ajax({
				type : "POST",
				url : "check_signin",
				contentType:'application/json; charset=UTF-8',
				data : jsonStr,
				 success: function(data) { //정보를 받는 데 성공했다면,
				     if(data=="0"){
				    	 alert("아이디 혹은 비밀번호가 일치하지 않습니다.");
				     }else if(data=="1"){
				    	 //동아리가 있는지 여부를 확인하기 위한 작업 
				    	 $.checkCircle(jsonStr);
				     }    	
				 },
				 error:function(request,status,error){
				        alert("error code:"+request.status+"\n"+"error:"+error); //post 가 실패했다면, error코드를 호출
				 }
		}); 
	});
	
	$.checkCircle = function(jsonStr){ //function
		
		$.ajax({
			type : "POST",
			url : "check_circle",
			contentType:'application/json; charset=UTF-8',
			data : jsonStr,
			 success: function(data) {
			   window.location.href= data; //data 로 넘어오는 페이지로 이동. 동아리 존재 여부에 따라서!
			 },
			 error:function(request,status,error){
			        alert("error code:"+request.status+"\n"+"error:"+error);
			 }
	});
		
	};
});
</script>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
  <div class="wrapper">
    <form class="form-signin" action="j_spring_security_check" method="post" >       
      <h2 class="form-signin-heading">Please login</h2>
      <input type="text" class="form-control" id="account" name="account" placeholder="Email Address" required="" autofocus="" />
      <input type="password" class="form-control" id="password" name="password" placeholder="Password" required=""/>      
      <label class="checkbox">
        <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> Remember me
      </label>
      <button id="button_submit" class="btn btn-lg btn-primary btn-block" type="submit">Login</button>   
    </form>
  </div>
  
<jsp:include page="footer.jsp"></jsp:include>  
</body>
</html>