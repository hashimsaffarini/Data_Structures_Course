package arraylist;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListMain {


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(10,20,30)));
        list.add(new ArrayList<>(Arrays.asList(10,20,30)));
        list.add(new ArrayList<>(Arrays.asList(10,20,30)));


        System.out.println(list);

    }

}
