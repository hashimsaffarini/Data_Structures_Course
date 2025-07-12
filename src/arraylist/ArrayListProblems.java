package arraylist;

import java.util.ArrayList;

public class ArrayListProblems {


    static void rotateLeftToRight(ArrayList<Integer> a) {
        a.add(a.remove(0));
    }

    static void rotateRightToLeft(ArrayList<Integer> a) {
        a.add(0, a.remove(a.size() - 1));
    }

    static void removeAllInstenceOf(ArrayList<Integer> a, int val) {
        for (int i = a.size() - 1; i >= 0; i--) {
            if (a.get(i) == val) {
                a.remove(i);
            }
        }
    }

    static ArrayList<Integer> intersectionBetweenTwoList(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if (b.contains(a.get(i)) && !res.contains(a.get(i))) {
                res.add(a.get(i));
            }
        }
        return res;
    }

    static ArrayList<Integer> unionBetweenTwoList(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            if (!res.contains(a.get(i))) {
                res.add(a.get(i));
            }
        }
        for (int i = 0; i < b.size(); i++) {
            if (!res.contains(b.get(i))) {
                res.add(b.get(i));
            }
        }
        return res;
    }

    static void swapBetweenEveryTwoElements(ArrayList<Integer> a) {
        for (int i = 0; i < a.size() - 1; i += 2) {
            a.set(i, a.set(i + 1, a.get(i)));
        }
    }

    static boolean isPalindrom(ArrayList<Integer> a) {
        int l = a.size() - 1;
        for (int i = 0; i < a.size() / 2; i++, l--) {
            if (!a.get(i).equals(a.get(l))) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);


        System.out.println(list);
        swapBetweenEveryTwoElements(list);
        System.out.println(list);


    }
}
