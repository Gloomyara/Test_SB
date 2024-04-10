package ru.antonovmikhail.handmadesb;

import java.util.Arrays;

public class MyStringBuilder {

    static final int INITIAL_CAPACITY = 16;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 1;
    private char[] charArray = new char[INITIAL_CAPACITY];
    private MyStringBuilderState state = new MyStringBuilderState();
    int charCount = 0;

    public MyStringBuilder() {
    }

    public MyStringBuilder(String text) {
        append(text);
    }

    public MyStringBuilder append(String str) {
        appendWoSave(str);
        save();
        return this;
    }

    private void appendWoSave(String str) {
        if ((charCount + str.length()) < charArray.length) {
            for (char c : str.toCharArray()) {
                charArray[charCount++] = c;
            }
        } else {
            if (charArray.length >= MAX_ARRAY_SIZE / 2) {
                throw new OutOfMemoryError("Required length exceeds implementation limit");
            }
            int newLength = charArray.length * 2;
            charArray = Arrays.copyOf(charArray, newLength);
            appendWoSave(str);
        }
    }

    private void save() {
        state.save(toString());
    }

    public MyStringBuilder undo() {
        String str = state.undo();
        charCount = str.length();
        charArray = Arrays.copyOf(
                str.toCharArray(),
                (charCount > INITIAL_CAPACITY) ? ((charCount / INITIAL_CAPACITY + 1) * INITIAL_CAPACITY) :
                        INITIAL_CAPACITY
        );
        return this;
    }

    public String toString() {
        char[] chars = new char[charCount];
        System.arraycopy(charArray, 0, chars, 0, charCount);
        return new String(chars);
    }
}
