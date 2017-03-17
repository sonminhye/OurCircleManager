<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>

<style type="text/css">
span{
  font-size: 15px;
}
#checkMsg{
  font-size: 12px;
}
#checkPwd{
  color : red;
  font-size: 12px;
}
</style>

<script type="text/javascript" src="js/httpRequest.js"></script>
<script>

	var checkFirst = false;
	var lastKeyword = '';
	var loopSendKeyword = false;
	
	var accountCheck = document.getElementByName(accountCheck).value;
	var passwordCheck = document.getElementByName(passwordCheck).value;

	
	function checkAccount() {
	 if (checkFirst == false) {
	  //0.5초 후에 sendKeyword()함수 실행
	  setTimeout("sendAccount();", 500);
	  loopSendKeyword = true;
	 }
	 checkFirst = true;
	}
	
	// 비밀번호확인 
	//to do : 비밀번호 글자수, 특수문자, 영숫자조합 체크하기 
	function checkPwd(){
	 var f1 = document.forms[0];
	 var pw1 = f1.password.value;
	 var pw2 = f1.password_check.value;
	 if(pw1!=pw2){
	  document.getElementById('checkPwd').style.color = "red";
	  document.getElementById('checkPwd').innerHTML = "비밀번호와 똑같이 입력해주세요.";
	  passwordCheck = 0;
	 }else{
	  document.getElementById('checkPwd').style.color = "black";
	  document.getElementById('checkPwd').innerHTML = "비밀번호가 확인 되었습니다.";
	  passwordCheck = 1; //비밀번호 임력했음을 체크
	 }
	 
	}
	
	
	function sendAccount() {
	 if (loopSendKeyword == false) return;
	 
	 var keyword = document.forms[0].account.value;
	 if (keyword == '') {
	  lastKeyword = '';
	  document.getElementById('checkMsg').style.color = "black";
	  document.getElementById('checkMsg').innerHTML = "아이디를 입력하세요.";
	 } else if (keyword != lastKeyword) {
	  lastKeyword = keyword;
	  
	  if (keyword != '') {
		
	 		  var params = "account="+encodeURIComponent(keyword);
		 	  sendRequest("check_signup", params, displayResult, 'POST');
		  
	  } 
	  
	  else {
	  }
	 }
	 setTimeout("sendAccount();", 500);
	}
	
	
	function displayResult() {
	 if (httpRequest.readyState == 4) {
	  if (httpRequest.status == 200) {
	   var resultText = httpRequest.responseText;
	   var listView = document.getElementById('checkMsg');
	   if(resultText==0){
	    listView.innerHTML = "사용 할 수 있는 ID 입니다";
	    listView.style.color = "blue";
	    accountCheck = 1; //아이디 입력했음을 체크
	   }else{
	    listView.innerHTML = "이미 등록된 ID 입니다";
	    listView.style.color = "red";
	    accountCheck = 2; 
	   }
	  } else {
	   alert("에러 발생: "+httpRequest.status);
	  }
	 }
	}

	function checkSubmit(){
		var nameCheck = document.forms[0].name.value;
		var univCheck = document.forms[0].univ.value;
		
		if(accountCheck=='2'){
			alert('이미 존재하는 아이디 입니다.');
			return false;
		}
		if(accountCheck=='0' || passwordCheck=='0' || nameCheck ==''){
			alert('회원가입 폼을 정확히 채워 주세요.');
			return false;
		}
		if(univCheck=='0'){
			alert('학교를 선택해 주세요.');
			return false;
		}else{
			return true;
		}
	   

	}
</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="wrapper">
	<form action="signup" method="POST" name="signupform" id="signupform" onsubmit="return checkSubmit()">
		<h2 class="form-signin-heading">회원가입하기</h2>
		<input name="auth" id="auth" class="accountCheck" type="hidden" value='1'>
		<div class="form-group" name="userId" id="userId">
			<label for="idinput">아이디</label>
			<input type="text" name="account" id="account" onkeydown="checkAccount()" class="form-control" placeholder="아이디">
			<div id="checkMsg">아이디를 입력하세요.</div>
		</div>
		<div class="form-group">
			<label for="nameinput">이름</label>
			<input type="text" name="name" class="form-control" placeholder="이름">
		</div>
		<div class="form-group">
			<label for="passwordinput">비밀번호</label>
			<input type="password" name="password" class="form-control" placeholder="숫자,특수문자 포함 8자이상">
		</div>
		<div class="form-group">
			<label for="nameinput">비밀번호 확인</label>
			<input type="password" name="password_check" onkeyup="checkPwd()" class="form-control" placeholder="비밀번호 확인">
			<div id="checkPwd">비밀번호와 똑같이 입력해주세요</div>

		</div>
		<!-- to do : 대학교도 DB에서 리스트 가져오도록 구현하깅 -->
		<div class="form-group">
			<label for="nameinput">학교</label>
			<select name="univ"  class="form-control">
					<option value="0">-학교선택-</option>
   					<option value="1">동국대학교</option>
   					<option value="2">서울대학교</option>
   			  </select>
		</div>
		<input type="submit" value="join" id="join" class="btn btn-primary btn-block">
	</form>		
		<!-- 입력 여부 체크하기위한 hidden input -->
	<div class="formCheck">
        <input name="accountCheck" class="accountCheck" type="hidden" value='0'>
        <input name="passwordCheck" class="passwordCheck" type="hidden" value='0'>
    </div>
</div> <!-- wrapper class close -->
<jsp:include page="footer.jsp"></jsp:include>	
	
</body>
</html>