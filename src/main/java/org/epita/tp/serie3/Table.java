package org.epita.tp.serie3;

import thegame.exceptions.NotAValidPlayException;
import thegame.exceptions.NotAValidStackException;

public class Table {

    private final thegame.Stack[] stacks;

    public Table() {
        stacks = new thegame.Stack[4];
        stacks[0] = new thegame.Stack(thegame.StackOrder.ASCENDING, new thegame.Card(1));
        stacks[1] = new thegame.Stack(thegame.StackOrder.ASCENDING, new thegame.Card(1));
        stacks[2] = new thegame.Stack(thegame.StackOrder.DESCENDING, new thegame.Card(99));
        stacks[3] = new thegame.Stack(thegame.StackOrder.DESCENDING, new thegame.Card(99));
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

    public void playCard(int stackNumber, thegame.Card card) throws NotAValidStackException, NotAValidPlayException {
        if(!hasStack(stackNumber)){
            throw new NotAValidStackException(stackNumber+" in not a valid stack number");
        }
        stacks[stackNumber-1].playCard(card);
    }

    public thegame.Stack[] getStacks() {
        return stacks;
    }
}
