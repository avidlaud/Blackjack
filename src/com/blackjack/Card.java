package com.blackjack;

import java.util.ArrayList;

class Card {

    private int suit;
    private int rank;
    private ArrayList<Integer> values = new ArrayList<Integer>();

    private final static String[] suits= {"Hearts", "Diamonds", "Spades", "Clubs"};
    private final static String[] ranks= {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Jack", "Queen", "King"};

    Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
        switch(rank) {
            case 0: //Ace
                values.add(1);
                values.add(11);
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                values.add(rank+1);
                //fall through
                break;
            case 9:
            case 10:
            case 11:
            case 12:
                values.add(10);
                //fall through
                break;
            default:
        }
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

    public ArrayList<Integer> getValues() {
        return values;
    }
}
