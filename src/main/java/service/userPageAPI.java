package service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/user")
public class userPageAPI {

	@GET
	@Path("/{name}")
	public Response getMsg(@PathParam("name") String name) {
		String output = "<html><title>user api</title><body><import page='header.jsp'><h1>"
				 + name + "</h1></body></html>";
		return Response.status(200).entity(output).build();
	}
}
