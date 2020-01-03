package com.blackjack;

class Dealer {

    private Hand dealerHand;
    private int handValue;

    Dealer(Deck deck) {
        this.dealerHand = new Hand(deck);
    }

    int play(Deck deck) {
        handValue = dealerHand.getValue();
        while(handValue < 17 && dealerHand.getSize() < 5) {
            /*Check if bust*/
            if(handValue == -1) {
                break;
            }
            dealerHand.addCard(deck.draw());
            handValue = dealerHand.getValue();
        }
        return handValue;
    }

    public Hand showHand() {
        return dealerHand;
    }

    public Card showFaceUp () {
        return dealerHand.getCard(0);
    }
}
