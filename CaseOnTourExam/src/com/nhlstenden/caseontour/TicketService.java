package com.nhlstenden.caseontour;

import java.time.LocalDate;

public class TicketService
{
    private TourManager tourManager;

    public TicketService (TourManager tourManager)
    {
        this.setTourManager(tourManager);
    }

    public TourManager getTourManager ()
    {
        return this.tourManager;
    }

    public void setTourManager (TourManager tourManager)
    {
        if (tourManager == null)
        {
            throw new IllegalArgumentException("Tour Manager can not be null");
        }

        this.tourManager = tourManager;
    }

    public void sellTickets(String artistName, String venueName, LocalDate date, int amountOfTickets)
    {

        Concert theConcert = tourManager.getConcert(artistName, venueName, date);
        if (theConcert.hasOccurred())
        {
            throw new IllegalArgumentException("The concert had already ended");
        }
        if (amountOfTickets > theConcert.getVenue().getMaxCapacity())
        {
            throw new IllegalArgumentException("The venue for this concert is full");
        }
        reserveTickets(amountOfTickets, theConcert);
    }

    public int getTotalRevenueInEuro(String artistName)
    {
        if (artistName == null || artistName.isEmpty())
        {
            throw new IllegalArgumentException("The name of the artist can not be null or empty!");
        }

        return tourManager.getTotalRevenueInEuros(artistName);
    }

    public boolean isSoldOut(int amountOfTickets, Concert concert)
    {
        return false;
    }

    private void reserveTickets(int amountOfTickets, Concert concert)
    {
        int i = 0;
        while (i < amountOfTickets)
        {
            Ticket ticket = new Ticket(concert);
            concert.addTicket(ticket);
            i++;
        }
    }

    private boolean isExisting(Concert concert)
    {
        for (Concert eachConcert : tourManager.getConcerts())
        {
            if (concert.equals(eachConcert))
            {
                return true;
            }
        }

        return false;
    }
}
