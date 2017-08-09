package com.naseef.rest.messenger.service;

import com.naseef.rest.messenger.database.DatabaseClass;
import com.naseef.rest.messenger.model.Comment;
import com.naseef.rest.messenger.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by USER on 6/30/2017.
 */
public class CommentService
{
    private Map <Long,Message> messages = DatabaseClass.getAllMessages();


    public List<Comment> getAllComments(long messageID)
    {
        Map <Long , Comment> comments = messages.get(messageID).getComments();
        return new ArrayList<>(comments.values());
    }

    public Comment getComment(long messageID , long commentID)
    {
        return messages.get(messageID).getComments().get(commentID);
    }

    public Comment addComment (long messageID , Comment comment)
    {
        Map <Long , Comment> comments = messages.get(messageID).getComments();
        comment.setId(comments.size()+1);
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment updateComment (long messageID , Comment comment)
    {
        Map <Long , Comment> comments = messages.get(messageID).getComments();
        if (comment.getId() <= 0)
        {
            return null;
        }
        comments.put(comment.getId(),comment);
        return comment;
    }

    public Comment removeComment(long messageID , long commentID)
    {
        return messages.get(messageID).getComments().remove(commentID);
    }
}
