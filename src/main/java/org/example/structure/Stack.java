package org.example.structure;

import java.util.EmptyStackException;

public class Stack {

    private int[] storage;
    private int top;

    public Stack() {
        storage = new int[10];
    }

    public int push(int value) {
        if (top == storage.length) {
            throw new StackOverflowError();
        }
        storage[top++] = value;
        return value;
    }

    public boolean add(int value) {
        if (top == storage.length) {
            throw new StackOverflowError();
        }
        storage[top++] = value;
        return true;
    }

    public int pop() {
        if (top == 0) {
            throw new EmptyStackException();
        }
        return storage[--top];
    }

    public int remove(int index) { // 파라미터 index 값 삭제 후 index 후의 값 땡겨오기 return = 삭제한 value
        if ((index - 1) >= top) {
            throw new IndexOutOfBoundsException();
        }
        int res = storage[index - 1];
        for (int i = index - 1; i < top; i++) {
            storage[i] = storage[i + 1];
        }
        top--;
        return res;
    }

    public int peek() {
        return storage[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public boolean empty() {
        return top == 0;
    }

    public int search(int value) { // 파라미터 = 찾을 value return = top으로부터 몇 번째에 존재하는지 존재하지 않으면 -1
        int res = -1;
        for (int i = 0; i < top; i++) {
            if (storage[i] == value) {
                res = top - i - 1;
                break;
            }
        }
        return res;
    }

    public int set(int index, int value) { // 스택 값 변경 index의 값 변경, return = 변경 전 index 값
        if ((index - 1) >= top) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int res = storage[index - 1];
        storage[index - 1] = value;
        return res;
    }

    public int elementAt(int index) { // 파라미터 index의 값 반환
        if (index >= top) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return storage[index - 1];
    }

    public void clear() {
        top = 0;
    }

    public boolean contains(int value) {
        for (int i : storage) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}

