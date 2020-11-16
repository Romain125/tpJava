package org.epita.tp.serie3;

import thegame.exceptions.NotAValidPlayException;
import thegame.exceptions.NotAValidStackException;
import thegame.exceptions.UnavailableCardException;

import java.util.Scanner;

public class Game {

    private final thegame.Deck deck;
    private final thegame.Table table;
    private final thegame.Player player;

    private final static int MAX_HAND_SIZE = 8;
    private boolean isLost = false;

    public Game() {
        this.deck = new thegame.Deck();
        this.table = new thegame.Table();
        player = createPlayer();
        replenishHand();
    }

    public void start() {
        while(!gameFinished()){
            playRound();
            replenishHand();
        }
//        calculateScore();
    }

    private void playRound() {
        int numberOfCardsPlayed = 0;
        
        boolean playerDecidedToEndHisTurn = false; //Do while?
        while(!playerDecidedToEndHisTurn){
            if(!isMinimumCardsPlayedReached(numberOfCardsPlayed) && !playerCanPlay()){
                isLost = true;
                return;
            }
            playACard();
            numberOfCardsPlayed++;

            if(isMinimumCardsPlayedReached(numberOfCardsPlayed)){
                playerDecidedToEndHisTurn = askIfPlayerWantToEndHisTurn();
            }

        }
    }

    private boolean playerCanPlay() {
        for (thegame.Card card : player.getHand()) {
            for (thegame.Stack stack : table.getStacks()) {
                if(stack.isAValidPlay(card)){
                    return true;
                }
            }
        }
        return false;
    }

    private void playACard() {
        boolean validPlay = false;
        while(!validPlay){ //Maybe a do while is more consistent here ?
            displayGame();
            int cardValue = askForCard();
            int stackNumber = askForStack();
            try {
                thegame.Card card = player.getCardFromNumber(cardValue);
                player.discard(card);
                table.playCard(stackNumber, card);
                validPlay = true;
            } catch (NotAValidPlayException | UnavailableCardException | NotAValidStackException e) {
                System.out.println("This is not a valid turn ! Reason is : "+e.getMessage());
            }
        }
    }

    private void displayGame() {
        System.out.println(deck);
        System.out.println(table);
        System.out.println(player);
    }

    private boolean askIfPlayerWantToEndHisTurn() {
        displayGame();
        while(true){
            System.out.println("Do you want to end your turn ? y/n");
            switch (stringInput().toLowerCase()){
                case("yes") :
                case("y") :
                    return true;
                case("no") :
                case("n") :
                    return false;
                default :
                    System.out.println("Please type 'yes' or 'no'");
            }
        }
    }

    private void replenishHand() {
        while(player.handSize() < MAX_HAND_SIZE) {
            giveCardToPlayer();
        }
    }

    private void giveCardToPlayer() {
        if(deck.hasARemainingCard()) {
            thegame.Card card = deck.draw();
            player.receiveCard(card);
        }
    }

    private boolean isMinimumCardsPlayedReached(int numberOfCardsPlayed) {
        int minimumCardsToPlay = 2;
        if(!deck.hasARemainingCard()){
            minimumCardsToPlay = 1;
        }
        return numberOfCardsPlayed >= minimumCardsToPlay;
    }

    private int askForStack() {
        System.out.println("Which stack do you want to play your card on ?");
        return integerInput();
    }

    private int askForCard() {
        System.out.println("Which card do you want to play ?");
        return integerInput();
    }

    private int integerInput(){
        Integer input = null;
        while(input == null){
            try {
                input = Integer.parseInt(stringInput());
            }catch(NumberFormatException e){
                System.out.println("Please enter a number.");
            }
        }
        return input;
    }
    
    private String stringInput() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    private thegame.Player createPlayer() {
        System.out.println("Please enter your name : ");
        String playerName = stringInput();
        return new thegame.Player(playerName);
    }

    private boolean gameFinished() {
        return isWon() || isLost();
    }

    private boolean isLost() {
        return isLost;
    }

    private boolean isWon() {
        return !deck.hasARemainingCard() && player.handSize()==0;
    }
}
