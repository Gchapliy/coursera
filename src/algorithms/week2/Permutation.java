package algorithms.week2;

import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args) {

        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        Integer rowsCount = Integer.parseInt(args[0]);

        for (int i = 0; i < rowsCount; i++) {
            randomizedQueue.enqueue(StdIn.readString());
        }

        for (int i = 0; i < rowsCount; i++) {
            System.out.println(randomizedQueue.dequeue());
        }


    }
}
