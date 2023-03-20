package com.test;

import com.test.model.Person;
import com.webcohesion.enunciate.metadata.rs.ResponseCode;
import com.webcohesion.enunciate.metadata.rs.StatusCodes;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


import java.net.HttpURLConnection;

import static com.test.ApiRights.READ_PERSON;
import static com.test.Version.VERSION;

@Path(VERSION + "/template")
@Produces(MediaType.APPLICATION_JSON)
public interface TemplateApi {


    @GET
    @Path("persons/{personId}")
    @RolesAllowed(READ_PERSON)
    @StatusCodes(value = {
            @ResponseCode(code = HttpURLConnection.HTTP_OK,
                          condition = "Request successful.")
    })
    Person get(@PathParam("personId") String personId);

}

