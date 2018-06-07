$(function(){
	//商户登录
	$('.merchant_tab').click(function(){
		$(this).addClass('this').siblings().removeClass('this');
		$('.phone').hide();
		$('.merchant').show();
	}); 
	
	//手机登录
	$('.phone_tab').click(function(){
		$(this).addClass('this').siblings().removeClass('this');
		$('.merchant').hide();
		$('.phone').show();
	});
	
	//手机扫二维码登录
	$(".phonecode").toggle(function(){
	    $('.content,.use_tab').hide();
	    $('.codebox').show();
	   	$('.phonecode').addClass('comp');
	},function(){
	   $('.content,.use_tab').show();
	   $('.phonecode').removeClass('comp');
	   $('.codebox').hide();	   
	});

	//记住密码
	$('.remember>em').click(function(){
		$(this).toggleClass('cur');
	});
	//删除输入
	$(".put input").keydown(function(){
		var keyword = $(this).val();		
	    if (keyword.length > 0 && keyword != "") {
	            $(this).next('i').show();
		    }else{
		        $(this).next('i').hide();
		   }	    
	});
	$(".put>div>i").click(function(){
		$(this).prev('input').val('');
		$(this).hide();
	});
});

