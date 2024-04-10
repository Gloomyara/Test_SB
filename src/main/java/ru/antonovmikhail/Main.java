package ru.antonovmikhail;


import ru.antonovmikhail.handmadesb.MyStringBuilder;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        MyStringBuilder sb = new MyStringBuilder();
        sb.append("last string").append(" another string").append(" first one");
        String out = sb.toString();
        System.out.println(out);
        out = sb.undo().toString();
        System.out.println(out);
        System.out.println(sb.append(" smthn"));
        out = sb.undo().toString();
        System.out.println(out);
        System.out.println(sb.undo());
        System.out.println(sb.undo() + "null");
    }
}