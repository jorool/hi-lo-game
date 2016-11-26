package com.jonathanoliveira;

import com.jonathanoliveira.cards.DeckOfCards;
import com.jonathanoliveira.game.HiLoGame;
import com.jonathanoliveira.ui.CommandLine;

public class Main {

    public static void main(String[] args) {
        new HiLoGame(new CommandLine(),  new DeckOfCards(), "Mickey", "Goofy").start(5);
    }

}
