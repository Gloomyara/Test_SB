package ru.antonovmikhail.handmadesb;

import java.util.EmptyStackException;
import java.util.Stack;


public class MyStringBuilderState {

    private Stack<String> textStack = new Stack<>();
    private MyStringBuilder currentText = new MyStringBuilder();

    public void save() {
        textStack.push(currentText.toString());
    }
    public MyStringBuilder getSB() {
        return currentText;
    }

    public MyStringBuilderState add(String str){
        currentText.append(str);
        save();
        return this;
    }

    public MyStringBuilderState undo() {
        try {
            textStack.pop();
            currentText = new MyStringBuilder(textStack.peek());
            return this;
        } catch (EmptyStackException e){
            currentText = new MyStringBuilder();
            return this;
        }
    }

    @Override
    public String toString() {
        return currentText.toString();
    }
}