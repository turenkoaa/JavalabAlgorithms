package com.epam.javalab.list;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<String> list= new MyLinkedList<>();

        list.insert("one");
        list.insert("two");
        list.insert("three");
        list.insert("four");
        list.insert("three");

        list.delete("three");

        System.out.println(list);
    }
}
