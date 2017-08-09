package com.naseef.rest.messenger.database;

import com.naseef.rest.messenger.model.Comment;
import com.naseef.rest.messenger.model.Message;
import com.naseef.rest.messenger.model.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by USER on 6/11/2017.
 *
 * This would ideally be a JDBC or Hibernate Class which connects to the database
 * This is not Thread safe. Only Suitable for one user. (which will be not be ideal)
 *
 */
public class DatabaseClass
{
    private static Map <Long , Message> messages = new HashMap<>();
    private static Map <String , Profile> profiles = new HashMap<>();
    //private static Map <Long , Comment> comments = new HashMap<>();

    public static Map<Long , Message> getAllMessages()
    {
        return messages;
    }

    public static Map<String, Profile> getAllProfiles()
    {
        return profiles;
    }
}
