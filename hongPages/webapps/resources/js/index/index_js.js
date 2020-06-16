/**
 * 수정일자 : 2020.06.16 20:00
 * 
 */

// 시간 표기 
var myVar = setInterval(myTimer, 1000);

function myTimer() {
  var d = new Date();
  var t = d.toLocaleTimeString();
  document.getElementById("mo").innerHTML = t;}

function showClock()
{
    var currentDate=new Date();
    var divClock=document.getElementById("divClock");
    var apm=currentDate.getHours();
    if(apm<12)
    {
        apm="오전";
    }
    else
    {
        apm="오후";
    }
    
    var msg = apm +(currentDate.getHours()-12)+"시";
    msg += currentDate.getMinutes() + "분";
    msg += currentDate.getSeconds() + "초";
    
    divClock.innerText=msg;
    
    setTimeout(showClock,1000);}

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

      pagination: {
        el: '.swiper-pagination',
      },
    });

