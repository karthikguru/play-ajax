function sayHello(){
	var name = "karthik";
	alert("before request");
	myJsRoutes.controllers.Application.hello(name).ajax({
		success: function(data){
			alert("sucess");			
		}
		
		error : function(){
			alert("error");
		}
	});
	}
}