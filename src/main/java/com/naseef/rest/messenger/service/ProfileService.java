package com.naseef.rest.messenger.service;

import com.naseef.rest.messenger.database.DatabaseClass;
import com.naseef.rest.messenger.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by USER on 6/12/2017.
 */
public class ProfileService
{
    private static Map<String , Profile> profiles = DatabaseClass.getAllProfiles();



    static
    {
        profiles.put("sabbirProfile", new Profile(2, "sabbirProfile", "Sabbir" , "Ridwan"));
        profiles.put("naseefProfile", new Profile(1, "naseefProfile", "Naseef", "Mohammed"));
    }
    public ProfileService()
    {

    }

    public List<Profile> getAllProfiles()
    {
        return new ArrayList<>(profiles.values());
    }

    public Profile getProfile (String profileName)
    {
        return profiles.get(profileName);
    }

    public Profile addProfile(Profile pro)
    {
        pro.setId(profiles.size() + 1);
        profiles.put(pro.getProfileName() , pro);
        return  pro;
    }

    public Profile updateProfile (Profile pro)
    {
        if (pro.getProfileName().isEmpty())
        {
            return null;
        }
        else
        {
            profiles.put(pro.getProfileName(),pro);
        }

        return pro;
    }

    public Profile removeProfile(String profileName)
    {
        return profiles.remove(profileName);
    }
}
