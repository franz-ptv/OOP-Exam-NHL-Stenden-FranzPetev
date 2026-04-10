package com.nhlstenden.caseontour;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TicketServiceTest
{
    // true, false, throws, DoesNotThrow, equals, notEquals
    @Test
    void getTotalRevenue_giving1event5Tickets_expecting250()
    {
        TourManager tourManager = new TourManager("Tour Manager", 3);
        TicketService ts = new TicketService(tourManager);

        Artist artist1 = new Artist("Travis Scott", "Cool music");
        Artist artist2 = new Artist("Ariana Grande", "Cool music");
        Artist artist3 = new Artist("21 Savage", "Cool music");

        Venue venue1 = new Venue("SofiaArena", "Sofia", 200);
        Venue venue2 = new Venue("BucharestArena", "Bucharest", 250);
        Venue venue3 = new Venue("EmmenArena", "Emmen", 150);

        LocalDate date1 = LocalDate.of(2027, 5, 5);
        LocalDate date2 = LocalDate.of(2028, 5, 5);
        LocalDate date3 = LocalDate.of(2029, 5, 5);

        Concert concert1 = new Concert(artist1,venue1, date1);
        Concert concert2 = new Concert(artist2,venue2, date2);
        Concert concert3 = new Concert(artist3,venue3, date3);

        tourManager.addConcert(concert1);
        tourManager.addConcert(concert2);
        tourManager.addConcert(concert3);

        ts.sellTickets("Travis Scott", "SofiaArena", date1, 5);

        assertEquals(250, ts.getTotalRevenueInEuro("Travis Scott"));
    }

    @Test
    void getTotalRevenue_giving1event5TicketsNotForTheRightArtist_expecting0Revenue()
    {
        TourManager tourManager = new TourManager("Tour Manager", 3);
        TicketService ts = new TicketService(tourManager);

        Artist artist1 = new Artist("Travis Scott", "Cool music");
        Artist artist2 = new Artist("Ariana Grande", "Cool music");
        Artist artist3 = new Artist("21 Savage", "Cool music");

        Venue venue1 = new Venue("SofiaArena", "Sofia", 200);
        Venue venue2 = new Venue("BucharestArena", "Bucharest", 250);
        Venue venue3 = new Venue("EmmenArena", "Emmen", 150);

        LocalDate date1 = LocalDate.of(2027, 5, 5);
        LocalDate date2 = LocalDate.of(2028, 5, 5);
        LocalDate date3 = LocalDate.of(2029, 5, 5);

        Concert concert1 = new Concert(artist1,venue1, date1);
        Concert concert2 = new Concert(artist2,venue2, date2);
        Concert concert3 = new Concert(artist3,venue3, date3);

        tourManager.addConcert(concert1);
        tourManager.addConcert(concert2);
        tourManager.addConcert(concert3);

        ts.sellTickets("Travis Scott", "SofiaArena", date1, 5);

        assertEquals(0, ts.getTotalRevenueInEuro("21 Savage"));
    }

    @Test
    void getTotalRevenue_giving1event5Tickets_doNotExpect50()
    {
        TourManager tourManager = new TourManager("Tour Manager", 3);
        TicketService ts = new TicketService(tourManager);

        Artist artist1 = new Artist("Travis Scott", "Cool music");
        Artist artist2 = new Artist("Ariana Grande", "Cool music");
        Artist artist3 = new Artist("21 Savage", "Cool music");

        Venue venue1 = new Venue("SofiaArena", "Sofia", 200);
        Venue venue2 = new Venue("BucharestArena", "Bucharest", 250);
        Venue venue3 = new Venue("EmmenArena", "Emmen", 150);

        LocalDate date1 = LocalDate.of(2027, 5, 5);
        LocalDate date2 = LocalDate.of(2028, 5, 5);
        LocalDate date3 = LocalDate.of(2029, 5, 5);

        Concert concert1 = new Concert(artist1,venue1, date1);
        Concert concert2 = new Concert(artist2,venue2, date2);
        Concert concert3 = new Concert(artist3,venue3, date3);

        tourManager.addConcert(concert1);
        tourManager.addConcert(concert2);
        tourManager.addConcert(concert3);

        ts.sellTickets("Travis Scott", "SofiaArena", date1, 5);

        assertNotEquals(50, ts.getTotalRevenueInEuro("Travis Scott"));
    }

    @Test
    void getTotalRevenue_givingEmptyName_ExpectThrows()
    {
        TourManager tourManager = new TourManager("Tour Manager", 3);
        TicketService ts = new TicketService(tourManager);

        Artist artist1 = new Artist("Travis Scott", "Cool music");
        Artist artist2 = new Artist("Ariana Grande", "Cool music");
        Artist artist3 = new Artist("21 Savage", "Cool music");

        Venue venue1 = new Venue("SofiaArena", "Sofia", 200);
        Venue venue2 = new Venue("BucharestArena", "Bucharest", 250);
        Venue venue3 = new Venue("EmmenArena", "Emmen", 150);

        LocalDate date1 = LocalDate.of(2027, 5, 5);
        LocalDate date2 = LocalDate.of(2028, 5, 5);
        LocalDate date3 = LocalDate.of(2029, 5, 5);

        Concert concert1 = new Concert(artist1,venue1, date1);
        Concert concert2 = new Concert(artist2,venue2, date2);
        Concert concert3 = new Concert(artist3,venue3, date3);

        tourManager.addConcert(concert1);
        tourManager.addConcert(concert2);
        tourManager.addConcert(concert3);


        assertThrows(IllegalArgumentException.class, () ->{
            ts.getTotalRevenueInEuro("");
        });
    }

    @Test
    void getTotalRevenue_givingProperName_ExpectNotThrow()
    {
        TourManager tourManager = new TourManager("Tour Manager", 3);
        TicketService ts = new TicketService(tourManager);

        Artist artist1 = new Artist("Travis Scott", "Cool music");
        Artist artist2 = new Artist("Ariana Grande", "Cool music");
        Artist artist3 = new Artist("21 Savage", "Cool music");

        Venue venue1 = new Venue("SofiaArena", "Sofia", 200);
        Venue venue2 = new Venue("BucharestArena", "Bucharest", 250);
        Venue venue3 = new Venue("EmmenArena", "Emmen", 150);

        LocalDate date1 = LocalDate.of(2027, 5, 5);
        LocalDate date2 = LocalDate.of(2028, 5, 5);
        LocalDate date3 = LocalDate.of(2029, 5, 5);

        Concert concert1 = new Concert(artist1,venue1, date1);
        Concert concert2 = new Concert(artist2,venue2, date2);
        Concert concert3 = new Concert(artist3,venue3, date3);

        tourManager.addConcert(concert1);
        tourManager.addConcert(concert2);
        tourManager.addConcert(concert3);


        assertDoesNotThrow(() -> {
            ts.getTotalRevenueInEuro("Ariana Grande");
        });
    }

}