package com.naseef.rest.messenger.resources.beans;

import javax.ws.rs.QueryParam;

/**
 * Created by USER on 6/16/2017.
 */
public class BeanParamClass
{
    private @QueryParam("year") int year ;
    private @QueryParam("start") int start;
    private @QueryParam("end") int end;

    public int getYear()
    {
        return year;
    }

    public int getStart()
    {
        return start;
    }

    public int getEnd()
    {
        return end;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public void setStart(int start)
    {
        this.start = start;
    }

    public void setEnd(int end)
    {
        this.end = end;
    }
}
