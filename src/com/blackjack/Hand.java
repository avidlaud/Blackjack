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

    public void addCard(Card card) {
        cards.add(card);
        if (values.size() == 0) {
            values = card.getValues();
        } else {
            int numValues = values.size();
            ArrayList<Integer> newValues = card.getValues();
            /*Iterate through the existing values*/
            for (int i = 1; i < numValues; i++)  {
                Integer temp = values.remove(0);
                /*Iterate through the new card's values*/
                for (int j = 0; j < (newValues.size() - 1); j++) {
                    values.add(newValues.get(j) + temp);
                }
            }
        }
    }

    public int getValue() {
        int maxValue = 0;
        for(int val: values) {
            if(val > maxValue && val <= 21) {
                maxValue = val;
            }
        }
        return maxValue;
    }
}
