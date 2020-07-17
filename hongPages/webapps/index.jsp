<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>hong_index</title>
    <!-- 부트스트랩 css -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <!-- 부트스트랩 js -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

	<!-- index의 각각 css와 js 위치 -->
 	<link rel="stylesheet" href="/hongPages/resources/css/index/index_css.css">
    <script src="/hongPages/resources/js/index/index_js.js"></script>

    <!-- swiper dmo-->
    <link rel="stylesheet" href="/hongPages/resources/css/swiper.min.css">
    <script src="/hongPages/resources/js/swiper.min.js"></script>

	<!--  header css -->
    <link rel="stylesheet" href="/hongPages/resources/css/common/header.css">
    
    
    <!-- kakao 지도 API -->
<!-- 	<script type="text/javascript" src="http://dapi.kakao.com/v2/maps/sdk.js?appkey=9037a93d86da722dcec43acbc7096741"></script> -->
	<script type="text/javascript" src="/hongPages/resources/js/kakao-map.js"></script>
    
    <style>
    /*Swiper*/
        body {
        background: #fff;
        font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
        font-size: 14px;
        color:#000;
        margin: 0;
        padding: 0;
        }
        
        .swiper-container {
        width: 100%;
        padding-top: 50px;
        padding-bottom: 50px;
        }
        
        .swiper-slide {
        background-position: center;
        background-size: cover;
        width: 300px;
        height: 300px;
        /* 이미지 확대 */
        animation: trans2;
		animation-duration: 3s;
		animation-iteration-count: 1;
		transition-duration: 0.2s;
		/* transition-timing-function : ease-in; */
		transition-timing-function: ease-out;
		border-radius: 7%;
        }
        
    </style>
    
</head>
<body>

    <!-- common 네비 부분 -->
    <!-- 나중에 jsp 스크립트로 잡을 예정 -->
    <%@include file="views/common/header.jsp"%>

    <div class="row">
        <aside class="col-1"></aside>
        <section class="col-10">
        <br />
            <p id="pan2" style="z-index:-1;"><b>어서오세요!<br>진홍쓰의 홈페이지에 오신 것을 환영합니다.</b></p>
              <!-- 시계 부분 --> 
              <div class="row">
                <div class="col">
                    <div onload="showClock()"></div>
                    <div id="mo" class="clock"></div>
                </div>
            </div>
        </section>
        <aside class="col-1"></aside>
    </div>

    <!-- swiper 넣는 것은 어떨까? -->
    <div class="swiper-container">
        <div class="swiper-wrapper" style="height:300px">
          <div class="swiper-slide" style="background-image:url(/hongPages/resources/images/index/Idontno.jpg)"></div>
          <div class="swiper-slide" style="background-image:url(/hongPages/resources/images/index/itary.jpg)"></div>
          <div class="swiper-slide" style="background-image:url(/hongPages/resources/images/index/siwon.jpg)"></div>
          <div class="swiper-slide" style="background-image:url(/hongPages/resources/images/index/code_programming.jpg)"></div>
          <div class="swiper-slide" style="background-image:url(/hongPages/resources/images/index/castle.jpg)"></div>
          <div class="swiper-slide" style="background-image:url(/hongPages/resources/images/index/bridge.jpg)"></div>
        </div>
        <!-- Add Pagination -->
        <div class="swiper-pagination"></div>
      </div>
      
      
    <!--  몸통 part.1 부 -->
      
   	<div class="row">
   	<aside class="col-1"></aside>
   	<section class="col-10" style=" text-align: center;">
   		<br />
   		<input type="button" id="btnVideo" onclick="openvideo()" value="Just do it!"> 
   		<br />(눌러보세요)
   		<br /> <br />
   		<iframe width="1000px" height="600px" id="video"
   		src="https://www.youtube.com/embed/RPSp1TE6R2s" frameborder="0" style="display: none;"
   		allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
   		
   		<br /> <br /> <br />
   	</section>
   	<aside class="col-1"></aside>
   	</div>  
      
     
    <div class="row">
    
    
    </div>
     
      
      
    <!--  몸통part.3 부분 -->
    <div class="row">
        <aside class="col-1"></aside>
        <section class="col-10" style="margin:atuo;">
        <div class="row">
       		<div class="col-7">
       			<div id="map" style="width:100%;height:500px; margin:auto;"></div>
       		</div>
       		<div class="col-3" style="margin:auto;">
       				<h2>KH 정보 교육원</h2>
       				<p class="pen">연락처 : 02) 1544 - 9970</p>
       				<p class="pen">주소 : 서울특별시 강남구 강남구 테헤란로14길 6</p>
       				<p class="pen">영업 시간 : AM 09:00 - PM 22:00</p>
       				<p class="pen">지도강사님 : 유정훈 강사님</p>
       				<p class="pen">개발자 : 정진홍 수강생</p>
       				<p class="pen">강의실 : 352강의실</p>
       		</div>
       		</div>
        </section>
        <aside class="col-1"></aside>
    </div>

    
  <script>
  //swiper
  var swiper = new Swiper('.swiper-container', {
        effect: 'coverflow',
        grabCursor: true,
        centeredSlides: true,
        slidesPerView: 'auto',
        coverflowEffect: {
          rotate: 50,
          stretch: 0,
          depth: 100,
          modifier: 1,
          slideShadows : true,
          
        },
		autoplay : {
			delay : 2500
		}, 
        pagination: {
          el: '.swiper-pagination',
        },
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
      });
  
  //swiper를 자동으로 돌아가게 하는 구조
  //var swiper = new Swiper('.swiper-container', {
  //    slidesPerView: 5,
  //    effect: 'coverflow',
  //   centeredSlides: true,
  //    slidesPerView: 'auto',
  //    autoplay: {
  //        delay: 2500,
  //        disableOnInteraction: false,
  //    },
  //    navigation: {
  //        nextEl: '.swiper-button-next',
  //        prevEl: '.swiper-button-prev',
  //    },    
  //});
  
	
   // 지도 API
   var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
   var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(37.499220, 127.032796), //지도의 중심좌표. 
	level: 3 //지도의 레벨(확대, 축소 정도)
	};
   
   // 지도를 표시할 div와 지도 옵션으로 지도를 생성합니다
   var map = new kakao.maps.Map(container, options); 
   
   // 지도에 표시할 마커 생성
   var markerPosition = new kakao.maps.LatLng(37.499220, 127.032796);
   
   var marker = new kakao.maps.Marker({
	    position: markerPosition
	});
   
   marker.setMap(map);
  
	
   </script>
    
    
    <!-- common 바닥 부분 -->
  <%@include file="views/common/footer.jsp"%>

</body>

</html>