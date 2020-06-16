<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>hong_index</title>
    <!-- 부트스트랩 css -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <!-- js min -->
    
    
    <!-- 부트스트랩 js -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

    <!-- swiper dmo-->
    <link rel="stylesheet" href="/hongPages/resources/css/swiper.min.css">
    <script src="/hongPages/resources/js/swiper.min.js"></script>

	<!-- index의 각각 css와 js 위치 -->
 	<link rel="stylesheet" href="/hongPages/resources/css/index/index_css.css">
    <script src="/hongPages/resources/js/index/index_js.js"></script>
    
</head>
<body>

    <!-- 간판 사진 넣는 부분 -->
    <img id="index_img1" src="/hongPages/resources/images/index/code_programming_text_140050_1280x1024.jpg" alt="간판입니다.">
    <p id="pan1"><b>진홍쓰의 홈페이지</b></p>  

    <!-- common 네비 부분 -->
    <!-- 나중에 jsp 스크립트로 잡을 예정 -->
    <div class="row">
        <aside class="col-1 border"></aside>
        <section class="col-10 border">
            네비부분
        </section>
        <aside class="col-1 border"></aside>
    </div>

    <div class="row">
        <aside class="col-1 border"></aside>
        <section class="col-10 border">
            <p id="pan2"><b>어서오세요!<br>진홍쓰의 홈페이지에 오신 것을 환영합니다.</b></p>
              <!-- 시계 부분 --> 
              <div class="row">
                <div class="col">
                    <div onload="showClock()"></div>
                    <div id="mo" class="clock"></div>
                </div>
            </div>
        </section>
        <aside class="col-1 border"></aside>
    </div>

    <!-- swiper 넣는 것은 어떨까? -->
    <div class="swiper-container">
        <div class="swiper-wrapper">
          <div class="swiper-slide" style="background-image:url(/hongPages/resources/images/index/Idontno.jpg)"></div>
          <div class="swiper-slide" style="background-image:url(/hongPages/resources/images/index/itary.jpg)"></div>
          <div class="swiper-slide" style="background-image:url(/hongPages/resources/images/index/siwon.jpg)"></div>
          <div class="swiper-slide" style="background-image:url(/hongPages/resources/images/index/code_programming_text_140050_1280x1024.jpg)"></div>
        <!-- 
          <div class="swiper-slide" style="background-image:url(./images/nature-5.jpg)"></div>
          <div class="swiper-slide" style="background-image:url(./images/nature-6.jpg)"></div>
          <div class="swiper-slide" style="background-image:url(./images/nature-7.jpg)"></div>
          <div class="swiper-slide" style="background-image:url(./images/nature-8.jpg)"></div>
          <div class="swiper-slide" style="background-image:url(./images/nature-9.jpg)"></div>
          <div class="swiper-slide" style="background-image:url(./images/nature-10.jpg)"></div>
        -->
        </div>
        <!-- Add Pagination -->
        <div class="swiper-pagination"></div>
      </div>
      
    <!-- common 몸통 부분 -->
    <div class="row">
        <aside class="col-1 border"></aside>
        <section class="col-10 border">
          
            
        <ul>
            <p>구현 하고 싶은 것들이 무엇이 있을까?</p>
            <li>swiper[회전목마]</li>
            <li>지도api</li>
            <li>날씨api</li>
            <li>댓글기능</li>
            <ul>네비
                <li>지금까지 공부한 내용정리</li>
                <li>게시판</li>
                <li>내용 일지</li>
            </ul>
        </ul>
        </section>
        <aside class="col-1 border"></aside>
    </div>

    
    <!-- common 바닥 부분 -->
  <%@include file="views/common/footer.jsp"%>

</body>

</html>