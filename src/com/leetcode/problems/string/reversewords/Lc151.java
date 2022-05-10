package com.leetcode.problems.string.reversewords;

public class Lc151 {
    public static void main(String[] args) {
        String str = "a bc   d e  ";
        Solution solution = new Solution();
        System.out.println(solution.reverseWords(str));

    }

}

class Solution {
    public String reverseWords(String s) {
        //"a bc   d e  " ===>"a bc d e" ===>"e d cb a"===>"e d bc a"
        //第一步，删除多余空格
        String allString = removeSpace(s);
        //第二步：翻转整个字符串
        String reverseAllString = reverseAllString(allString);
        //第三步：翻转每一个单词
        String reverseEachWordString = reverseEachWord(reverseAllString);
        return reverseEachWordString;
    }

    private String reverseEachWord(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            sb.append(" ");
            sb.append(reverseAllString(arr[i]));
        }
        return sb.toString().trim();
    }

    private String reverseAllString(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int left = 0;
        int right = s.length() - 1;
        char[] ch = s.toCharArray();
        while (left < right) {
            char c = ch[left];
            ch[left] = ch[right];
            ch[right] = c;
            left++;
            right--;
        }
        return new String(ch);
    }

    private String removeSpace(String s) {
        s = s.trim();
        int start = 0;
        int end = start + 1;
        StringBuilder sb = new StringBuilder();
        while (start < s.length()) {
            char c1 = s.charAt(start);
            char c2 = end >= s.length() ? ' ' : s.charAt(end);
            if (!(c1 == ' ' && c2 == ' ')) {
                sb.append(c1);
            }
            start++;
            end++;
        }
        return sb.toString();
    }

    private String removeSpace2(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        return sb.toString();
    }
}