package com.jonathanoliveira.game;

import com.google.common.collect.ImmutableList;
import com.jonathanoliveira.cards.Card;
import com.jonathanoliveira.cards.DeckOfCards;
import com.jonathanoliveira.ui.UserInterface;

import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toList;

public class HiLoGame {

    private final UserInterface ui;
    private final DeckOfCards deck;
    private final List<Player> players = newArrayList();
    private final Map<Player, Integer> wins = newHashMap();
    Player winner;

    public HiLoGame(UserInterface ui, DeckOfCards deck, String p1, String p2, String... otherPlayers) {
        checkNotNull(ui);
        checkNotNull(deck);
        checkArgument(!p1.equals(p2));

        this.ui = ui;
        this.deck = deck;

        players.add(new Player(p1));
        players.add(new Player(p2));

        for (String otherPlayer : otherPlayers) {
            if (otherPlayer == null)
                continue;

            Player p = new Player(otherPlayer);
            if (!players.contains(p))
                players.add(p);
        }
    }

    public void start(int rounds) {
        checkArgument(rounds >= 1);
        ui.notifyUser("starting game with " + players.size() + " players");
        ui.notifyUser("shuffling deck...");
        deck.suffle();

        for (int i = 1; i <= rounds; i++)
            playRound(i);

        winner = getWinner();
        ui.notifyUser("\nwinner of the game: " + winner);
    }

    private void playRound(int i) {
        ui.notifyUser("round #" + i);

        final Map<Player, Card> cardsOfRound = dealCards();

        final Card highestCard = cardsOfRound.entrySet().stream()
                .max(comparingByValue())
                .map(Map.Entry::getValue).orElseThrow(IllegalStateException::new);

        final List<Player> playersWithHighestCards = cardsOfRound.entrySet().stream()
                .filter(o -> o.getValue().getOrder().equals(highestCard.getOrder()))
                .map(Map.Entry::getKey)
                .collect(toList());

        if (playersWithHighestCards.size() > 1) {
            ui.notifyUser("draw! no winner on this round...");
            return;
        }

        ui.notifyUser("winner of the round: " + playersWithHighestCards.get(0));
        countWin(playersWithHighestCards.get(0));
    }

    private Map<Player, Card> dealCards() {
        final Map<Player, Card> cardsOfRound = newHashMap();
        for (Player player : players)
            cardsOfRound.put(player, deck.getCard());
        return cardsOfRound;
    }

    private void countWin(Player player) {
        checkNotNull(player);
        wins.putIfAbsent(player, 0);
        wins.put(player, wins.get(player) + 1);
    }

    private Player getWinner() {
        final Integer qtyWins = wins.entrySet().stream()
                .max(comparingByValue())
                .map(Map.Entry::getValue)
                .orElse(0);

        final List<Player> winners = wins.entrySet().stream()
                .filter(o -> o.getValue().equals(qtyWins))
                .map(Map.Entry::getKey)
                .collect(toList());

        if (winners.isEmpty() || winners.size() > 1)
            return null;

        return winners.get(0);
    }

    List<Player> getPlayers() {
        return ImmutableList.copyOf(players);
    }
}
