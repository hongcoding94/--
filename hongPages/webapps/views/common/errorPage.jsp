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
    <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<!-- 부트스트랩 js -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>

<!--  header css -->
<link rel="stylesheet" href="/hongPages/resources/css/common/header.css">
    
    
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