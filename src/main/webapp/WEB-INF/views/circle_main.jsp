<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="main">
<jsp:include page="sidebar.jsp"></jsp:include>
<div class="circle-content">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">Panel heading without title</div>
                        <div class="panel-body">
                            Panel content
                        </div>
                    </div>
                </div>
            </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>