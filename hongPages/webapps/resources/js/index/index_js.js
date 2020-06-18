/**
 * 수정일자 : 2020.06.16 20:00
 * 
 */

// 시간 표기 
var myVar = setInterval(myTimer, 1000);

function myTimer() {
  var d = new Date();
  var t = d.toLocaleTimeString();
  document.getElementById("mo").innerHTML = t;};

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
    
    setTimeout(showClock,1000);};

// openVideo 실행시 video의 show,hide 대한 jquery
    function openvideo(){
    	if($("#video").css("display") == "none"){
    		$("#video").show();
    		// conslo.log(this); --> this로 했을 때 찾지 못한다.
    	}else{
    		$("#video").hide();
    	};
    };

// 어서오세요! 부분타이머 후 사라지
    setTimeout(function(){
    	$('#pan2').hide("slow")
    },5000);