package com.nhlstenden.caseontour;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concert
{
    private static final int DEFAULT_TICKET_PRICE_IN_EUROS = 50;
    private static final int MINIMUM_PRICE = 1;
    private Artist artist;
    private Venue venue;
    private LocalDate date;
    private List<Ticket> soldTickets;
    private int priceInEuro;

    public Concert (Artist artist, Venue venue, LocalDate date)
    {
        this.setArtist(artist);
        this.setVenue(venue);
        this.setDate(date);
        this.setSoldTickets(new ArrayList<>());
        this.setPriceInEuro(DEFAULT_TICKET_PRICE_IN_EUROS);
    }

    public Artist getArtist ()
    {
        return this.artist;
    }

    public void setArtist (Artist artist)
    {
        if (artist == null)
        {
            throw new IllegalArgumentException("Artist can not be null!");
        }

        this.artist = artist;
    }

    public Venue getVenue ()
    {
        return this.venue;
    }

    public void setVenue (Venue venue)
    {
        if (venue == null)
        {
            throw new IllegalArgumentException("Venue can not be null");
        }

        this.venue = venue;
    }

    public LocalDate getDate ()
    {
        return this.date;
    }

    public void setDate (LocalDate date)
    {
        if (date == null)
        {
            throw new IllegalArgumentException("date cannot be null");
        }

        this.date = date;
    }

    public List<Ticket> getSoldTickets ()
    {
        return new ArrayList<>(this.soldTickets);
    }

    public void setSoldTickets (List<Ticket> soldTickets)
    {
        if (soldTickets == null)
        {
            throw new IllegalArgumentException("soldTickets cannot be null");
        }

        for (Ticket ticket : soldTickets)
        {
            if (ticket == null)
            {
                throw new IllegalArgumentException("soldTickets cannot be null");
            }
        }

        this.soldTickets = new ArrayList<>(soldTickets);
    }

    public int getPriceInEuro ()
    {
        return this.priceInEuro;
    }

    public void setPriceInEuro (int priceInEuro)
    {
        if (priceInEuro < MINIMUM_PRICE)
        {
            throw new IllegalArgumentException("Ticket price can not be 0 or negative");
        }

        this.priceInEuro = priceInEuro;
    }

    public boolean hasOccurred ()
    {
        return LocalDate.now().isAfter(getDate());
    }

    public void addTicket(Ticket ticket)
    {
        if (ticket == null)
        {
            throw new IllegalArgumentException("Ticket can not be null");
        }
        if (isSoldOut())
        {
            throw new IllegalArgumentException("This concerts tickets are sold out!");
        }
            soldTickets.add(ticket);
    }

    public void removeTicket(Ticket ticket)
    {
        if (ticket == null)
        {
            throw new IllegalArgumentException("The ticket you want removed can not be null!");
        }

        soldTickets.remove(ticket);
    }

    public int getAmountOfTicketsSold()
    {
        int total = 0;
        for (Ticket ticket : soldTickets)
        {
            total ++;
        }

        return total;
    }

    public int getRevenueInEuro()
    {
        return getAmountOfTicketsSold()*getPriceInEuro();
    }

    public boolean isSoldOut()
    {
        if (getVenue().getMaxCapacity() <= getSoldTickets().size())
        {
            return true;
        }

        return false;
    }
}
