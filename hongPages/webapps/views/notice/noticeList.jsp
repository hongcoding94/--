<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, hide.notice.model.vo.*, hide.common.PageInfo, hide.common.Search"%>

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
.column {
	text-align: center;
	font-size: 20px;
	font-family: 'Times New Roman', Times, serif;
	border-bottom: 1px solid black;
}

#header_board {
	border-bottom: 1px solid black;
}

</style>

</head>
<body>

	<!-- common 네비 부분 -->
	<!-- 나중에 jsp 스크립트로 잡을 예정 -->
	<%@include file="/views/common/header.jsp"%>
	
<% String pageURL =   request.getContextPath() + "/searchNotice.do?con=" + s.getCondition() + "&keyword=" + s.getKeyword() + "&currentPage="; %>
		
	<div class="row center">
		<aside class="col-3"></aside>
		<section class="col-6">
			<br /> <br />
			<div class="outer">
				<br>
				<h2 align="center">개발자 노트</h2>
				<div class="tableArea">
					<br /> <br />
					<table style="text-align: center;" id="listArea">
						<tr id="header_board">
							<th width="80px">글번호</th>
							<th width="400px">글제목</th>
							<th width="200px">작성자</th>
							<th width="80px">조회수</th>
							<th width="200px">작성일</th>
						</tr>
						<%
							for (Notice n : list) {
						%>
						<tr style="font-size: 18px;">
							<td><b><%=n.getMno()%></b></td>
							<td><%=n.getMtitle()%></td>
							<td><%=n.getMwriter()%></td>
							<td><%=n.getMcount()%></td>
							<td><%=n.getMdate()%></td>
						</tr>
						<%
							}
						%>
					</table>
					<br /> <br />
					<div class="searchArea" align="center">
						<select id="searchCondition" name="searchCondition">
							<option value="---">---</option>
							<option value="writer">작성자</option>
							<option value="title">제목</option>
							<option value="content">내용</option>
						</select> 
						<input type="text" id="keyword" placeholder="키워드를 입력하세요!"/> 
						<button type="button" onclick="search();">검색하기</button>
						
							<% if(m != null && m.getUserId().equals("admin")){ %>
						<button onclick="location.href='/hongPages/views/notice/noticeInsertFrom.jsp'">작성하기</button>
							<% } %>
							
					</div>
				</div>
			</div>
			<br />

		</section>
		<aside class="col-3"></aside>
	</div>

	
<div class="pagingArea" align="center">
			<button onclick="location.href='<%= pageURL %>1'"><<</button>
			<%  if(currentPage <= 1){  %>
			<button disabled><</button>
			<%  }else{ %>
			<button onclick="location.href='<%= pageURL  +(currentPage - 1) %>'"><</button>
			<%  } %>
			
			<% for(int p = startPage; p <= endPage; p++){
					if(p == currentPage){	
			%>
				<button disabled><%= p %></button>
			<%      }else{ %>
				<button onclick="location.href='<%= pageURL  +  p %>'"><%= p %></button>
			<%      } %>
			<% } %>
				
			<%  if(currentPage >= maxPage){  %>
			<button disabled>></button>
			<%  }else{ %>
			<button onclick="location.href='<%= pageURL  +(currentPage + 1) %>'">></button>
			<%  } %>
			<button onclick="location.href='<%= pageURL  + maxPage %>'">>></button>	
		</div>
		

	<br />

	<script>
		$("select option[value='---']").prop('disabled', true);
		
		$(function(){
		$("#listArea td").mouseenter(function(){
			$(this).parent().css({"background" : "lightgray", "cursor" : "pointer"});
		}).mouseout(function(){
			$(this.parent().css({"background" : "white"}));
		}).click(function(){
			var mno = $(this).parent().children().eq(0).text();
		location.href="<%=request.getContextPath()%>/selectOne.do?mno=" +mno;
			});
		});
	
		function search(){
			location.href="<%=request.getContextPath()%>/searchNotice.do?con="+$('#searchCondition').val()+"&keyword="+$('#keyword').val();
		}	
	</script>

	<%@include file="/views/common/footer.jsp"%>

</body>
</html>