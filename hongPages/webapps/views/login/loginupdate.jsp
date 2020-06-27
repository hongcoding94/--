<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="hide.MemberSystem.model.vo.*"%>

<%
	Member m = (Member)session.getAttribute("member");
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Login Template</title>
  <link href="https://fonts.googleapis.com/css?family=Karla:400,700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="/hongPages/resources/css/login/loginupdate.css">
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
  <main class="d-flex align-items-center min-vh-100 py-3 py-md-0">
    <div class="container">
      <div class="card login-card">
        <div class="row no-gutters">
          <div class="col-md-5">
            <img src="/hongPages/resources/images/login/loginupdate.jpg" alt="login" class="login-card-img">
          </div>
          <div class="col-md-7">
            <div class="card-body">
              <p class="login-card-description">"<%= m.getUserName() %>"님의 정보 수정</p>
              <form action="/hongPages/mUpdate.do">
                  <div class="form-group" style="float: right;">
                    <label for="password" style="margin-left: auto;">비밀번호</label> &nbsp;
                    <input type="password" name="userPassWord" id="userPassWord" class="form-control" 
                    style="width: 240px; display:inline; text-align:right;" placeholder="enter your Password">
                  </div>
                  <div class="form-group">
                    <label for="text" >나이</label> &nbsp;
                    <select name="userAge" style="color:gray;">
               		<option value="---">---</option>
               		<% for(int i=15; i<60; i++){ %>
               		<option value="<%=i%>"> <%=i%></option>
               		<%}%>
               	</select>
                    &nbsp; 
                    <label for="text" >전화번호</label> &nbsp;
                    <input type="text" name="userPhone" id="userPhone" class="form-control" 
                    style="width: 160px; display:inline; text-align:right;" placeholder="010-****-****">
                  </div>
                  <div class="form-group" style="float: right;">
                    <label for="text" >주소</label> &nbsp;
                    <input type="text" name="address" id="Address" class="form-control" 
                    style="width: 260px;  display:inline; text-align:right;" placeholder="enter your address">
                  </div>
                  <input name="mupdate" id="mupdate" class="btn btn-block login-btn mb-4" type="submit" value="회원정보 수정">
                </form>
            </div>
          </div>
        </div>
      </div>
      
    </div>
  </main>
</body>
  <script>
    <!-- select>option의 --- 다시 선택하지 못 하도록 하기 -->
    $("select option[value*='---']").prop('disabled',true);
    
  </script>
</html>
