package com.naseef.rest.messenger.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * Created by USER on 6/13/2017.
 */
@Path("demoResource")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class DemoResource
{
    @GET
    @Path("annotations")
    @Produces(MediaType.TEXT_PLAIN)
    public String getDataByParams (@MatrixParam("param") String param,
                                   @HeaderParam("authSessionId") String authSessionId,
                                   @CookieParam("naseef")String cookie)
    {
        return "param " + param + " Header " + authSessionId + " Cookie " + cookie;
    }

    @GET
    @Path("context")
    public String getDataByContext (@Context UriInfo uriInfo, @Context HttpHeaders header)
    {
        String uri = uriInfo.getQueryParameters().toString();
        String cookie = header.getCookies().toString();
        return "URI "+uri+" Cookie "+cookie;
    }

}
