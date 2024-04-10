package ru.antonovmikhail.handmadesb;

import java.util.EmptyStackException;
import java.util.Stack;


public class MyStringBuilderState {

    private Stack<String> textStack = new Stack<>();

    public void save(String text) {
        textStack.push(text);
    }

    public String undo() {
        try {
            textStack.pop();
            return textStack.peek();
        } catch (EmptyStackException e){
            return "";
        }
    }
}