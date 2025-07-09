package arraylist;

public class MyArrayList {

    private int arr[];
    private int size;

    public MyArrayList() {
        arr = new int[5];
        size = 0;
    }

    public MyArrayList(int capacity) {
        arr = new int[capacity];
        size = 0;
    }

    public void add(int val) {
        if (size == arr.length) { // is Full
            resize();
        }
        arr[size++] = val;
    }

    public int set(int index, int val) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int oldValue = arr[index];
        arr[index] = val;
        return oldValue;
    }

    public void resize() {
        int temp[] = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public int size() {
        return size;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return arr[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        String res = "[";
        for (int i = 0; i < size; i++) {
            res += arr[i];
            if (i != size - 1) {
                res += ", ";
            }
        }
        return res + "]";
    }
}
