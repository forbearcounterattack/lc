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
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            //当j的长度和needle长度相等的时候，就说明已经完全匹配了模式串
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }


    private void getNext(int[] next, String needle) {
        //j是前缀末尾位置
        int j = 0;
        next[j] = 0;
        //i是后缀末尾位置
        for (int i = 1; i < needle.length(); i++) {
            //前后缀不相同的情况
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            //前后缀相同的情况
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            //更新前缀表(next)数组
            next[i] = j;
        }
    }

    public int strStr2(String haystack, String needle) {
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
