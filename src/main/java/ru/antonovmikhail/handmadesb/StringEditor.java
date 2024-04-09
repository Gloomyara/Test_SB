package ru.antonovmikhail.handmadesb;

public class StringEditor {

    private MyStringBuilderWindow textWindow;

    private MyStringBuilderState savedTextWindow;

    public StringEditor(MyStringBuilderWindow textWindow) {
        this.textWindow = textWindow;
    }

    public void hitSave() {
        savedTextWindow = textWindow.save();
    }

    public void hitUndo() {
        textWindow.restore(savedTextWindow);
    }
}