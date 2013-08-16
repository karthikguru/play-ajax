package controllers;

import play.Logger;
import play.Routes;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {
  
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result hello(String name){
    	Logger.info("Inside Java Hello with name as: "+name );
    	return ok("Hi "+name+", Have a great day..o...!!!!!");
    }
    
    public static Result myJsRoutes(){
    	response().setContentType("text/javascript");
    	return ok(
    				Routes.javascriptRouter("myJsRoutes",
    						routes.javascript.Application.hello()	
    				)
    			);
    }
  
}
