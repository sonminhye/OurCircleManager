<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>동아리 생성</title>

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
	
	var nameCheck = document.getElementByName(nameCheck).value;

	
	function checkName() {
	 if (checkFirst == false) {
	  //0.5초 후에 sendKeyword()함수 실행
	  setTimeout("sendName();", 500);
	  loopSendKeyword = true;
	 }
	 checkFirst = true;
	}

	
	function sendName() {
	 if (loopSendKeyword == false) return;
	 
	 var keyword = document.forms[0].name.value;
	 if (keyword == '') {
	  lastKeyword = '';
	  document.getElementById('checkMsg').style.color = "black";
	  document.getElementById('checkMsg').innerHTML = "동아리 이름을 입력하세요.";
	 } else if (keyword != lastKeyword) {
	  lastKeyword = keyword;
	  
	  if (keyword != '') {
		
	 		  var params = "name="+encodeURIComponent(keyword);
		 	  sendRequest("check_addcircle", params, displayResult, 'POST');
	  } 
	  
	  else {
	  }
	 }
	 setTimeout("sendName();", 500);
	}
	
	
	function displayResult() {
	 if (httpRequest.readyState == 4) {
	  if (httpRequest.status == 200) {
	   var resultText = httpRequest.responseText;
	   var listView = document.getElementById('checkMsg');
	   if(resultText==0){
	    listView.innerHTML = "사용 할 수 있는 이름 입니다.";
	    listView.style.color = "blue";
	    nameCheck = 1; //아이디 입력했음을 체크
	   }else{
	    listView.innerHTML = "이미 등록된 동아리 입니다.";
	    listView.style.color = "red";
	    nameCheck = 2; 
	   }
	  } else {
	   alert("에러 발생: "+httpRequest.status);
	  }
	 }
	}

	function checkSubmit(){
		var categoryCheck = document.forms[0].category.value;
		var introCheck = document.forms[0].intro.value;
		
		if(nameCheck=='2'){
			alert('이미 등록된 동아리 입니다.');
			return false;
		}
		if(nameCheck=='0' || introCheck=='0'){
			alert('폼을 정확히 채워 주세요.');
			return false;
		}
		if(categoryCheck=='0'){
			alert('분류를 선택해 주세요.');
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
	<form action="addcircle" method="POST" name="signupform" id="signupform" onsubmit="return checkSubmit()">
		<h2 class="form-signin-heading">동아리 만들기</h2>
		<!-- 동아리 만드는 회원의 권한은 ADMIN으로 -->
		<input name="auth" id="auth" type="hidden" value="ADMIN">
		<input name="univ_id" id="univ_id" type="hidden" value="${univ.univ_id}">
		<div class="form-group" name="univName" id="univName">
			<label for="nameinput">학교</label>
			<p class="form-control-static">${univ.name}</p>
		</div>
		<div class="form-group" name="circleName" id="circleName">
			<label for="nameinput">이름</label>
			<input type="text" name="name" id="name" onkeydown="checkName()" class="form-control" placeholder="이름">
			<div id="checkMsg">동아리 이름을 입력하세요.</div>
		</div>
		<div class="form-group">
			<label for="nameinput">분류</label>
			<select name="category"  id="category" class="form-control">
					<option value="0">-분류선택-</option>
   					<option value="1">예술,창작</option>
   					<option value="2">봉사</option>
   					<option value="3">연구</option>
   					<option value="4">체육</option>
   					<option value="5">공연</option>
   					<option value="6">사회</option>
   					<option value="7">학술</option>
   					<option value="8">종교</option>
   			  </select>
		</div>
		<div class="form-group">
			<label for="introinput">동아리 소개</label> <!-- 글자수제한하기 -->
			<textarea class="form-control" rows="3" name="intro" id="intro" placeholder="동아리를 소개해주세요."></textarea>
		</div>
		<div class="form-group">
    		<label for="fileinput">대표이미지 (700*300)</label>
   			 <input type="file" id="image" name="image" >
   			 <p class="help-block">Example block-level help text here.</p>
  		</div>
                                               
		<input type="submit" value="만들기" id="join" class="btn btn-primary btn-block">
	</form>		
	
		<!-- 입력 여부 체크하기위한 hidden input -->
	<div class="formCheck">
        <input name="introCheck" class="introCheck" type="hidden" value='0'>
    </div>
</div> <!-- wrapper class close -->
<jsp:include page="footer.jsp"></jsp:include>	
	
</body>
</html>