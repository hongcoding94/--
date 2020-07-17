<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="hide.freeBoard.model.vo.*" %>
    
    <%
    	FreeBoard fb = (FreeBoard) request.getAttribute("FreeBoard"); 
    %>

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
	<%@ include file="../common/header.jsp" %>
	<div class="outer">
		<br>
		<h2 align="center"> 자유 게시판 수정</h2>
		<div class="tableArea">
			<form id="updateForm" method="post">
				<table  style="margin:auto;">
					<tr>
						<td>제목</td>
						<td colspan="3">
							<input type="text" size="50" name="Ftitle" 
							       value='<%= fb.getFtitle().replace("\"", "&#34;") %>'>
							<input type="hidden" name="Fno" value="<%= fb.getFno() %>">
						</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td>
							<input type="text" value="<%= fb.getFwriter() %>" name="Fwriter" readonly>
						</td>
						<td>작성일</td>
						<td><input type="date" name="date" value="<%= fb.getFdate() %>"></td>
					</tr>
					<tr>
						<td>내용 </td>
					</tr>
					<tr>
						<td colspan="4">
							<textarea name="Fcontent" cols="60" rows="15" style="resize:none;"><%= fb.getFcontent() %></textarea>
						</td>
					</tr>
				</table>
				<br>
				<div align="center">
					<button onclick="complete();">작성완료</button>
					<button onclick="deleteNotice();">삭제하기</button>
				</div>
				
				<script>
					function complete(){
						$("#updateForm").attr("action","<%=request.getContextPath() %>/fUpdate.do");
						
					}
					
					function deleteNotice(){
						// delete 는 예약어 이므로 deleteNotice 로 ...!
						$("#updateForm").attr("action","<%=request.getContextPath() %>/fDelete.do");
					}
				</script>
				</form>
				
				</div>
				</div>
				
		<%@include file="../common/footer.jsp" %>
</body>
</html>