package ru.antonovmikhail.handmadesb;

public class MyStringBuilderState {

    private String text;

    private MyStringBuilder currentText = new MyStringBuilder();

    public MyStringBuilderState(String text) {
        this.text = text;
    }

    public MyStringBuilderState save() {
        return new MyStringBuilderState(currentText.toString());
    }
    public MyStringBuilder getSB() {
        return currentText;
    }
    public String getText() {
        return text;
    }

    public void add(String str){
        currentText.append(str);
    }

    public MyStringBuilder undo() {
        currentText = new MyStringBuilder(text);
        return currentText;
    }
}