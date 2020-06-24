<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="hide.notice.model.vo.*"%>
<%
	Notice n = (Notice)request.getAttribute("notice");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 부트스트랩 css -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<!-- js min -->
<!--     <script src="/resources/js/jquery-3.5.1.min.js"></script>
 -->
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

<!-- index의 각각 css와 js 위치 -->
<link rel="stylesheet"
	href="/hongPages/resources/css/index/index_css.css">

<!-- swiper dmo-->
<link rel="stylesheet" href="/hongPages/resources/css/swiper.min.css">
<script src="/hongPages/resources/js/swiper.min.js"></script>

<!--  header css -->
<link rel="stylesheet" href="/hongPages/resources/css/common/header.css">

<style>
	.outer{
		width:800px;
		height:500px;
		color:white;
		border: 1px solid black;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
	}
	.tableArea > table {
		width: 650px;
		padding: 20px;
		color: black;
	}

	.tableArea {
		width:650px;
		height:350px;
		margin:auto;
	}

	table tr td{
		padding-top: 17px;
	}
</style>
<title>공지 사항 내용</title>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	<div class="outer">
		<br>
		<h2 align="center">공지 사항 내용</h2>
		<div class="tableArea">
				<table>
					<tr>
						<td>제목 : </td>
						<td colspan="3"><%= n.getMtitle() %></td>
					</tr>
					
					<tr>
						<td>작성자 :</td>
						<td>
							<%= n.getMwriter() %>
						</td>
						<td>작성일 : </td>
						<td><%= n.getMdate() %></td>
					</tr>
					<tr>
						<td>내용 </td>
					</tr>
					<tr>
						<td colspan="4"><br>
							<span><%= n.getMcontent().charAt(0) %></span><%= n.getMcontent().substring(1) %>
						</td>
					</tr>
				</table>
				<br>
				<div align="center">
					
					<button onclick="location.href='searchNotice.do'">메뉴로 돌아가기</button>

					<% if( m != null && m.getUserId().equals("admin")) { %>
						<button onclick="location.href='nUpView.no?nno=<%=n.getMno()%>'">수정하기</button>
					<% } %>
				</div>
		</div>
	</div>
	<%@ include file="../common/footer.jsp" %>
</body>
</html>