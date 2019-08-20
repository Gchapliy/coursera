package algorithms.week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> head;
    private Node<Item> tail;
    private int size = 0;

    // construct an empty deque
    public Deque() {
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();

        if (head == null) {
            head = new Node<>(null, null, item);
            tail = head;
        } else {
            Node<Item> node = new Node<>(null, head, item);
            head.prev = node;
            head = node;
        }

        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();

        if (head == null) {
            head = new Node<>(null, null, item);
            tail = head;
        } else {
            Node<Item> node = new Node<>(tail, null, item);
            tail.next = node;
            tail = node;
        }

        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if(size == 0) throw new NoSuchElementException();

        Item item = head.value;
        head = head.next;
        size--;

        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if(size == 0) throw new NoSuchElementException();

        Item item = tail.value;
        tail = tail.prev;
        tail.next = null;
        size--;

        return item;
    }

    // return an iterator over items in order from front to back
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

    private class Node<Item> {
        private Node<Item> prev;
        private Item value;
        private Node<Item> next;

        private Node(Node<Item> prev, Node<Item> next, Item value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        for (int i = 0; i < 5; i++) {
            deque.addLast(i);
        }

        System.out.println("remove: " + deque.removeLast());

        for (Integer i : deque) {
            System.out.println(i);
        }
    }

}
