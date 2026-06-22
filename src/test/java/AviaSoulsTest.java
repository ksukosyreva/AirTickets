import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void shouldSortOneTicket () {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("KLD", "MSC", 3000,19, 20);
        Ticket ticket2 = new Ticket("SPB", "MSC", 2000,15, 16);
        Ticket ticket3 = new Ticket("MSC", "VVO", 5000,13, 18);
        Ticket ticket4 = new Ticket("SPB", "KUF", 3500,11, 13);
        Ticket ticket5 = new Ticket("AER", "MSC", 3000,10, 12);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("SPB", "KUF");
        Ticket[] expected = {ticket4};
        Assertions.assertArrayEquals(expected,actual);

    }

    @Test
    public void shouldSortTwoTickets () {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("KLD", "MSC", 3000, 19, 20);
        Ticket ticket2 = new Ticket("SPB", "MSC", 2000, 15, 16);
        Ticket ticket3 = new Ticket("KLD", "MSC", 5000, 13, 18);
        Ticket ticket4 = new Ticket("SPB", "KUF", 3500, 11, 13);
        Ticket ticket5 = new Ticket("AER", "MSC", 3000, 10, 12);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("KLD", "MSC");
        Ticket[] expected = {ticket1, ticket3};
    }

    @Test
    public void shouldSortSeveralTickets () {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("KLD", "MSC", 3000, 19, 20);
        Ticket ticket2 = new Ticket("SPB", "MSC", 2000, 15, 16);
        Ticket ticket3 = new Ticket("KLD", "MSC", 5000, 13, 18);
        Ticket ticket4 = new Ticket("SPB", "MSC", 3500, 11, 13);
        Ticket ticket5 = new Ticket("AER", "MSC", 3000, 10, 12);
        Ticket ticket6 = new Ticket("SPB", "MSC", 1500, 8,9);
        Ticket ticket7 = new Ticket("SPB", "MSC", 1900, 8,9);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.search("SPB", "MSC");
        Ticket[] expected = {ticket6, ticket7,ticket2,ticket4};
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldSortByFlightTimeIfOneResult () {
        AviaSouls manager = new AviaSouls();
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket ticket1 = new Ticket("KLD", "MSC", 3000, 19, 20);
        Ticket ticket2 = new Ticket("SPB", "MSC", 2000, 15, 17);
        Ticket ticket3 = new Ticket("KLD", "MSC", 5000, 13, 18);
        Ticket ticket4 = new Ticket("SPB", "MSC", 3500, 11, 13);
        Ticket ticket5 = new Ticket("AER", "MSC", 3000, 10, 3);
        Ticket ticket6 = new Ticket("SPB", "MSC", 1500, 8,9);
        Ticket ticket7 = new Ticket("SPB", "MSC", 1900, 8,9);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.searchAndSortBy("AER", "MSC", comparator);
        Ticket[] expected = {ticket5};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByFlightTimeIfTwoResults () {
        AviaSouls manager = new AviaSouls();
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket ticket1 = new Ticket("KLD", "MSC", 3000, 19, 20);
        Ticket ticket2 = new Ticket("SPB", "MSC", 2000, 15, 17);
        Ticket ticket3 = new Ticket("KLD", "MSC", 5000, 13, 16);
        Ticket ticket4 = new Ticket("SPB", "MSC", 3500, 11, 13);
        Ticket ticket5 = new Ticket("AER", "MSC", 3000, 10, 3);
        Ticket ticket6 = new Ticket("SPB", "MSC", 1500, 8,9);
        Ticket ticket7 = new Ticket("SPB", "MSC", 1900, 8,9);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.searchAndSortBy("KLD", "MSC", comparator);
        Ticket[] expected = {ticket1, ticket3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByFlightTimeIfFewResults () {
        AviaSouls manager = new AviaSouls();
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket ticket1 = new Ticket("KLD", "MSC", 3000, 19, 20);
        Ticket ticket2 = new Ticket("SPB", "MSC", 2000, 15, 17);
        Ticket ticket3 = new Ticket("SPB", "KUF", 5000, 13, 16);
        Ticket ticket4 = new Ticket("SPB", "MSC", 3500, 11, 13);
        Ticket ticket5 = new Ticket("AER", "MSC", 3000, 10, 3);
        Ticket ticket6 = new Ticket("SPB", "KUF", 1500, 8,9);
        Ticket ticket7 = new Ticket("SPB", "KUF", 1900, 8,10);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.searchAndSortBy("SPB", "KUF", comparator);
        Ticket[] expected = {ticket6, ticket7, ticket3};
        Assertions.assertArrayEquals(expected, actual);
    }
}
