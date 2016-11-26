package com.jonathanoliveira.cards;

public enum Card {

    ACE_OF_CLUBS(0),
    TWO_OF_CLUBS(1),
    THREE_OF_CLUBS(2),
    FOUR_OF_CLUBS(3),
    FIVE_OF_CLUBS(4),
    SIX_OF_CLUBS(5),
    SEVEN_OF_CLUBS(6),
    EIGHT_OF_CLUBS(7),
    NINE_OF_CLUBS(8),
    TEN_OF_CLUBS(9),
    JACK_OF_CLUBS(10),
    QUEEN_OF_CLUBS(11),
    KING_OF_CLUBS(12),

    ACE_OF_DIAMONDS(0),
    TWO_OF_DIAMONDS(1),
    THREE_OF_DIAMONDS(2),
    FOUR_OF_DIAMONDS(3),
    FIVE_OF_DIAMONDS(4),
    SIX_OF_DIAMONDS(5),
    SEVEN_OF_DIAMONDS(6),
    EIGHT_OF_DIAMONDS(7),
    NINE_OF_DIAMONDS(8),
    TEN_OF_DIAMONDS(9),
    JACK_OF_DIAMONDS(10),
    QUEEN_OF_DIAMONDS(11),
    KING_OF_DIAMONDS(12),

    ACE_OF_HEARTS(0),
    TWO_OF_HEARTS(1),
    THREE_OF_HEARTS(2),
    FOUR_OF_HEARTS(3),
    FIVE_OF_HEARTS(4),
    SIX_OF_HEARTS(5),
    SEVEN_OF_HEARTS(6),
    EIGHT_OF_HEARTS(7),
    NINE_OF_HEARTS(8),
    TEN_OF_HEARTS(9),
    JACK_OF_HEARTS(10),
    QUEEN_OF_HEARTS(11),
    KING_OF_HEARTS(12),

    ACE_OF_SPADES(0),
    TWO_OF_SPADES(1),
    THREE_OF_SPADES(2),
    FOUR_OF_SPADES(3),
    FIVE_OF_SPADES(4),
    SIX_OF_SPADES(5),
    SEVEN_OF_SPADES(6),
    EIGHT_OF_SPADES(7),
    NINE_OF_SPADES(8),
    TEN_OF_SPADES(9),
    JACK_OF_SPADES(10),
    QUEEN_OF_SPADES(11),
    KING_OF_SPADES(12);

    private final Integer order;

    Card(Integer order) {
        this.order = order;
    }

    public Integer getOrder() {
        return order;
    }
}
