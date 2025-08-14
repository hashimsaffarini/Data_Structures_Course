package Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetProblems {
    static void uniqeNumbers(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int val : arr) {
            set.add(val);
        }

        System.out.println(set);
    }

    static int[] singleNumber(int[] arr) {
        Set<Integer> set = new HashSet<>();
        // [1,2,1,3,2,5]
        for (int val : arr) {
            if (set.contains(val)) {
                set.remove(val);
            } else {
                set.add(val);
            }
        }

        int res[] = new int[set.size()];
        int c = 0;
        for (int val : set) {
            res[c++] = val;
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,1,3,2,5};
        System.out.println(Arrays.toString(singleNumber(arr)));
    }
}
