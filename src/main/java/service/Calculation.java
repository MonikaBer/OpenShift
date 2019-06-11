package service;

import javax.script.ScriptEngineManager;

import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("")
public class Calculation extends Application {	
	public String calc(String expression) throws ScriptException {
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
		
		String result = engine.eval(expression).toString();
		return result;
	}
	
	
	@GET
	@Path("{expression}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getRequest(@PathParam("expression") String expression) {
		try {
			return calc(expression).toString();
		} catch (Exception exc) {
			return "Calculation error!";
		}
	}
	
	
	@POST
	@Path("post")
	@Produces(MediaType.APPLICATION_JSON)
	public Response postRequest(final Expression exp) {
		try {
			String result = calc(exp.getExpression());
			String response = "{\"expression\" : \"" + result + "\"}";
			return Response.status(201).entity(response).build();
		} catch (ScriptException exc) {
			return Response.status(Response.Status.BAD_REQUEST).
					entity("Calculation error").build();	
		}
	}
}

