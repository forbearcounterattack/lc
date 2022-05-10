package com.leetcode.problems.string.strstr;

public class Lc28 {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(new Solution().strStr(haystack, needle));
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        int l1 = haystack.length();
        int l2 = needle.length();
        int start = 0;
        while (start + l2 <= l1) {
            if (haystack.substring(start, start + l2).equals(needle)) {
                return start;
            } else {
                start++;
            }
        }
        return -1;
    }
}
