<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>회원가입</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>

<!-- <div class="wrapper"> -->
	<div id="exTab2" class="container">
		<ul class="nav nav-tabs">
			<li class="active">
				<a href="#n" data-toggle="tab">일반회원</a>
			</li>
			<li>
				<a href="#m" data-toggle="tab">관리자</a>
			</li>
		</ul>
			<div class="tab-content">
				<div id="n"  class="tab-pane active">
				<form>
				<p>일반 회원 가입 폼 입니다.</p>
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
			</div> <!-- normal form close -->

			<div id="m" class="tab-pane">
				<form>
				<p>관리자 가입 폼 입니다.</p>
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
			</div> <!-- manager form close -->
		</div> <!-- tab-content class close -->
	</div> <!-- tab class close -->
<!-- </div> wrapper class close-->
<jsp:include page="footer.jsp"></jsp:include>	
	
</body>
</html>