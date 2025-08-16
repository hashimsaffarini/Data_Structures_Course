package map;

import java.util.*;

public class MapProblems {
    static class Maxo {
        int count;
        int num;

        Maxo(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Maxo{" +
                    "count=" + count +
                    ", num=" + num +
                    '}';
        }
    }

    static void frequencyCharacters(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (mp.get(ch) == null) {
                mp.put(ch, 1);
            } else {
                mp.put(ch, mp.get(ch) + 1);
            }
        }
        System.out.println(mp);
    }

    static void frequencyCharacters2(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        for (char ch : s.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        System.out.println(mp);
    }

    static Maxo maxFrequency(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();
        int max = 0;
        int number = 0;
        for (int val : arr) {
            mp.put(val, mp.getOrDefault(val, 0) + 1);
        }
        System.out.println(mp);
        for (Integer key : mp.keySet()) {
            if (mp.get(key) > max) {
                max = mp.get(key);
                number = key;
            }
        }

        return new Maxo(number, max);
    }

    static boolean angram(String a, String b) {
        if (a.length() != b.length()) return false;
        char arrA[] = a.toCharArray();
        char arrB[] = b.toCharArray();
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        return Arrays.equals(arrA, arrB);
    }

    static int getPairsCount(int[] arr, int k) {
        // [1,5,7,-1,5] , k = 6 --> 3
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        for (int val : arr) {
            int complement = k - val;
            if (freq.containsKey(complement)) {
                count += freq.get(complement);
            }
            freq.put(val, freq.getOrDefault(val, 0) + 1);
        }
        return count;
    }

    static List<List<String>> groupAnagrams(String[] arr) {
        Map<String, List<String>> mp = new HashMap<>();
        for (String val : arr) {
            char ch[] = val.toCharArray();
            Arrays.sort(ch); // O(nLog(n))
            String sortedString = new String(ch);
            if (!mp.containsKey(sortedString)) {
                mp.put(sortedString, new ArrayList<>());
            }
            mp.get(sortedString).add(val);
        }
        // [[eat , tea, ate] , [adad]]
        return new ArrayList<>(mp.values());
    }

    static List<List<Integer>> findMatrix(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> mp = new LinkedHashMap<>();
        for (int val : arr) {
            mp.put(val, mp.getOrDefault(val, 0) + 1);
        }

        while (true) {
            List<Integer> list = new ArrayList<>();
            boolean f = false;
            for (int key : mp.keySet()) {
                if (mp.get(key) != 0) {
                    list.add(key);
                    mp.put(key, mp.get(key) - 1);
                    f = true;
                }
            }
            if (!f) {
                break;
            }
            res.add(list);
        }
        return res;
    }


    public static void main(String[] args) {
        String arr[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(
                groupAnagrams(arr)
        );

    }
}
