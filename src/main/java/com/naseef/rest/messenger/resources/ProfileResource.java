package com.naseef.rest.messenger.resources;

import com.naseef.rest.messenger.database.DatabaseClass;
import com.naseef.rest.messenger.model.Profile;
import com.naseef.rest.messenger.service.ProfileService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 6/12/2017.
 */
@Path("profiles")
@Consumes (MediaType.APPLICATION_JSON)
@Produces (MediaType.APPLICATION_JSON)
public class ProfileResource
{
    ProfileService pro_srvice = new ProfileService();

    @GET
    public List<Profile> getAllProfiles()
    {
        return pro_srvice.getAllProfiles();
    }

    @GET
    @Path ("{profileName}")
    public Profile getProfile (@PathParam("profileName") String profileName)
    {
        return pro_srvice.getProfile(profileName);
    }

    @POST
    public Profile addProfile (Profile pro)
    {
        return pro_srvice.addProfile(pro);
    }

    @PUT
    @Path("{profileName}")
    public Profile updateProfile (@PathParam("profileName") String profileName, Profile pro)
    {
        pro.setProfileName(profileName);
        return pro_srvice.updateProfile(pro);
    }

    @DELETE
    @Path("{profileName}")
    public void deleteProfile (@PathParam("profileName") String profileName)
    {
        pro_srvice.removeProfile(profileName);
    }

}
