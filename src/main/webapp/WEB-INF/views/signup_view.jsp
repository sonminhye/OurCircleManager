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

<div class="wrapper">
	<div id="tabs">
		<ul class="nav nav-tabs" >
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
					<div class="form-group">
						<label for="idinput">아이디</label>
						<input type="text" name="n_userid" class="form-control" placeholder="아이디">
					</div>
					<div class="form-group">
						<label for="nameinput">이름</label>
						<input type="text" name="n_name" class="form-control" placeholder="이름">
					</div>
					<div class="form-group">
						<label for="passwordinput">비밀번호</label>
						<input type="text" name="n_password" class="form-control" placeholder="숫자,특수문자 포함 8자이상">
					</div>
					<div class="form-group">
						<label for="nameinput">비밀번호 확인</label>
						<input type="text" name="n_password_check" class="form-control" placeholder="비밀번호와 똑같이 입력해주세요">
					</div>
					<div class="form-group">
						<label for="nameinput">학교</label>
						<select name="n_school"  class="form-control">
		    					<option value="dongguk">동국대학교</option>
		    			  </select>
					</div>
					<input type="submit" value="가입" class="btn btn-primary btn-block">
			</form>
			
			</div> <!-- normal form close -->

			<div id="m" class="tab-pane">
			<form>
					<div class="form-group">
						<label for="idinput">아이디</label>
						<input type="text" name="m_userid" class="form-control" placeholder="아이디">
					</div>
					<div class="form-group">
						<label for="nameinput">이름</label>
						<input type="text" name="m_name" class="form-control" placeholder="이름">
					</div>
					<div class="form-group">
						<label for="passwordinput">비밀번호</label>
						<input type="text" name="m_password" class="form-control" placeholder="숫자,특수문자 포함 8자이상">
					</div>
					<div class="form-group">
						<label for="nameinput">비밀번호 확인</label>
						<input type="text" name="m_password_check" class="form-control" placeholder="비밀번호와 똑같이 입력해주세요">
					</div>
					<div class="form-group">
						<label for="nameinput">학교</label>
						<select name="m_school"  class="form-control">
		    					<option value="dongguk">동국대학교</option>
		    			  </select>
					</div>
					<input type="submit" value="가입" class="btn btn-primary btn-block">
			</form>
				
			</div> <!-- manager form close -->
		</div> <!-- tab-content class close -->
	</div> <!-- tab class close -->
</div> <!-- wrapper class close -->
<jsp:include page="footer.jsp"></jsp:include>	
	
</body>
</html>