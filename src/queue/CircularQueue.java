package queue;

public class CircularQueue<T> {
    private T[] arr;
    private int front, rear, size;

    CircularQueue(int size) {
        this.size = size;
        arr = (T[]) new Object[size];
        front = rear = -1;
    }

    void enqueue(T val) {
        if (!isFull()) {
            if (isEmpty()) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = val;
        }
    }

    T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T val = arr[front];
        if (front == rear) {
            rear = front = -1;
        } else {
            front = (front + 1) % size;
        }
        return val;
    }

    boolean isEmpty() {
        return front == -1;
    }

    boolean isFull() {
        return (rear + 1) % size == front;
    }


    T rear() {
        if (isEmpty()) {
            return null;
        }
        return arr[rear];
    }

    T front() {
        if (isEmpty()) {
            return null;
        }
        return arr[front];
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        String s = "[";
        for (int i = front; ; i = (i + 1) % size) {
            s += arr[i];
            if (i == rear) {
                break;
            }
            s += ", ";
        }
        return s + "]";
    }
}
