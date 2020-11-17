package org.epita.tp.serie3;


import org.epita.tp.serie3.exceptions.UnavailableCardException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Player {

    private String name;
    private Set<Card> hand;

    public Player(String name) {
        this.name = name;
        hand = new HashSet<>();
    }

    public void receiveCard(Card card) {
        hand.add(card);
    }

    public int handSize() {
        return hand.size();
    }


    public Card getCardFromNumber(int cardNumber) throws UnavailableCardException {
        for (Card card : hand) {
            if(card.getValue() == cardNumber){
                return card;
            }
        }
        throw new UnavailableCardException("No card numbered "+cardNumber+" present in your hand.");
    }

    public void discard(Card cardToDiscard) throws UnavailableCardException {
        if(!hand.contains(cardToDiscard)){
            throw new UnavailableCardException("No card "+cardToDiscard+" present in your hand.");
        }
        hand.remove(cardToDiscard);
    }

    @Override
    public String toString() {
        String playerRepresentation = name+ " : ";
        for (Card card : hand) {
            playerRepresentation += card;
        }
        playerRepresentation += "\n\r";
        return playerRepresentation;
    }

    public Set<Card> getHand() {
        return Collections.unmodifiableSet(hand);
    }

}
