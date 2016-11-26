package com.jonathanoliveira.cards;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DeckOfCardsTest {

    @Test
    public void newDeckShouldHave52Cards() throws Exception {
        assertThat(new DeckOfCards().cards.size(), is(52));
    }

    @Test
    public void getCardShouldReturnOneCard() throws Exception {
        assertThat(new DeckOfCards().getCard(), is(instanceOf(Card.class)));
    }

    @Test
    public void canGet52CardsFromDeck() throws Exception {
        final DeckOfCards deck = new DeckOfCards();
        for (int i = 0; i <= 51; i++)
            assertThat(deck.getCard(), is(instanceOf(Card.class)));
    }

    @Test(expected = DeckOfCards.EmptyDeckException.class)
    public void getMoreThan52CardsShouldThrowException() throws Exception {
        final DeckOfCards deck = new DeckOfCards();
        for (int i = 0; i <= 52; i++)
            assertThat(deck.getCard(), is(instanceOf(Card.class)));
    }

    @Test
    public void shuffleShouldAlterCardsOrder() throws Exception {
        final DeckOfCards deck = new DeckOfCards();

        Card firstCard = deck.cards.get(0);
        deck.suffle();
        assertThat(deck.cards.get(0), is(not(firstCard)));

        firstCard = deck.cards.get(0);
        deck.suffle();
        assertThat(deck.cards.get(0), is(not(firstCard)));
    }
}