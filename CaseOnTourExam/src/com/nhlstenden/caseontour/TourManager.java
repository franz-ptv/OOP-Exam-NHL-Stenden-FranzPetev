package com.nhlstenden.caseontour;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TourManager
{
    private String name;
    private int maxAmountOfArtists;
    private List<Artist> artists;
    private List<Venue> venues;
    private List<Concert> concerts;

    public TourManager (String name, int maxAmountOfArtists)
    {
        this.name = name;
        this.maxAmountOfArtists = maxAmountOfArtists;
        this.setArtists(new ArrayList<>());
        this.setVenues(new ArrayList<>());
        this.setConcerts(new ArrayList<>());
    }

    public String getName ()
    {
        return this.name;
    }

    public void setName (String name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("name cannot be null or blank");
        }

        this.name = name;
    }

    public int getMaxAmountOfArtists ()
    {
        return this.maxAmountOfArtists;
    }

    public void setMaxAmountOfArtists (int maxAmountOfArtists)
    {
        if (maxAmountOfArtists < 0)
        {
            throw new IllegalArgumentException("Max amount of artist can not be less than 0");
        }

        this.maxAmountOfArtists = maxAmountOfArtists;
    }

    public List<Artist> getArtists ()
    {
        return new ArrayList<>(this.artists);
    }

    public void setArtists (List<Artist> artists)
    {
        if (artists == null)
        {
            throw new IllegalArgumentException("artists cannot be null");
        }

        for (Artist artist : artists)
        {
            if (artist == null)
            {
                throw new IllegalArgumentException("artists cannot be null");
            }
        }

        this.artists = new ArrayList<>(artists);
    }

    public List<Venue> getVenues ()
    {
        return new ArrayList<>(this.venues);
    }

    public void setVenues (List<Venue> venues)
    {
        if (venues == null)
        {
            throw new IllegalArgumentException("venues cannot be null");
        }

        for (Venue venue : venues)
        {
            if (venue == null)
            {
                throw new IllegalArgumentException("venues cannot be null");
            }
        }

        this.venues = new ArrayList<>(venues);
    }

    public List<Concert> getConcerts ()
    {
        return new ArrayList<>(this.concerts);
    }

    public void setConcerts (List<Concert> concerts)
    {
        if (concerts == null)
        {
            throw new IllegalArgumentException("concerts cannot be null");
        }

        for (Concert concert : concerts)
        {
            if (concert == null)
            {
                throw new IllegalArgumentException("concerts cannot be null");
            }
        }

        this.concerts = new ArrayList<>(concerts);
    }

    public void addArtist(Artist artist)
    {
        if (artist == null)
        {
            throw new IllegalArgumentException("An artist you want to add can not be null");
        }
        if (getMaxAmountOfArtists() <= artists.size())
        {
            throw new IllegalArgumentException("The max amount of artist has been reached!");
        }

        artists.add(artist);
    }

    public void addVenue(Venue venue)
    {
        if (venue == null)
        {
            throw new IllegalArgumentException("A venue you want to add can not be null!");
        }

        venues.add(venue);
    }

    public void addConcert(Concert concert)
    {
        if (concert == null)
        {
            throw new IllegalArgumentException("The concert you want to add can not be null");
        }

        concerts.add(concert);
    }

    public Concert getConcert(Artist artist, Venue venue, LocalDate date)
    {
        for (Concert concert : concerts)
        {
            if (concert.getArtist().equals(artist) && concert.getVenue().equals(venue) && concert.getDate().equals(date))
            {
                return concert;
            }
        }

        throw new IllegalArgumentException("No such concert was found!");
    }

    public Concert getConcert(String artistName, String venueName, LocalDate date)
    {
        for (Concert concert : concerts)
        {
            if (concert.getArtist().getName().equals(artistName) && concert.getVenue().getName().equals(venueName) && concert.getDate().equals(date))
            {
                return concert;
            }
        }

        throw new IllegalArgumentException("No such concert was found!");
    }

    public List<Concert> getConcertsByArtist (List<Concert> concerts, Artist artist)
    {
        List<Concert> toDisplay = new ArrayList<>();
        for (Concert concert : concerts)
        {
            if (concert.getArtist().equals(artist))
            {
                toDisplay.add(concert);
            }
        }
        if (toDisplay.isEmpty())
        {
            throw new IllegalArgumentException("There are no concerts in this list for this artist");
        }

        return toDisplay;
    }

    private List<Concert> getConcertsByDate(List<Concert> concerts, LocalDate date)
    {
        List<Concert> toDisplay = new ArrayList<>();
        for (Concert concert : concerts)
        {
            if (concert.getDate().equals(date))
            {
                toDisplay.add(concert);
            }
        }
        if (toDisplay.isEmpty())
        {
            throw new IllegalArgumentException("There are no concerts in this list for this date");
        }

        return toDisplay;
    }

    private List<Concert> getConcertsByVenue(List<Concert> concerts, Venue venue)
    {
        List<Concert> toDisplay = new ArrayList<>();
        for (Concert concert : concerts)
        {
            if (concert.getVenue().equals(venue))
            {
                toDisplay.add(concert);
            }
        }
        if (toDisplay.isEmpty())
        {
            throw new IllegalArgumentException("There are no concerts in this list for this date");
        }

        return toDisplay;
    }

    public Artist getArtistByName(String name)
    {
        for (Artist artist : artists)
        {
            if (artist.getName().equals(name))
            {
                return artist;
            }
        }

        throw new IllegalArgumentException("There is no artist with this name");
    }

    public Venue getVenueByName(String name)
    {
        for (Venue venue : venues)
        {
            if (venue.getName().equals(name))
            {
                return venue;
            }
        }

        throw new IllegalArgumentException("There is no venue with this name");
    }

    public void scheduleConcert(String artistName, String venueName, LocalDate date)
    {
        for (Artist artist : artists)
        {
            if (artist.getName().equals(artistName))
            {
                for (Venue venue : venues)
                {
                    if (venue.getName().equals(venueName))
                    {

                    }
                }

                throw new IllegalArgumentException("There is no venue with that name");
            }
        }

        throw new IllegalArgumentException("There is no artist with that name");
    }

    private boolean hasShowOnDate(Artist artist, LocalDate date)
    {
        return false;
    }

    public void removeCanceledConcerts()
    {
        for (Concert concert : concerts)
        {
            if (concert.getSoldTickets().isEmpty())
            {
                concerts.remove(concert);
            }
        }
    }

    private List<Concert> getConcertsInFuture(List<Concert> concerts)
    {
        List<Concert> toDisplay = new ArrayList<>();
        for (Concert concert : concerts)
        {
            if (concert.getDate().isAfter(LocalDate.now()))
            {
                toDisplay.add(concert);
            }
        }

        return toDisplay;
    }

    private List<Concert> getConcertsWithZeroTicketsSold(List<Concert> concerts)
    {
        List<Concert> toDisplay = new ArrayList<>();
        for (Concert concert : concerts)
        {
            if (concert.getAmountOfTicketsSold() == 0)
            {
                toDisplay.add(concert);
            }
        }

        return toDisplay;
    }

    public int getTotalRevenueInEuros(String artistName)
    {
        int totalRevenue = 0;
        for (Concert concert : concerts)
        {
            if (concert.getArtist().getName().equals(artistName))
            {
                totalRevenue += concert.getRevenueInEuro();
            }
        }

        return totalRevenue;
    }
}
