package org.epita.tp.serie3;

import thegame.exceptions.NotAValidPlayException;

public class Stack {

    private StackOrder order;
    private Card card;

    public Stack(StackOrder order, Card card) {
        this.order = order;
        this.card = card;
    }

    public void playCard(Card card) throws NotAValidPlayException {
        if(!isAValidPlay(card)){
            throw new NotAValidPlayException("Playing "+card+" on "+order+" stack topped with "+this.card+" is not a valid play !");
        }
        this.card = card;
    }

    public boolean isAValidPlay(Card card) {
        if(order == StackOrder.ASCENDING){
            if(card.getValue() < this.card.getValue() && this.card.getValue()-card.getValue() != 10){
                return false;
            }
        }
        else if(order == StackOrder.DESCENDING){
            if(card.getValue() > this.card.getValue() && card.getValue()-this.card.getValue() != 10){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return " [" + card.getValue() +"] ("+order+")";
    }
}
