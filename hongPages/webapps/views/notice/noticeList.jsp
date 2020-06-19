<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list"); 
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	Search s = (Search)request.getAttribute("s"); 
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>진홍쓰의 개발자 노트</title>
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
	.column{
		text-align:center;
		font-size:20px;
		font-family:'Times New Roman', Times, serif;
		border-bottom:1px solid black;
	}
</style>

</head>
<body>


	<!-- common 네비 부분 -->
	<!-- 나중에 jsp 스크립트로 잡을 예정 -->
	<%@include file="/views/common/header.jsp"%>

	<div class="row">
		<aside class="col-2"></aside>
		<section class="col-8">
			<br /> <br />
			<h2 style="text-align: center;">개발자 노트</h2>
			<br />
		<div class="row">
    	<div class="mx-auto" id= "tableArea">
        <table id="listArea">
			<tr class="column">
				<th width="100px">글번호</th>
				<th width="300px">글제목</th>
				<th width="150px">작성자</th>
				<th width="100px">조회수</th>
				<th width="150px">작성일</th>
			</tr>
			 <% for(Notice n : list){ %>
			<tr>
				 <td height="40px" align="center"><%= n.getNno() %></td>
           		 <td height="40px" align="center"><%= n.getNtitle() %></td>
           	     <td height="40px" align="center"><%= n.getNwriter() %></td>
           		 <td height="40px" align="center"><%= n.getNcount() %></td>
           		 <td height="40px" align="center"><%= n.getNdate() %></td>
			</tr>
			<% } %>
		</table>
         </div>
	</div>
			
		</section>
		<aside class="col-2"></aside>
	</div>

	<br />
	<%@include file="/views/common/footer.jsp"%>

</body>
</html>