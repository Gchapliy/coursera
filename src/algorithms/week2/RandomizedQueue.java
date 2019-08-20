package algorithms.week2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Node<Item> head;
    private Node<Item> tail;
    private int size = 0;

    // construct an empty randomized queue
    public RandomizedQueue() {
    }

    // is the randomized queue empty?
    public boolean isEmpty() {

        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if(item == null) throw new IllegalArgumentException();

        if(head == null){
            head = new Node<>(null, null, item);
            tail = head;
        } else {
            Node<Item> node = new Node<>(tail, null, item);
            tail.next = node;
            tail = node;
        }

        size++;
    }

    // remove and return a random item
    public Item dequeue() {
        if(size == 0) throw new NoSuchElementException();

        int position = StdRandom.uniform(size);
        Node<Item> current = head;
        Item item = null;

        if(position == 0){
            item = head.value;
            head = head.next;
        }else if(position == size - 1){
            item = tail.value;
            tail = tail.prev;
            tail.next = null;
        }else {
            for (int i = 0; i < position; i++) {
                head = head.next;
            }

            item = head.value;
            head.prev.next = head.next;
            head = null;
            head = current;
        }

        size--;

        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if(size == 0) throw new NoSuchElementException();

        return null;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node<Item> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                Item item = current.value;

                if(item == null) throw new NoSuchElementException();

                current = current.next;
                return item;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private class Node<Item>{
        private Node<Item> prev;
        private Item value;
        private Node<Item> next;

        private Node(Node<Item> prev, Node<Item> next, Item value){
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue();
        for (int i = 0; i < 5; i++) {
            randomizedQueue.enqueue(i);
        }

        for (Integer i : randomizedQueue) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("removed: " + randomizedQueue.dequeue());

        for (Integer i : randomizedQueue) {
            System.out.print(i + " ");
        }
    }
}
