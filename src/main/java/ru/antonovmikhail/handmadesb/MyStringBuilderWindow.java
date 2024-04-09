package ru.antonovmikhail.handmadesb;

public class MyStringBuilderWindow {

    private MySB currentState;

    public MyStringBuilderWindow() {
        this.currentState = new MySB();
    }

    public void addText(String text) {
        currentState.append(text);
    }

    public MyStringBuilderState save() {
        return new MyStringBuilderState(currentState.toString());
    }

    public void restore(MyStringBuilderState save) {
        currentState = new MySB(save.getText());
    }
}