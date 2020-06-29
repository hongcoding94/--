<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="hide.MemberSystem.model.vo.*"%>

<%
   Member m = (Member)session.getAttribute("member");
%>

<header>

	<!-- 회원바 -->
<div class="row">
	<nav class="top-bar navbar-expand-sm bg-secondary" id="test1">
		<div class="container">
			<div class="row" id="vc">
				<div class="col-12" id="test">
					<ul class="navbar-nav ml-auto">

						<%if ( m == null ) { %>
						<li style="margin-left: auto;"><a
							class="link" href="/hongPages/views/login/loginindex.jsp"
							aria-haspopup="true" aria-expanded="false"
							data-target="#loginFormBtnGo"
							style="display: inline; color: white; font-size:14px;"> 로그인 </a></li>
						
						<% } else { %>
						
						<li class="nav-item dropdown" style="margin-left: auto;">
							
						<a class="nav-link" style="display:inline; color: white;  font-size:14px;"><b><%= m.getUserName() %></b>님 환영합니다.</a>
							 <a class="nav-link" href="#"
							style="display:inline; color: white; font-size:14px;" onclick="changeInfo();">마이페이지
						</a> <a class="nav-link" href="#"
							style="display:inline; color: white; font-size:14px;" onclick="logoutBtn();">로그아웃
						</a>

						</li>
						<% } %>
					</ul>
				</div>
			</div>
		</div>
	</nav>
	</div>


	<!-- 간판 사진 넣는 부분 -->
	<a href="/hongPages/index.jsp"> <img id="index_img1"
		src="/hongPages/resources/images/index/code_programming.jpg"
		alt="간판입니다.">
	</a>
	<p id="pan1">
		<b>진홍쓰의 홈페이지</b>
	</p>

	<ul class="nav">
		<li><a href="/hongPages/index.jsp">Home</a></li> 
		&nbsp; &nbsp; &nbsp; &nbsp;
		&nbsp; &nbsp; &nbsp; &nbsp;

		<li><a href="/hongPages/searchNotice.do">개발자 노트</a></li>

		<li>
			<a href="/hongPages/searchfreeBoard.do"> 자유 게시글 </a>
		</li>

		<li><a href="#"> 홍쓰 추천 </a>
			<!-- 
			<ul>
				<li><a href="#">추천 음식</a></li>
				<li><a href="#">추전 장소</a></li>
				<li><a href="#">추천 여행</a></li>
				<li><a href="#">추천 레져스포츠</a></li>
			</ul>
			 -->	
			<ul>
				<li><a href="#">불편을<br>드려죄송합니다<br>빠른시일내에<br>찾아뵙겠습니다.</a></li>
			</ul>
		</li>

		<li><a href="#">개발자 프로필</a></li>

		<li><a href="#">홈페이지 바로가기</a>
			<ul>
				<li><a href="https://www.google.com" target="_black">Google</a></li>
				<li><a href="https://www.naver.com" target="_black">네이버</a></li>
				<li><a href="https://www.youtube.com" target="_black">Youtube</a></li>
				<li><a href="https://www.daum.net" target="_black">다음</a></li>
				<li><a href="https://www.w3schools.com/" target="_black">w3schools</a></li>
				<li><a href="http://guny.kr/stuff/klorem/" target="_black">임시글생성기</a></li>
				<li><a href="https://codepen.io/" target="_black">Codepen</a></li>
				<li><a href="https://iei.or.kr/main/main.kh" target="_black">kh정보교육원</a></li>
				<li><a href="https://www.webfx.com/web-design/color-picker/"
					target="_black">WebFX</a></li>
				<li><a href="https://flukeout.github.io/#" target="_black">문제풀어보기</a></li>
			</ul></li>

	</ul>
	
	<script>
	<!-- 로그인 홈으로 -->
	function logoutBtn(){
			
			var conf = confirm('떠나실건가요..........?')

			if(conf == true) {
				location.href="/hongPages/logout.do";
			} else {
				return false;
			}
	}	
	<!-- 회원정보 수정홈으로 이동 -->
	function changeInfo(){
		location.href="/hongPages/views/login/loginupdate.jsp";
	}	
	
	</script>

</header>