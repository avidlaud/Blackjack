package com.blackjack;

import java.util.ArrayList;

class Hand {

    private ArrayList<Integer> values = new ArrayList<Integer>();
    private ArrayList<Card> cards = new ArrayList<Card>();

    Hand(ArrayList<Card> cards) {
        for(Card card: cards) {
            addCard(card);
        }
    }

    Hand(Deck deck) {
        addCard(deck.draw());
        addCard(deck.draw());
    }

    Hand(){}

    public String toString() {
        boolean first = true;
        String s = "";
        for(Card card: cards) {
            /*First card*/
            if(first) {
                s = s.concat(card.toString());
                first = false;
            }
            else {
                s = s.concat(", " + card.toString());
            }
        }
        return s;
    }

    public void addCard(Card card) {
        cards.add(card);
        if (values.size() == 0) {
            values = card.getValues();
        } else {
            int numValues = values.size();
            ArrayList<Integer> newValues = card.getValues();
            /*Iterate through the existing values*/
            for (int i = 0; i < numValues; i++)  {
                Integer temp = values.remove(0);
                /*Iterate through the new card's values*/
                for (int j = 0; j < (newValues.size()); j++) {
                    values.add((newValues.get(j) + temp));
                }
            }
        }
    }

    /*
     * Function: getValue
     * Calculates the value of the hand
     * returns: the value of the hand, or -1 if "bust"
     */
    public int getValue() {
        int maxValue = -1;
        for(int val: values) {
            if(val > maxValue && val <= 21) {
                maxValue = val;
            }
        }
        return maxValue;
    }

    public Card getCard(int index) {
        if(index < (cards.size())) {
            return cards.get(index);
        }
        return null;
    }

    public int getSize() {
        return cards.size();
    }
}
