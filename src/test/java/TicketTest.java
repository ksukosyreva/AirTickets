import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketTest {
    @Test
    public void shouldCompareWhenTicket1LessThenTicket2 () {
        Ticket ticket1 = new Ticket("SPB", "Moscow", 2000,8,9);
        Ticket ticket2 = new Ticket("SPB", "Moscow", 2200,9,10);

        Ticket[] tickets = {ticket1, ticket2};


        int expected = -1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareWhenTicket1MoreThenTicket2 () {
        Ticket ticket1 = new Ticket("SPB", "Moscow", 2500,9,10);
        Ticket ticket2 = new Ticket("SPB", "Moscow", 1700,6,7);

        Ticket [] tickets= {ticket1, ticket2};

        int expected = 1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareWhenTicketsAreEquals () {
        Ticket ticket1 = new Ticket("SPB", "Moscow", 1900,7,8);
        Ticket ticket2 = new Ticket("SPB", "Moscow", 1900,9,10);

        Ticket[] tickets = {ticket1, ticket2};

        int expected = 0;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }
}
