package com.naseef.rest.messenger.service;

import com.naseef.rest.messenger.database.DatabaseClass;
import com.naseef.rest.messenger.model.Message;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by USER on 6/10/2017.
 */

/**
 * In an actual Service this class will connect to database and get the messages from the tables of
 * the database.
 */

public class MessageService
{
    private static Map<Long , Message> messages = DatabaseClass.getAllMessages();


    static
    {
        messages.put(1L, new Message(1, "Hello Shaneela", "Aroni"));
        messages.put(2L, new Message(2, "Hello Aroni!", "Shaneela"));
    }
    public MessageService()
    {
        
    }

    public List<Message> getAllMessages()
    {
        return new ArrayList<>(messages.values());
    }

    public Message getMessage (long id)
    {
        return messages.get(id);
    }

    public List<Message> getMessageByYear (int year)
    {
        List<Message> msg_List = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        for (Message msg : messages.values())
        {
            calendar.setTime(msg.getCreated());
            if (calendar.get(Calendar.YEAR) == year)
            {
                msg_List.add(msg);
            }
        }
        return msg_List;
    }

    public List<Message> getMessagePaginated (int newStart, int end)
    {

        ArrayList<Message> list = new ArrayList<>(messages.values());
        if (newStart + end > list.size())
        {
            return new ArrayList<Message>();
        } else
        {
            return list.subList(newStart, newStart + end);
        }

    }

    public Message addMessage(Message msg)
    {
        msg.setId(messages.size() + 1);
        messages.put(msg.getId() , msg);
        return  msg;
    }

    public Message updateMessage (Message msg)
    {
        if (msg.getId() <= 0)
        {
            return null;
        }
        else
        {
            messages.put(msg.getId(),msg);
        }

        return msg;
    }

    public Message removeMessage(long id)
    {
        return messages.remove(id);
    }
}

