package com.leetcode.problems.string.replacespace;

public class LcOffer05 {
    public static void main(String[] args) {
        String str = "We are happy.";
        System.out.println(new Solution().replaceSpace(str));
    }
}

class Solution {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}