function selectHelloMethod(){
	var name=$('#username').val();
	var userSelect = Number($('#selectMethod').val());
	
	switch(userSelect){
	case 1:
		sayJsRoutesHello(name);
		break;
	case 2:
		sayAjaxGetHello(name);
		break;
	case 3:
		sayAjaxPostHello(name);
		break;
	case 4:
		sayJsonHello(name);
		break;
	case 5:
		sayAjaxPlainHello(name);
		break;
	default:
		sayAjaxGetHello(name);
		break;
	}
}

function sayJsRoutesHello(name){
	//alert("inside sayJsRoutesHello()");
	myJsRoutes.controllers.Application.hello(name).ajax({
		success: function(data){
			$('#sayHello').text(data);			
		}
	});	
}


function sayAjaxGetHello(name){
	//alert("inside sayAjaxGetHello()");
	$.get('/hello',
		  {'name':name},
			function(data){
			  $('#sayHello').text(data);
		  });
}

function sayAjaxPlainHello(name){
	$.ajax({url:'/ajax',
			type: 'GET',
		    data:{name : name},
		    success: function(data){
			      $('#sayHello').text(data);
		    },
		    error: function(jqXHR, textStatus, errorThrown){
			      $('#sayHello').text(textStatus + " from error");
		    }
	});
}

function sayAjaxPostHello(name){
	//alert("inside sayHelloPost()");
	$.post('/hello',
			{'name':name},
			function(data){
				$('#sayHello').text(data);
			});
}

function sayJsonHello(name){
	//alert("inside Json");
	$.getJSON('/json',
			  {"name":name},
			  function(data){
				 $('#sayHello').text("Hi " +data.name+ " greetings from Json.....!!!!!");
			});
}