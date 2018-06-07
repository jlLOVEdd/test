
$(function(){
	
	var url=contextPath+"/employeeContraller/getCookiePwd";
	
	$(document).on("blur","input[name='loginUserName']", function(){
		var name=$(this).val();
		if(name.length>0){
			var params = "loginUserName="+name;
			$.post(
	                url,        
	                params,     
	                function (data){ 
	                  if(data.success){
	                	  $("input[name='password']").val(data.pwd);
	                	  $("input[name='autoPwd']").val("1");   
	                  }
	                  else{
	                	 
	                  }
	                },
	               'json'
	            ); 
		}
		
		
        });
	
	$(document).on("change","input[name='password']", function(){
		$("input[name='autoPwd']").val("0");     
    });
      

});

