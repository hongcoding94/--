<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%
	String msg = (String)request.getAttribute("error-msg");
	Exception e = (Exception)request.getAttribute("exception");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Service errorPage</title>
    <link rel="stylesheet" href="/hongPages/resources/css/index/errorPage.css">
    
    
<style>
.outer{
		padding: 20px;
		width:600px;
		height:500px;
		color:black;
		text-align:center;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
		background:skyblue;
		transition-timing-function: ease-out;
		border-radius: 7%;
}

</style>

</head>
<body>
<%@ include file="../common/header.jsp" %>
	<div class="outer">
		<h1>서비스 에러 발생!!!</h1>
		<br /><h3 style="color:red;">What is the error? 
		<br /><%= e.getMessage() %></h3><br />
		<h4>서비스 수행 중 에러가 발생했습니다. <br />
		담당자에게 연락하시기 바랍니다.</h4>
		<br /> <br /> <br />
	<a href="/hongPages/index.jsp"><input type="button" value="메인으로 돌아가기" ></a>
	</div>
	
	
<%@ include file="../common/footer.jsp" %>
</body>
</html>