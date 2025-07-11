package arraylist;

import java.util.ArrayList;

public class ArrayListMain {


    public static void main(String[] args) {
        MyArrayList<Integer> a = new MyArrayList<>();
        MyArrayList<Integer> b = new MyArrayList<>();

        a.addAll(b);
    }

}
