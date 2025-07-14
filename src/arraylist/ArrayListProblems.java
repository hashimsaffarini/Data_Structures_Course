package arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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

    static ArrayList<Integer> removeAllDublicates1(ArrayList<Integer> a) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int val : a) {
            if (!res.contains(val)) {
                res.add(val);
            }
        }
        return res;
    }

    static void removeAllDublicates2(ArrayList<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 1; j < a.size(); j++) {
                if (a.get(i) == a.get(j)) {
                    a.remove(j);
                    j--;
                }
            }
        }
    }

    static void removeAllDublicates3(ArrayList<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            if (a.indexOf(a.get(i)) != i) {
                a.remove(i);
                i--;
            }
        }
    }

    static boolean isPrime(int x) {
        if (x <= 1) {
            return false;
        }

        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void sortListPrimeThenNotPrime(ArrayList<Integer> a) {
        for (int i = a.size() - 1; i >= 0; i--) {
            if (isPrime(a.get(i))) {
                a.add(a.remove(i));
            }
        }
    }

    static void removeSubList(ArrayList<Integer> a, int index, int n) {
        for (int i = 0; i < n; i++) {
            a.remove(index);
        }
    }

    static void sortListEvenThenOdd(ArrayList<Integer> a) {
        for (int i = a.size() - 1; i >= 0; i--) {
            if (a.get(i) % 2 == 0) {
                a.add(a.remove(i));
            }
        }
    }

    static ArrayList<Integer> decode(ArrayList<int[]> a) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int[] arr : a) {
            for (int i = 0; i < arr[0]; i++) {
                res.add(arr[1]);
            }
        }
        return res;
    }

    static ArrayList<ArrayList<Integer>> pascalTriangle(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> a = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    a.add(1);
                } else {
                    a.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(a);
        }
        return res;
    }

    static ArrayList<ArrayList<Integer>> divideList(ArrayList<Integer> a, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int c = 0;
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> b = new ArrayList<>();
            for (int j = 0; j < a.size() / k; j++) {
                b.add(a.get(c++));
            }
            res.add(b);
        }
        return res;
    }

    static ArrayList<ArrayList<Integer>> divideList2(ArrayList<Integer> a, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int breakPoint = a.size() / k;
        ArrayList<Integer> b = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            b.add(a.get(i));
            if ((i + 1) % breakPoint == 0) {
                res.add(b);
                b = new ArrayList<>();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
        int k = 3;

        System.out.println(divideList2(list, k));

        // 1,2,3,4,5,6,7,8,9,10,11,12


    }
}
