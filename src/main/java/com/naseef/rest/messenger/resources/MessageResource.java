package com.naseef.rest.messenger.resources;

import com.naseef.rest.messenger.model.Message;
import com.naseef.rest.messenger.resources.beans.BeanParamClass;
import com.naseef.rest.messenger.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by USER on 6/10/2017.
 */
@Path("messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource
{
    MessageService msgService = new MessageService();

    @GET
    public List<Message> getMessages(@BeanParam BeanParamClass bean)
    {
        if (bean.getYear()>0)
            return msgService.getMessageByYear(bean.getYear());
        if (bean.getStart()>0 && bean.getEnd()>0)
            return msgService.getMessagePaginated(bean.getStart(),bean.getEnd());
        else
            return msgService.getAllMessages();
    }

/*Response Builder lets you modify the status codes and headers*/

    @POST
    public Response postMessage(Message message, @Context UriInfo uriInfo) throws URISyntaxException
    {
        Message newMsg = msgService.addMessage(message);
        URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMsg.getId())).build();
        return Response.created(uri)
                .entity(newMsg)
                .build();
        //return msgService.addMessage(message);
    }

    @PUT
    @Path("{messageId}")
    public Message upDateMessage (@PathParam("messageId") long id , Message msg)
    {
        msg.setId(id);
        return msgService.updateMessage(msg);
    }


    @DELETE
    @Path("{messageId}")
    public void deleteMessage (@PathParam("messageId") long id)
    {
        msgService.removeMessage(id);
    }


    @GET
    @Path("{messageId}") //takes whatever is given after "/messages" as String
    public Message getText(@PathParam("messageId") long messageId) //no String to Long conversion is done here.
    {
        return msgService.getMessage(messageId);
    }


    @Path("{messageId}/comments") //messageId param can be caught in CommentResource class
    public CommentResource getCommentResource()
    {
        return new CommentResource();
    }
}
