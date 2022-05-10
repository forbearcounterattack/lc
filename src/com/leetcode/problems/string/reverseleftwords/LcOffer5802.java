package com.leetcode.problems.string.reverseleftwords;

public class LcOffer5802 {
    public static void main(String[] args) {
        String s = "abcdefg";
        int n = 2;
        System.out.println(new Solution().reverseLeftWords(s, n));

    }
}

class Solution {

    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb, 0, n - 1);
        reverseString(sb, n, len - 1);
        reverseString(sb, 0 , len - 1);
        return sb.toString();
        //return sb.reverse().toString();
    }

    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }


    public String reverseLeftWords1(String s, int n) {
        char[] arr = s.toCharArray();
        //翻转前n个字符
        reverseHelper1(arr, 0, n);
        //翻转n到末尾个字符
        reverseHelper1(arr, n, arr.length);
        //翻转整个字符串
        reverseHelper1(arr, 0, arr.length);
        return new String(arr);
    }

    private void reverseHelper1(char[] ch, int start, int end) {
        int left = start;
        int right = end - 1;
        while (left < right) {
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;
            right--;
        }
    }

    public String reverseLeftWords2(String s, int n) {
        if (s.length() < n) {
            return s;
        }
        char[] left = new char[n];
        int leftIndex = 0;
        char[] right = new char[s.length() - n];
        int rightIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < n) {
                left[leftIndex++] = s.charAt(i);
            } else {
                right[rightIndex++] = s.charAt(i);
            }
        }
        return new String(right) + new String(left);
    }


    public String reverseLeftWords3(String s, int n) {
        if (s.length() < n) {
            return s;
        }
        StringBuilder sbLeft = new StringBuilder();
        StringBuilder sbRight = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i < n) {
                sbLeft.append(s.charAt(i));
            } else {
                sbRight.append(s.charAt(i));
            }
        }
        return sbRight.toString() + sbLeft.toString();
    }
}