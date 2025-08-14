package Map;

import java.util.HashMap;
import java.util.Map;

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

    public static void main(String[] args) {
        System.out.println(maxFrequency(new int[]{
                2, 1, 3, 3, 2, 1, 2, 3, 5, 5, 6, 3
        }));

    }
}
