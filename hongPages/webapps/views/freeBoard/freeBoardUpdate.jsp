<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="hide.freeBoard.model.vo.*" %>
    
    <%
    	FreeBoard fb = (FreeBoard) request.getAttribute("freeBoard"); 
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	<div class="outer">
		<br>
		<h2 align="center"> 자유 게시판 수정</h2>
		<div class="tableArea">
			<form id="updateForm" method="post">
				<table>
					<tr>
						<td>제목 </td>
						<td colspan="3">
							<input type="text" size="50" name="title" 
							       value="<%= fb.getFtitle().replace("\"", "&#34;") %>">
							<input type="hidden" name="nno" value="<%= fb.getFno() %>">
						</td>
					</tr>
					<tr>
						<td>작성자 </td>
						<td>
							<input type="text" value="<%= fb.getFwriter() %>" name="writer" readonly>
						</td>
						<td>작성일</td>
						<td><input type="date" name="date" value="<%= fb.getFdate() %>"></td>
					</tr>
					<tr>
						<td>내용 </td>
					</tr>
					<tr>
						<td colspan="4">
							<textarea name="content" cols="60" rows="15" style="resize:none;"><%= fb.getFcontent() %></textarea>
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
						$("#updateForm").attr("action","<%=request.getContextPath() %>/nUpdate.do");
						
					}
					
					function deleteNotice(){
						// delete 는 예약어 이므로 deleteNotice 로 ...!
						$("#updateForm").attr("action","<%=request.getContextPath() %>/nDelete.do");
					}
				</script>
				</form>
				
				</div>
				</div>
				
		<%@include file="../common/footer.jsp" %>
</body>
</html>