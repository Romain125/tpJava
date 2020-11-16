package org.epita.tp.serie3;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {

    private LinkedList<Card> cards;

    public Deck(){
        this.cards = initializeDeck();
    }

    private LinkedList<Card> initializeDeck() {
        LinkedList<Card> cards = new LinkedList<>();
        for (int i = 2; i < 99; i++) {
            cards.addLast(new Card(i));
        }

//        LinkedList<Integer> cards = IntStream.range(2, 99)
//                .boxed()
//                .collect(Collectors.toCollection(LinkedList::new));

        shuffle(cards);
        return cards;
    }

    private void shuffle(LinkedList<Card> cards) {
        Collections.shuffle(cards);
    }

    public boolean hasARemainingCard(){
        return !cards.isEmpty();
    }

    public Card draw(){
        return cards.removeFirst();
    }

    @Override
    public String toString() {
        return "Deck : [[[[["+cards.size()+"]";
    }
}
