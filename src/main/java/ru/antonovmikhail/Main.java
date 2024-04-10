package ru.antonovmikhail;


import ru.antonovmikhail.handmadesb.MyStringBuilderState;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        MyStringBuilderState sb = new MyStringBuilderState();
        sb.add("last string").add(" another string").add(" first one");
        String out = sb.toString();
        System.out.println(out);
        out = sb.undo().toString();
        System.out.println(out);
        System.out.println(sb.undo().toString());
    }
}