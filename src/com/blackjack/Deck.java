package com.blackjack;

import java.util.ArrayList;
import java.util.Collections;

class Deck {

    private final static int NUMBER_OF_SUITS = 4;
    private final static int NUMBER_OF_RANKS = 13;

    private ArrayList<Card> deck = new ArrayList<Card>();

    Deck() {
        for(int i = 0; i < (NUMBER_OF_SUITS - 1); i++) {
            for(int j = 0; j < (NUMBER_OF_RANKS - 1); j++) {
                deck.add(new Card(i, j));
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public Card draw() {
        if(!deck.isEmpty()) {
            return deck.remove(0);
        }
        return null;
    }

    public int deckSize() {
        return deck.size();
    }

}
