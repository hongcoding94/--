<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="hide.MemberSystem.model.vo.*"%>

<%
	Member m = (Member)session.getAttribute("member");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Login index</title>

<link
	href="https://fonts.googleapis.com/css?family=Karla:400,700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/hongPages/resources/css/login/login.css">

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</head>
<body>

	<div class="container-fluid" id="loginMember">
		<div class="row">
			<div class="col-sm-6 login-section-wrapper">
				<div class="brand-wrapper">
					<img src="/hongPages/resources/images/login/logo.svg" alt="logo"
						class="logo">
				</div>

				<div class="login-wrapper my-auto" id="loginconsole">
					<h1 class="login-title">로그인을 해주세요!</h1>
					<!-- 아이디 & 비밀번호 넣기위한 창 -->
					<form id="loginForm" action="/hongPages/login.do" method="post">
						<div class="form-group">
							<label for="text">아이디</label> <input type="text" name="userId"
								id="userId" class="form-control" placeholder="email@example.com">
						</div>
						<div class="form-group mb-4">
							<label for="password">비밀번호</label> <input type="password"
								name="userPassWord" id="userPassWord" class="form-control"
								placeholder="enter your passsword">
						</div>
						<input name="login" id="login" class="btn btn-block login-btn"
							type="submit" value="Login">
					</form>

					<!-- 비밀번호 찾기 위한 연결 -->
					<a href="#" class="forgot-password-link" onclick="msg()">비밀번호를
						잊어버리셨나요?</a>

					<!-- 회원가입을 위한 연결 -->
					<p class="login-wrapper-footer-text">
						회원가입이 필요하시나요? &nbsp;<a href="#" id="upMember" class="text-reset">여기를
							눌러주세요.</a>
					</p>

				</div>
			</div>

			<div class="col-sm-6 px-0 d-none d-sm-block">
				<img src="/hongPages/resources/images/login/login.jpg"
					alt="login image" class="login-img">
			</div>
		</div>
	</div>


	<div class="container-fluid" id="nullDefence" style="display: none;">
		<!-- onclick 회원가입창 open -->
		<div class="row">
			<div class="col-sm-6 login-section-wrapper">
				<div class="login-wrapper" id="insertconsole">
					<form action="/hongPages/mInsert.do">
						<div class="form-group">
							<label for="text">아이디</label> <input type="text" name="userId"
								id="insertuserid" class="form-control idCheck"
								placeholder="email@example.com">
						</div>
						<div class="form-group mb-4">
							<label for="password">비밀번호</label> <input type="password"
								name="password" id="password" class="form-control"
								placeholder="enter your passsword">
						</div>
						<div class="form-group mb-4">
							<label for="password">비밀번호 확인</label> <input type="password"
								name="check" id="check" class="form-control"
								placeholder="enter your passsword">
						</div>

						<div class="form-group mb-4">
							<label for="text">이름</label> <input type="text" name="userName"
								class="form-control" placeholder="enter your name">
						</div>
						<div class="form-group mb-4">
							<label for="text">전화번호</label> <input type="text"
								name="userPhone" class="form-control"
								placeholder="010-xxxx-xxxx">
						</div>
						<div class="form-group mb-4">
							<label for="text">주소</label> <input type="text" name="address"
								class="form-control" placeholder="enter your address">
						</div>
						<div class="form-group mb-4">
							<label for="text">나이</label> &nbsp; <select name="userAge"
								style="color: gray;">
								<option value="---">나이선택</option>
								<% for(int i=15; i<60; i++){ %>
								<option value="<%=i%>">
									<%=i%></option>
								<%}%>
							</select> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <label for="text">성별</label>
							&nbsp; <input type="radio" name="gender" checked="checked"
								value="M" /> <span class="up">남자</span> &nbsp;&nbsp; <input
								type="radio" name="gender" value="F" /> <span class="up">여자</span>

						</div>
						<input id="login" class="btn btn-block login-btn" type="submit"
							value="회원가입">

					</form>

				</div>
			</div>
			<div class="col-sm-6 px-0 d-none d-sm-block">
				<img src="/hongPages/resources/images/login/login.jpg"
					alt="login image" class="login-img">
			</div>
		</div>
	</div>

	<script>
  	<!-- 회원가입 전환 -->
  	$(function() {
  	    $("#upMember").on("click", function() {
  	      $("#loginMember").hide(1500);
  	      $("#nullDefence").show("slowly");
  	    });
  	  });
  
  	$("select option[value*='---']").prop('disabled',true);

  	$(".idCheck").on('change', function(){
  		if($(".idCheck").val().trim().length > 0){
			$.ajax({
				url : '/hongPages/idDup.do' , 
				type : 'post' , 
				data : { useridAX : $(".idCheck").val() } , 
				success : function(data){
		
					console.log(data);
					
					if( data == 0 ){
						alert("사용 가능한 아이디입니다.");
						$('.idCheck').css("background-color","skyblue");
					} else {
						alert("이미 사용 중인 아이디입니다.");
						$('.idCheck').css("background-color","yellow");
			  			$(".idCheck").focus();
				}
			} , error : function(){
				console.log("체크 에러 발생.");
			}
			}); 
			
  		} else {
  			alert("아이디를 입력해주세요~!");
  			$(".idCheck").val("");
  			$(".idCheck").focus();
  		}
	});

  	
  	$('input:password[name=check]').on('change', function (){			
		var pw = $('#password').val();
		var chk = $('#check').val();

		if ( pw != '' && chk == '') { 
		} else if (pw != '' || chk != '') {
			if (pw == chk) {
				alert("비밀번호가 일치합니다.");
			} else {						
				alert("비밀번호가 일치하지 않습니다 \n다시한번 확인해주세요.");
			}
		}
	});
  	
  	$('input:password[name=passWord]').on('change', function (){			
		var pw = $('#password').val();
		var chk = $('#check').val();

		if ( pw != '' && chk == '' ) { 
		} else if (pw != '' || chk != '') {
			if (pw == chk) {
				alert("확인되었습니다.");
			} else {						
				alert("비밀번호가 일치하지 않습니다 \n다시한번 확인해주세요.");
			}
		}
	});
	
	function msg() {
		alert("불편을 드려죄송합니다. \n관리자에게 문의하세요!!");	
	};
  	
  </script>
</body>
</html>
