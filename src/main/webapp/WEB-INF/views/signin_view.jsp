<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		
		event.preventDefault(); // 체크 후 넘어가게 하기 위해
		
		$.ajax({
				type : "POST",
				url : "signin_check",
				contentType:'application/json; charset=UTF-8',
				data : jsonStr,
				 success: function(data) {
				     if(data=="0"){
				    	 alert("아이디 혹은 비밀번호가 일치하지 않습니다.");
				     }else if(data=="1"){
				    	 //넘겨주는 기능 구현
				    	 $.checkCircle(jsonStr);
				    	 //window.location.href = "signin_success";
				     }    	
				 },
				 error:function(request,status,error){
				        alert("error code:"+request.status+"\n"+"error:"+error);
				 }
		}); 
	});
	
	$.checkCircle = function(jsonStr){
		
		$.ajax({
			type : "POST",
			url : "check_circle",
			contentType:'application/json; charset=UTF-8',
			data : jsonStr,
			 success: function(data) {
			   window.location.href= data;
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
    <form class="form-signin" name="signinform" id="signinform">       
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