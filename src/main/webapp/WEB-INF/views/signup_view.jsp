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
				<table>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="n_userid" class="form-control" placeholder="아이디를 입력해주세요"></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" name="n_name"  class="form-control"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="n_password" class="form-control"></td>
					</tr>
					<tr>
						<td>비밀번호 확인 </td>
						<td><input type="password" name="n_password_check" class="form-control"></td>
					</tr>
					<tr>
						<td>학교 </td>
						<td>
							<select name="n_school"  class="form-control">
		    					<option value="dongguk">동국대학교</option>
		    			  </select>
						</td>
					</tr>
					<tr >
						<td colspan="2">
							<input type="submit" value="가입" class="btn btn-primary btn-block">
						</td>			
		    		</tr>
				</table>
			</form>
			
			</div> <!-- normal form close -->

			<div id="m" class="tab-pane">
				<form>
				<table>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="userid"  class="form-control" placeholder="아이디를 입력해주세요"></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" name="name" class="form-control"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="password" class="form-control"></td>
					</tr>
					<tr>
						<td>비밀번호 확인 </td>
						<td><input type="password" name="password_check" class="form-control"></td>
					</tr>
					<tr>
						<td>학교 </td>
						<td>
							<select name="school"  class="form-control">
		    					<option value="dongguk">동국대학교</option>
		    			  </select>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="가입" class="btn btn-primary btn-block">
		    			</td>
		    		</tr>
				</table>
				</form>
			</div> <!-- manager form close -->
		</div> <!-- tab-content class close -->
	</div> <!-- tab class close -->
</div> <!-- wrapper class close -->
<jsp:include page="footer.jsp"></jsp:include>	
	
</body>
</html>