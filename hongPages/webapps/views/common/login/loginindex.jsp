<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="hide.MemberSystem.model.vo.*" %>

<%
	Member m = (Member)session.getAttribute("member");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Login index</title>
  
  <link href="https://fonts.googleapis.com/css?family=Karla:400,700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="/hongPages/resources/css/login/login.css">

  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</head>
<body>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-6 login-section-wrapper">
          <div class="brand-wrapper">
            <img src="/hongPages/resources/images/login/logo.svg" alt="logo" class="logo">
          </div>
          <div class="login-wrapper my-auto">
            <h1 class="login-title">로그인을 해주세요!</h1>
            
            <!-- 아이디 & 비밀번호 넣기위한 창 -->
            <form id="loginForm" action="/hongPages/login.do" method="post">
              <div class="form-group">
                <label for="text">아이디</label>
                <input type="text" name="userId" id="userId" class="form-control" placeholder="email@example.com">
              </div>
              <div class="form-group mb-4">
                <label for="password">비밀번호</label>
                <input type="password" name="userPwd" id="password" class="form-control" placeholder="enter your passsword">
              </div>
              <input name="login" id="login" class="btn btn-block login-btn" type="submit" value="Login">
            </form>
            
            <!-- 비밀번호 찾기 위한 연결 -->
            <a href="#!" class="forgot-password-link">비밀번호를 잊어버리셨나요?</a>
          	
          	<!-- 회원가입을 위한 연결 -->  
            <p class="login-wrapper-footer-text">회원가입이 필요하시나요? &nbsp;<a href="#!" class="text-reset">여기를 눌러주세요.</a></p>
          
          </div>
        </div>
        <div class="col-sm-6 px-0 d-none d-sm-block">
          <img src="/hongPages/resources/images/login/login.jpg" alt="login image" class="login-img">
        </div>
      </div>
    </div>
 
  <script>
  /* 
  function login(){
		$('#loginForm').submit();
	}
  */  
  </script>
</body>
</html>
