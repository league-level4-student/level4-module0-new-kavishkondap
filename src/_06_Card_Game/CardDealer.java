package _06_Card_Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class CardDealer {
    

    public static void main(String[] args) {
        ArrayList<Card> deck;
    	deck = new ArrayList ();
        boolean isPlaying = true;
        printInstructions();
        while (isPlaying) {
            int value;
            Scanner scan = new Scanner(System.in);
            int playerTotal = 0;
            int computerTotal = 0;
            boolean isDrawing = true;
            boolean isPlayerBusted = false;
            boolean isComputerBusted = false;
            boolean isBlackjack = false;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 13; j++) {
                	Card card = new Card (Rank.values()[j], Suit.values() [i]);
                	
                    deck.add(card);
                }
            }
            Collections.shuffle(deck);
            System.out.println("THIS IS THE SHUFFLED DECK");
            for (int i = 0; i < deck.size(); i++) {
                System.out.println(deck.get(i));
            }
            System.out.println("Your cards are: ");
            for (int i = 0; i < 2; i++) {
                System.out.println(deck.get(0));
                int cardVal;
                cardVal = deck.get(0).getRank().getValue();
                if (cardVal == 1) {
                    if ((playerTotal + 11) <= 21) {
                        cardVal = 11;
                    }
                }
                playerTotal += cardVal;
                deck.remove(0);
            }
            System.out.println("Your total is " + playerTotal);
            if (playerTotal == 21) {
                System.out.println("You got a blackjack!");
                isBlackjack = true;
            }
            //Get rid of this for final
            //System.out.println(deck2);
            System.out.println("The dealer's first card is " + deck.get(0));
            for (int i = 0; i < 2; i++) {
                //System.out.println(deck2.get(0));
                int cardVal;
                cardVal = deck.get(0).getRank ().getValue();
                if (cardVal == 1) {
                    if ((computerTotal + 11) < 21) {
                        cardVal = 11;
                    }
                }
                computerTotal += cardVal;
                deck.remove(0);
            }
            //Get rid of this for final
            //System.out.println("Total for computer is: " + computerTotal);
            //Get rid of this for final
            //System.out.println(deck2);
            if (!isBlackjack) {
                System.out.println("Would you like to take a card (hit or stand)");
                // scan.nextLine();
                String reader = scan.nextLine();
                while (isDrawing) {
                    if (reader.equalsIgnoreCase("hit")) {
                        System.out.println("Your next card is " + deck.get(0));
                        int cardVal;
                        cardVal = deck.get(0).getRank().getValue();
                        if (cardVal == 1) {
                            if ((playerTotal + 11) < 21) {
                                cardVal = 11;
                            }
                        }
                        playerTotal += cardVal;
                        deck.remove(0);
                        System.out.println("Your new total is " + playerTotal);
                        if (playerTotal > 21) {
                            System.out.println("Oh No!! You have gone bust!");
                            break;
                        }
                        if (playerTotal == 21) {
                            System.out.println("You are at 21! Your turn is over!");
                            break;
                        }
                        System.out.println("Type hit to take another card, or stand to stop");
                        reader = scan.nextLine();
                    } else if (reader.equalsIgnoreCase("stand")) {
                        System.out.println("You have chosen to stand");
                        isDrawing = false;
                    }else {
                        scan.nextLine();
                        System.out.println("ERROR");
                    }

                }
            }

            while (computerTotal <= 16) {
                System.out.println("The computer is taking a card");
                int cardVal;
                cardVal = deck.get(0).getRank().getValue();
                if (cardVal == 1) {
                    if ((computerTotal + 11) < 21) {
                        cardVal = 11;
                    }
                }
                computerTotal += cardVal;
                //Get rid of this for final
                //System.out.println("Computer total is " + computerTotal);
            }
            if (computerTotal >= 17) {
                System.out.println("The computer is choosing to stand");
            }
            if (playerTotal > 21) {
                isPlayerBusted = true;
            }
            if (computerTotal > 21) {
                isComputerBusted = true;
            }
            if (isPlayerBusted && isComputerBusted) {
                System.out.println("You both went bust! It is a tie!");
                System.out.println("Your final total was " + playerTotal + " and the computer had " + computerTotal);
            } else if (isPlayerBusted && !isComputerBusted) {
                System.out.println("YOU LOSE!!!");
                System.out.println("You went bust with a final score of " + playerTotal + " and the computer did not");
                System.out.println("The computer wins with a score of " + computerTotal);
            } else if (!isPlayerBusted && isComputerBusted) {
                System.out.println("You Win!!!!!");
                System.out.println("The computer went bust with a score of " + computerTotal);
                System.out.println("You had a final score of " + playerTotal);
            } else {
                if (playerTotal > computerTotal) {
                    System.out.println("You Win!!!");
                    System.out.println("Your score of " + playerTotal + " was more than the computer's " + computerTotal);
                } else if (computerTotal > playerTotal) {
                    System.out.println("You Lose!!!");
                    System.out.println("The computer had a total of " + computerTotal + " which was more than your " + playerTotal);
                } else {
                    System.out.println("You both had " + playerTotal + " so it is a tie");
                }
            }
            System.out.println("Would you like to play again?");
            String playAgain = scan.nextLine();
            if (playAgain.toLowerCase().contains("y")) {
                System.out.println("Ok!");
            } else {
                System.out.println("Ok!");
                isPlaying = false;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("This is blackjack! Your opponent is the computer!");
        System.out.println("How to play:");
        System.out.println("The goal of the game is to get as close to 21 as possible without going over");
        System.out.println("Your score is calculated by the sum of the values of the cards that you have");
        System.out.println("Face cards are worth 10, and an Ace is 11 at all times, unless it makes you go over 21, in which case it is worth 1");
        System.out.println("All other cards are worth their value");
        System.out.println("Type hit or stand to say if you want to take a card");
    }
}

