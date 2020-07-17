<%@page import="java.sql.Date"%>
<%@page import="oracle.sql.DATE"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, hide.notice.model.vo.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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

<!--  header css -->
<link rel="stylesheet" href="/hongPages/resources/css/common/header.css">



</head>
<body>

	<%@include file="/views/common/header.jsp"%>

	 <br />
		<h2 align="center">공지 사항 수정</h2>
		<br />

		<div class="tableArea">
		<form action="<%= request.getContextPath() %>/nInsert.do"
			method="post">
			<table align="center">
				<tr>
					<td>제목</td>
					<td colspan="3"><input type="text" size="50" name="mtitle"></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="userId" value="<%= m.getUserId() %>"
						readonly="readonly"></td>
						
					<td>날짜</td>
					<td><input type="date" name="date" readonly="readonly"></td>
				</tr>
				
				<tr>
					<td>내용</td>
				</tr>
				<tr>
					<td colspan="4"><textarea name="mcontent" cols="60" rows="15"
							style="resize: none;"></textarea></td>
				</tr>
			</table>
			<br>
			<div align="center">
				<button type="submit">등록하기</button>
				&nbsp;&nbsp;
				<button type="button" onclick="noticeHome();">취소하기</button>
				</div>
		</form>
			
		<%@include file="/views/common/footer.jsp"%>
			</div>
		<script>
		$( function() {
		    var now = new Date();
		    var month = (now.getMonth() + 1);               
		    var day = now.getDate();
		    if (month < 10) 
		        month = "0" + month;
		    if (day < 10) 
		        day = "0" + day;
		    var today = now.getFullYear() + '-' + month + '-' + day;
		    $('[name=date]').val(today);
		});
		
		function noticeHome(){
			location.href="<%=request.getContextPath()%>/searchNotice.do";
		}
		</script>
	
</body>
</html>