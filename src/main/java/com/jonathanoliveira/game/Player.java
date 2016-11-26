package com.jonathanoliveira.game;

import com.google.common.collect.ImmutableList;
import com.jonathanoliveira.cards.Card;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.collect.Lists.newArrayList;

public class Player {

    private final String name;
    private final List<Card> cards = newArrayList();

    public Player(final String name) {
        checkArgument(!isNullOrEmpty(name));
        this.name = name;
    }

    Player addCard(Card card) {
        checkNotNull(card);
        this.cards.add(card);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Player player = (Player) o;

        return name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }

    String getName() {
        return name;
    }

    List<Card> getCards() {
        return ImmutableList.copyOf(cards);
    }
}
