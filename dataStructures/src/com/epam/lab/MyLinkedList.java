package com.epam.lab;

public class MyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    private class Node<T> {
        T value;
        Node<T> next;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public int getSize() {
        return size;
    }

    public void insert(T value){
        Node<T> node = new Node<>(value, null);

        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public T get(int index) {
        if (index > size) {
            throw new IllegalArgumentException("Index is out of range.");
        }

        Node<T> current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.value;
    }

    public boolean delete(T value){

        if (size <= 0) {
            return false;
        }

        if (value.equals(head.value)) {
            head = head.next;
        }

        Node<T> previous = head;
        Node<T> current = previous.next;
        while (current != tail) {
            if (value.equals(current.value)) {
                previous.next = current.next;
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }

        if (value.equals(current.value)) {
            previous.next = null;
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        for (int i = 0; i < size - 1; i++) {
            sb.append(current.value.toString()).append(", ");
            current = current.next;
        }
        sb.append(current.value.toString()).append("]");

        return sb.toString();
    }
}
