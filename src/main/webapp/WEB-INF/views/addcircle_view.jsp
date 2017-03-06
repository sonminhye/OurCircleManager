<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>

    <div id="top" class="main">
        <div class="text-vertical-center">
            <h2>동아리 검색 , 추가 페이지</h2>
        </div>
    </div>
	    
	<div class="container">
		<div class="row">
	        <div class="col-md-6">
	    		<h2>Custom search field</h2>
	            <div id="custom-search-input">
	                <div class="input-group col-md-12">
	                    <input type="text" class="form-control input-lg" placeholder="Buscar" />
	                    <span class="input-group-btn">
	                        <button class="btn btn-info btn-lg" type="button">
	                            <i class="glyphicon glyphicon-search"></i>
	                        </button>
	                    </span>
	                </div>
	            </div>
	        </div>
		</div>
	</div>
		
<jsp:include page="footer.jsp"></jsp:include> 
</body>
</html>