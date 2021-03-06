package com.naseef.rest.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by USER on 6/10/2017.
 */
@XmlRootElement
public class Message
{
    private long id;
    private String message;
    private Date created;
    private String author;
    private Map <Long , Comment> comments = new HashMap<>();

    //This is needed for XML and JSON conversion
    public Message()
    {

    }

    public Message(long id, String message, String author)
    {
        this.id = id;
        this.message = message;
        this.author = author;
        this.created = new Date();
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Date getCreated()
    {
        return created;
    }

    public void setCreated(Date created)
    {
        this.created = created;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    @XmlTransient
    public Map<Long, Comment> getComments()
    {
        return comments;
    }

    public void setComments(Map<Long, Comment> comments)
    {
        this.comments = comments;
    }
}
