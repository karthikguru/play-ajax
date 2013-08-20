package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.node.ObjectNode;

import play.Logger;
import play.Routes;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {
  
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result hello(String name){
    	Logger.info("Inside Java Hello with name as: "+name);
    	return ok("Hi " +name+ " greetings from JSRoutes and GET.....!!!!!");
    }
    
    public static Result helloPost(){
    	Logger.info("Inside Java helloPost() method ");
    	Logger.info(request().body().asFormUrlEncoded().get("name")[0]);
    	Map<String,String[]> parameters = request().body().asFormUrlEncoded();
    	String message = parameters.get("name")[0];
    	return ok("Hi "+message+" greetings from AJAX POST.....!!!!!");
    }
    
     public static Result getJson(String name){
    	Logger.info("Inside Java getJson() method withn value :" +name);
    	
        Map<String,String> mapList1 = new HashMap<String,String>();
        Map<String,String> mapList2 = new HashMap<String,String>();
        
    	List<Map<String,String>> list = new ArrayList<Map<String,String>>();
    	
        mapList1.put("name", "karthikguru");
        mapList1.put("age", "10");
        list.add(mapList1);
    	
        mapList2.put("name", "Vinay");
        mapList2.put("age", "2");
        list.add(mapList2);
        
        //return ok(Json.toJson(list));
        
        ObjectNode on= Json.newObject();
        on.put("name", name);
        return ok(on);
    }
     
     public static Result helloAjaxPlain(String name){
     	Logger.info("Inside Java Hello with name as: "+name);
     	return ok("Hi " +name+ " greetings from AJAX Plain.....!!!!!");
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
