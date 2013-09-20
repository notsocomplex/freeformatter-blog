package com.freeformatter.blog.endpoint;

import java.math.BigInteger;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.freeformatter.blog.jaxb.CreateUserRequest;
import com.freeformatter.blog.jaxb.CreateUserResponse;
import com.freeformatter.blog.service.UserService;

// We indicate that this class will handle endpoints using the Endpoint stereotype annotation.
// Quite similar to the @Controller in Spring MVC
@Endpoint
public class CreateUserEndpoint {
	
	private static final Logger LOGGER = Logger.getLogger(CreateUserEndpoint.class);
	
	// Automatically inject a UserService implementation
	@Autowired
	private UserService userService;

	// Have this method handle all request for 'createUserRequest' payload under the 
	// specified namespace. Note the @RequestPayload annotation that uses JAXB in the background
	// to unmarshall the payload to a POJO
	@PayloadRoot(localPart = "createUserRequest", namespace = "http://blog.freeformatter.com/user")
	@ResponsePayload
	public CreateUserResponse orderCreated(@RequestPayload CreateUserRequest request) {

		LOGGER.debug(
			String.format("Received a request '%s'.", ToStringBuilder.reflectionToString(request))
		);

		// Call a bogus service that returns the millis for the id
		long userId = userService.createUser(request);

		// Create a response instance and return it. @ResponsePayload here means that
		// this object will serve as the response body of the request. JAXB will
		// be used to marshall the object
		CreateUserResponse response = new CreateUserResponse();
		response.setId(BigInteger.valueOf(userId));

		return response;

	}

}
