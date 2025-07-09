package org.example;
import java.util.HashMap;
import java.util.Map;

    public class MinimumWindowSubstring {

        public static String minWindow(String s, String t) {
            if (s == null || t == null || s.length() < t.length()) return "";

            Map<Character, Integer> tMap = new HashMap<>();
            for (char c : t.toCharArray()) {
                tMap.put(c, tMap.getOrDefault(c, 0) + 1);
            }

            int required = tMap.size();
            int formed = 0;
            Map<Character, Integer> windowCounts = new HashMap<>();

            int left = 0, right = 0;
            int minLen = Integer.MAX_VALUE;
            int minLeft = 0;

            while (right < s.length()) {
                char c = s.charAt(right);
                windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

                if (tMap.containsKey(c) && windowCounts.get(c).intValue() == tMap.get(c).intValue()) {
                    formed++;
                }

                // Thu hẹp cửa sổ nếu đủ điều kiện
                while (left <= right && formed == required) {
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        minLeft = left;
                    }

                    char lChar = s.charAt(left);
                    windowCounts.put(lChar, windowCounts.get(lChar) - 1);

                    if (tMap.containsKey(lChar) && windowCounts.get(lChar).intValue() < tMap.get(lChar).intValue()) {
                        formed--;
                    }

                    left++;
                }

                right++;
            }

            return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
        }

        public static void main(String[] args) {
            String s = "ADOBECODEBANC";
            String t = "ABC";

            String result = minWindow(s, t);
            System.out.println("Minimum window substring: " + result);
        }
}
