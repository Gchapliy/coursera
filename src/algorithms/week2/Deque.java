package algorithms.week2;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> head;
    private Node<Item> tail;
    private Node<Item> current;
    private int size = 0;

    // construct an empty deque
    public Deque() {
        head = new Node<>(null, null, null);
        tail = new Node<>(head, head, null);
        head.next = tail;
        head.prev = tail;
        current = head;
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
        head = new Node<>(head, tail, item);
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        tail = new Node<>(tail, head, item);
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        Item item = head.value;
        head = head.prev;
        size--;

        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        Item item = tail.value;
        tail = tail.prev;
        size--;

        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            @Override
            public boolean hasNext() {
                return current.next.value != null;
            }

            @Override
            public Item next() {
                current = current.next;
                return current.value;
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
        Deque<Integer> deque = new Deque<>();
        for (int i = 0; i < 5; i++) {
            deque.addFirst(i);
        }

        for (Integer i: deque) {
            System.out.println(i);
        }
    }

}
