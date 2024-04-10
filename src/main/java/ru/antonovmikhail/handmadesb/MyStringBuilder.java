package ru.antonovmikhail.handmadesb;

import java.util.Arrays;

public class MyStringBuilder {

    private static final int INITIAL_CAPACITY = 16;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 16;
    char[] charArray = new char[INITIAL_CAPACITY];

    int charCount = 0;

    public MyStringBuilder() {
    }

    public MyStringBuilder(String text) {
        append(text);
    }

    public MyStringBuilder(char[] text) {
        charArray = text;
    }

    public void append(String str) {
        if ((charCount + 16) < charArray.length) {
            for (char c : str.toCharArray()) {
                charArray[charCount++] = c;
            }
        } else {
            int newLength = charArray.length + INITIAL_CAPACITY;
            if (newLength >= MAX_ARRAY_SIZE) {
                throw new OutOfMemoryError("Required length exceeds implementation limit");
            }
            charArray = Arrays.copyOf(charArray, newLength);
            append(str);
        }
    }

    public String toString() {
        char[] chars = new char[charCount];
        System.arraycopy(charArray, 0, chars, 0, charCount);
        return new String(chars);
    }

}
