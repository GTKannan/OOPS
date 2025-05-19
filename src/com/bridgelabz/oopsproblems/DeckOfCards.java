package com.bridgelabz.oopsproblems;
import java.util.Random;

public class DeckOfCards {

    // Suits and Ranks
    private static final String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades" };
    private static final String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

    // Deck of 52 cards
    private static final String[] deck = new String[52];

    // 2D array for players [4 players][9 cards each]
    private static final String[][] playersCards = new String[4][9];


    // Shuffle using Fisher-Yates algorithm
    public static void shuffleDeck() {
        Random random = new Random();
        for (int i = 0; i < deck.length; i++) {
            int r = i + random.nextInt(deck.length - i);
            String temp = deck[i];
            deck[i] = deck[r];
            deck[r] = temp;
        }
    }

    public static void distributeCards() {
        int cardIndex = 0;
        for (int player = 0; player < 4; player++) {
            for (int card = 0; card < 9; card++) {
                playersCards[player][card] = deck[cardIndex++];
            }
        }
    }

    public static void printCards() {
        for (int player = 0; player < 4; player++) {
            System.out.println("\nPlayer " + (player + 1) + " cards:");
            for (int card = 0; card < 9; card++) {
                System.out.println("  - " + playersCards[player][card]);
            }
        }
    }

    public static void main(String[] args) {

        // Step 1: Initialize the deck
        int index = 0;
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck[index++] = rank + " of " + suit;
            }
        }

        // Step 2: Shuffle the deck
        shuffleDeck();

        // Step 3: Distribute 9 cards to 4 players
        distributeCards();

        // Step 4: Print cards received by each player
        printCards();
    }
}
