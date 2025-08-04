package stack;

import java.util.EmptyStackException;

public class MyStack<T> {

    private T arr[];
    private int size;

    MyStack() {
        size = 0;
        arr = (T[]) new Object[5];
    }

    void push(T val) {
        if (size == arr.length) {
            resize();
        }
        arr[size++] = val;
    }

    void resize() {
        T[] newArray = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }
        arr = newArray;
    }

    boolean isEmpty() {
        return size == 0;
    }

    T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[size - 1];
    }

    T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[--size];
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            s.append(arr[i]);
            if (i != size - 1) {
                s.append(", ");
            }
        }
        s.append("]");
        return s.toString();
    }
}
