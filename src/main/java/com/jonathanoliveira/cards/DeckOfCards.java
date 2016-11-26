package com.jonathanoliveira.cards;

import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class DeckOfCards {

    final List<Card> cards = newArrayList(Card.values());

    public void suffle() {
        Collections.shuffle(cards);
    }

    public Card getCard() {
        if (cards.isEmpty())
            throw new EmptyDeckException();

        return cards.remove(0);
    }

    class EmptyDeckException extends RuntimeException {
    }
}
