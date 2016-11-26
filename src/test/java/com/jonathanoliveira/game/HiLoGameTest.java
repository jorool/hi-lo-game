package com.jonathanoliveira.game;

import com.jonathanoliveira.cards.DeckOfCards;
import com.jonathanoliveira.ui.UserInterface;
import org.junit.Test;

import static com.jonathanoliveira.cards.Card.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HiLoGameTest {

    private final UserInterface ui = mock(UserInterface.class);
    private final DeckOfCards deck = new DeckOfCards();

    @Test
    public void canCreateGameWith2Players() throws Exception {
        final HiLoGame game = newGame("p1", "p2");
        assertThat(game.getPlayers().size(), is(2));
    }

    @Test
    public void canCreateGameWith3OrMorePlayers() throws Exception {
        final HiLoGame game1 = new HiLoGame(ui, deck, "p1", "p2", "p3");
        assertTrue(game1.getPlayers().size() == 3);

        final HiLoGame game2 = new HiLoGame(ui, deck, "p1", "p2", "p3", "p4");
        assertTrue(game2.getPlayers().size() == 4);
    }

    @Test
    public void ignoreNullPlayers() throws Exception {
        final HiLoGame game = new HiLoGame(ui, deck, "p1", "p2", "p3", null, "p4", null);
        assertThat(game.getPlayers().size(), is(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void cantCreateGameWithOnePlayer() throws Exception {
        newGame("p1", "p1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cantStarGameWithNegativeRounds() throws Exception {
        newGame("p1", "p2").start(-1);
    }

    @Test
    public void verifyWinnerOfOneRound() throws Exception {
        final DeckOfCards deck = mock(DeckOfCards.class);
        when(deck.getCard()).thenReturn(ACE_OF_CLUBS, THREE_OF_SPADES);

        final HiLoGame game = new HiLoGame(ui, deck, "p1", "p2");
        game.start(1);

        assertThat(game.getWinner().getName(), is("p2"));
    }

    @Test
    public void verifyWinnerOfThreeRounds() throws Exception {
        final DeckOfCards deck = mock(DeckOfCards.class);
        when(deck.getCard()).thenReturn(
                ACE_OF_CLUBS,
                THREE_OF_CLUBS,
                THREE_OF_HEARTS,
                TWO_OF_DIAMONDS,
                SEVEN_OF_SPADES,
                SIX_OF_DIAMONDS
        );

        final HiLoGame game = new HiLoGame(ui, deck, "p1", "p2");
        game.start(3);

        assertThat(game.getWinner().getName(), is("p1"));
    }

    @Test
    public void verifyDrawInOneRound() throws Exception {
        final DeckOfCards deck = mock(DeckOfCards.class);
        when(deck.getCard()).thenReturn(ACE_OF_CLUBS, ACE_OF_SPADES);

        final HiLoGame game = new HiLoGame(ui, deck, "p1", "p2");
        game.start(1);

        assertThat(game.getWinner(), is(nullValue()));
    }

    @Test
    public void verifyOneDrawAndOneWin() throws Exception {
        final DeckOfCards deck = mock(DeckOfCards.class);
        when(deck.getCard()).thenReturn(
                THREE_OF_CLUBS,
                FIVE_OF_DIAMONDS,
                ACE_OF_SPADES,
                ACE_OF_CLUBS
        );

        final HiLoGame game = new HiLoGame(ui, deck, "p1", "p2");
        game.start(2);

        assertThat(game.getWinner().getName(), is("p2"));
    }

    @Test
    public void verifyOneDrawAndOneWinEach() throws Exception {
        final DeckOfCards deck = mock(DeckOfCards.class);
        when(deck.getCard()).thenReturn(
                THREE_OF_CLUBS,
                FIVE_OF_DIAMONDS,
                ACE_OF_SPADES,
                ACE_OF_CLUBS,
                TEN_OF_HEARTS,
                TWO_OF_CLUBS
        );

        final HiLoGame game = new HiLoGame(ui, deck, "p1", "p2");
        game.start(3);

        assertThat(game.getWinner(), is(nullValue()));
    }

    private HiLoGame newGame(String player1, String player2) {
        return new HiLoGame(ui, deck, player1, player2);
    }
}