package com.blackjack;

class Card {

    private int suit;
    private int rank;

    private final static String[] suits= {"Hearts", "Diamonds", "Spades", "Clubs"};
    private final static String[] ranks= {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Jack", "Queen", "King"};

    Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String toString() {
        return ranks[rank] + " of " + suits[suit];
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }
}
