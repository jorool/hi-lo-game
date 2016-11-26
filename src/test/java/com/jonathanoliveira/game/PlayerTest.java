package com.jonathanoliveira.game;

import org.junit.Test;

import static com.jonathanoliveira.cards.Card.ACE_OF_SPADES;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PlayerTest {

    @Test(expected = IllegalArgumentException.class)
    public void cantCreatePlayerWithNullName() throws Exception {
        new Player(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cantCreatePlayerWithEmptyName() throws Exception {
        new Player("");
    }

    @Test
    public void testEquals() throws Exception {
        Player goofy = new Player("Goofy");
        Player mickey = new Player("Mickey");
        Player goofyJr = new Player("Goofy");

        assertTrue(goofy.equals(goofyJr));
        assertTrue(goofy.equals(goofy));
        assertFalse(goofy.equals(mickey));
        assertFalse(goofy.equals(null));
    }

    @Test
    public void canReceiveCards() throws Exception {
        Player p = new Player("p1");
        assertThat(p.getCards().size(), is(0));
        p.addCard(ACE_OF_SPADES);
        assertThat(p.getCards().size(), is(1));
        assertThat(p.getCards().get(0), is(ACE_OF_SPADES));
    }
}