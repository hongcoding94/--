<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, hide.notice.model.vo.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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


</head>
<body>

	<%@include file="/views/common/header.jsp"%>

	<div class="row">
		<form action="<%= request.getContextPath() %>/mInsert.do"
			method="post">
			<table align="center">
				<tr>
					<td>제목</td>
					<td colspan="3"><input type="text" size="50" name="title"></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="writer" value="작성"
						readonly="readonly"></td>
				</tr>
				<tr>
					<td>내용</td>
				</tr>
				<tr>
					<td colspan="4"><textarea name="content" cols="60" rows="15"
							style="resize: none;"></textarea></td>
				</tr>
			</table>
			<br>
			<div align="center">
				<button type="submit">등록하기</button>
				&nbsp;&nbsp;
				<button type="reset"
					onclick="location.href='/baseball/views/notice/noticeList.jsp'">취소하기</button>

			</div>

		</form>

		<aside class="col-3"></aside>
		<section class="col-6"></section>
		<aside class="cpl-3"></aside>

		<%@include file="/views/common/footer.jsp"%>
	</div>
</body>
</html>