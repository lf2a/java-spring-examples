package com.lf2a;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lf2a.validation.IpAddress;
import com.lf2a.validation.USPhoneNumber;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("")
public class SampleResource {

	@Inject
	@ConfigProperty(name = "message")
	private String message;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response message(@USPhoneNumber @QueryParam("n") String number) {
		// %2B1-415-555-2671
		return Response.ok(message).build();
	}

	@GET
	@Path("/ip")
	@Produces(MediaType.TEXT_PLAIN)
	public Response message2(@IpAddress @QueryParam("ip") String ipAddress) {
		// 192.168.0.1
		return Response.ok(ipAddress).build();
	}

}
