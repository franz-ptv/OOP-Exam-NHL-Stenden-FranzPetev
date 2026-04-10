package com.nhlstenden.caseontour;

public class Ticket
{
    private String code;
    private Concert concert;

    public Ticket (Concert concert)
    {
        this.code = null; // should not be null
        this.concert = concert;
    }

    public String getCode ()
    {
        return concert.getArtist().getName() + concert.getVenue().getName() + concert.getDate();
    }

    public Concert getConcert ()
    {
        return this.concert;
    }

    public void setConcert (Concert concert)
    {
        this.concert = concert;
    }
}
