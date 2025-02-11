package org.example.structure;

public interface Deque {

    void add(int value);
    void addFirst(int value);
    void addLast(int value);
    boolean offer(int value);
    boolean offerFirst(int value);
    boolean offerLast(int value);

    int remove();
    int removeFirst();
    int removeLast();
    int poll();
    int pollFirst();
    int pollLast();

    int getFirst();
    int getLast();
    int peek();
    int peekFirst();
    int peekLast();

    boolean contain(int value);
    int size();
}


