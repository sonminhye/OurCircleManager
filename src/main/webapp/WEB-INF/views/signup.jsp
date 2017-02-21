<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
function openForm(evt, formName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(formName).style.display = "block";
    evt.currentTarget.className += " active";
}
</script>
<title>회원가입</title>
</head>
<body>
<<<<<<< HEAD


=======
<jsp:include page="header.jsp"></jsp:include>
>>>>>>> b7cd8b2b7a627c46e06d09a3cc7f4de01cb588c7
<div class="tab">
	<a href="javascript:void(0);" class="tablinks" onclick="openForm(event, 'normal')">일반회원</a>
	<a href="javascript:void(0);" class="tablinks" onclick="openForm(event, 'manager')">관리자</a>
</div>
	<div class="tabcontent" id="normal">
		<p>일반 회원 가입 폼 입니다.</p>
		<form name="normal">
			아이디 : <input type="text" name="n_userid"><br/>
			이름 : <input type="text" name="n_name"><br/>
			비밀번호 : <input type="password" name="n_password"><br/>
			비밀번호 확인 : <input type="password" name="n_password_check"><br/>
			학교 : <select name="n_school">
    				<option value="dongguk">동국대학교</option>
    			  </select><br/>
    		<input type="submit" value="가입">
    		<input type="reset" value="취소">
		</form>
	</div>

	<div class="tabcontent" id="manager" style="display:none;">
		<p>관리자 가입 폼 입니다.</p>
		<form name="manager">
			아이디 : <input type="text" name="userid"><br/>
			이름 : <input type="text" name="name"><br/>
			비밀번호 : <input type="password" name="password"><br/>
			비밀번호 확인 : <input type="password" name="password_check"><br/>
			학교 : <select name="school">
    				<option value="dongguk">동국대학교</option>
    			  </select><br/>
    		<input type="submit" value="가입">
    		<input type="reset" value="취소">
		</form>
	</div>
	
	
	
</body>
</html>