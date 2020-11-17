package org.epita.tp.serie3;

import org.epita.tp.serie3.exceptions.NotAValidPlayException;
import org.epita.tp.serie3.exceptions.NotAValidStackException;

public class Table {

    private final Stack[] stacks;

    public Table() {
        stacks = new Stack[4];
        stacks[0] = new Stack(StackOrder.ASCENDING, new Card(1));
        stacks[1] = new Stack(StackOrder.ASCENDING, new Card(1));
        stacks[2] = new Stack(StackOrder.DESCENDING, new Card(99));
        stacks[3] = new Stack(StackOrder.DESCENDING, new Card(99));
    }

    @Override
    public String toString() {
        String tableRepresenation = "";
        for (int i = 0; i < stacks.length; i++) {
            tableRepresenation += i+1+": ";
            tableRepresenation += stacks[i];
            tableRepresenation += "\n\r";
        }
        return tableRepresenation;
    }

    public boolean hasStack(int stackNumber) {
        return stackNumber>0 && stackNumber <= stacks.length;
    }

    public void playCard(int stackNumber, Card card) throws NotAValidStackException, NotAValidPlayException {
        if(!hasStack(stackNumber)){
            throw new NotAValidStackException(stackNumber+" in not a valid stack number");
        }
        stacks[stackNumber-1].playCard(card);
    }

    public Stack[] getStacks() {
        return stacks;
    }
}
