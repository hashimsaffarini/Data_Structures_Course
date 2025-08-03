package arraylist;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.IntToDoubleFunction;

public class HackerRankProblems {

    static void cuteSort(ArrayList<ArrayList<Integer>> arr, int k) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size() - 1; j++) {
                if (k == 0 && arr.get(j).get(k) > arr.get(j + 1).get(k)) {
                    int temp = arr.get(j).get(k);
                    arr.get(j).set(k, arr.get(j + 1).get(k));
                    arr.get(j + 1).set(k, temp);
                } else if (k == 1 && arr.get(j).get(k) < arr.get(j + 1).get(k)) {
                    int temp = arr.get(j).get(k);
                    arr.get(j).set(k, arr.get(j + 1).get(k));
                    arr.get(j + 1).set(k, temp);
                }

            }
        }
    }

    static ArrayList<ArrayList<Integer>> groupedByLastDigit(ArrayList<Integer> list) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int val : list) {
                if (val % 10 == i) {
                    temp.add(val);
                }
            }
            Collections.sort(temp);
            if (!temp.isEmpty())
                res.add(temp);
        }
        return res;
    }

    public static ArrayList<ArrayList<Integer>> groupByFrequency(ArrayList<Integer> nums) {
        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<Integer> freq = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i);
            int idx = values.indexOf(val);
            if (idx == -1) {
                values.add(val);
                freq.add(1);
            } else {
                freq.set(idx, freq.get(idx) + 1);
            }
        }
        for (int i = 0; i < freq.size() - 1; i++) {
            for (int j = i + 1; j < freq.size(); j++) {
                if (freq.get(i) > freq.get(j) || (freq.get(i).equals(freq.get(j)) && values.get(i) > values.get(j))) {
                    int tempF = freq.get(i);
                    freq.set(i, freq.get(j));
                    freq.set(j, tempF);

                    int tempV = values.get(i);
                    values.set(i, values.get(j));
                    values.set(j, tempV);
                }
            }
        }


        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < freq.size(); ) {
            int currentFreq = freq.get(i);
            ArrayList<Integer> group = new ArrayList<>();
            while (i < freq.size() && freq.get(i) == currentFreq) {
                group.add(values.get(i));
                i++;
            }
            result.add(group);
        }
        return result;

    }

    static void multiLevels(ArrayList<ArrayList<Integer>> list) {
        ArrayList<Integer> a = new ArrayList<>();
        for (ArrayList<Integer> b : list) {
            a.add(concate(b));
        }
        ArrayList<ArrayList<Integer>> r = new ArrayList<>();
        for (int val : a) {
            ArrayList<Integer> t = new ArrayList<>();
            int size = (val + "").length();
            int x = 0;
            for (int i = size - 1; i >= 0; i--) {
                if (get(val, i) % 2 == 1)
                    x = x * 10 + get(val, i);

            }
            r.add(new ArrayList<>(Arrays.asList(x)));
        }
        ArrayList<Integer> c = new ArrayList<>();
        for (ArrayList<Integer> b : r) {
            c.add(maxFreq(b.get(0)));
        }
        System.out.println(a);
        System.out.println(r);
        System.out.println(c);
    }

    static int maxFreq(int a) {
        int freq[] = new int[10];
        int size = (a + "").length();
        for (int i = 0; i < size; i++) {
            freq[get(a, i)]++;
        }
        Arrays.sort(freq);
        return freq[freq.length - 1];

    }

    static int get(int x, int i) {
        return x / (int) Math.pow(10, i) % 10;
    }

    static int concate(ArrayList<Integer> a) {
        int res = 0;
        for (int val : a) {
            res = res * ((int) Math.pow(10, (val + "").length())) + val;
        }
        int x = 0;
        for (int i = 9; i >= 0; i--) {
            int y = res;
            while (y != 0) {
                int b = y % 10;
                if (b == i) {
                    x = x * 10 + i;
                }
                y /= 10;
            }
        }
        return x;
    }

    public static void main(String[] args) {
//        15 20 37
//        1 9
//        2 7
//        3301 50
//        5001 6

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        list.add(new ArrayList<>(Arrays.asList(15, 20, 37)));
        list.add(new ArrayList<>(Arrays.asList(1, 9)));
        list.add(new ArrayList<>(Arrays.asList(2, 7)));
        list.add(new ArrayList<>(Arrays.asList(3301, 50)));
        list.add(new ArrayList<>(Arrays.asList(5001, 6)));

        multiLevels(list);
    }
}
