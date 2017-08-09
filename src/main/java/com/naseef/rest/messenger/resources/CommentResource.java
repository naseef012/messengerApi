package com.naseef.rest.messenger.resources;

import com.naseef.rest.messenger.model.Comment;
import com.naseef.rest.messenger.service.CommentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by USER on 6/16/2017.
 */
@Path("") // It is optional here coz we want the path to be inferred from MessageResource
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource
{
    CommentService commentService = new CommentService();

    @GET
    public List<Comment> getAllComments(@PathParam("messageId") long messageId)
    {
        return commentService.getAllComments(messageId);
    }

    @POST
    public Comment addComment(@PathParam("messageId") long messageId , Comment comment)
    {
        return commentService.addComment(messageId, comment);
    }

    @PUT
    @Path("{commentId}")
    public Comment updateComment (@PathParam("messageId") long messageId , @PathParam("commentId") long commentId, Comment comment)
    {
        comment.setId(commentId);
        return commentService.updateComment(messageId,comment);
    }

    @DELETE
    @Path("{commentId}")
    public void deleteComment(@PathParam("messageId") long messageId , @PathParam("commentId") long commentId)
    {
        commentService.removeComment(messageId, commentId);
    }


    @GET
    @Path("{commentId}")                  //messageId is taken from the parent class
    public String getCommentId (@PathParam("messageId") long messageId, @PathParam("commentId") long commentId)
    {
        return "Message ID = "+messageId+ " & Comment ID = "+commentId;
    }
}
