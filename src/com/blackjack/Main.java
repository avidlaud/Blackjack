package com.blackjack;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while(true) {
            Deck deck = new Deck();
            deck.shuffleDeck();
            Hand playerHand = new Hand(deck);
            Dealer dealer = new Dealer(deck);

            System.out.println("The dealer's top card is: " + dealer.showFaceUp());

            boolean finished = true;
            String input;
            int dealerValue;
            do {
                System.out.println("Your hand is: " + playerHand);
                /*Bust*/
                if(playerHand.getValue() == -1) {
                    System.out.println("You busted! Enter 'R' to replay or anything else to exit");
                    input = in.nextLine();
                    if(input.equals("R") || input.equals("r")) {
                        break;
                    }
                    return;
                }
                /*Blackjack*/
                if(playerHand.getValue() == 21) {
                    System.out.println("You won! Enter 'R' to replay or anything else to exit");
                    input = in.nextLine();
                    if(input.equals("R") || input.equals("r")) {
                        break;
                    }
                    return;
                }
                System.out.println("Enter:\nH to hit\nS to stay");
                input = in.nextLine();
                switch (input) {
                    case "H":
                    case "h":
                        //fall through
                        playerHand.addCard(deck.draw());
                        break;
                    case "S":
                    case "s":
                        //fall through
                        finished = false;
                        dealerValue = dealer.play(deck);
                        System.out.println("Dealer's hand: " + dealer.showHand());
                        if(dealerValue >= playerHand.getValue()) { //Lost
                            System.out.println("You lost! Enter 'R' to replay or anything else to exit");
                        }
                        else {
                            System.out.println("You won! Enter 'R' to replay or anything else to exit");
                        }
                        input = in.nextLine();
                        if(input.equals("R") || input.equals("r")) {
                            break;
                        }
                        return;
                    default:
                        System.out.println("Incorrect Input");
                }
            } while(finished);
        }
    }
}
