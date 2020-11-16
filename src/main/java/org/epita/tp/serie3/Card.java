package org.epita.tp.serie3;

public class Card {

    private final int value;

    public Card(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "["+value+"]";
    }
}
