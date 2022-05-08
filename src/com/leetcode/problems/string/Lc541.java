package com.leetcode.problems.string;

import java.util.ArrayList;
import java.util.List;

public class Lc541 {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(new Solution().reverseStr(s, k));
    }
}

class Solution {
    public String reverseStr(String s, int k) {
        int n = 2 * k;
        int index = 0;
        List<List<Character>> list = new ArrayList();
        List<Character> strList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            strList.add(index, s.charAt(i));
            index++;
            if (index == n || i == s.length() - 1) {
                index = 0;
                list.add(strList);
                strList = new ArrayList<>();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            List<Character> arrayList = list.get(i);
            int left = 0;
            int right = -1;
            if (arrayList.size() == n) {
                right = k - 1;
            } else {
                if (arrayList.size() >= k && arrayList.size() <= n) {
                    right = k - 1;
                } else if (arrayList.size() < k) {
                    right = arrayList.size() - 1;
                }
            }
            while (left < right) {
                char temp = arrayList.get(left);
                arrayList.set(left, arrayList.get(right));
                arrayList.set(right, temp);
                left++;
                right--;
            }
            for (int j = 0; j < arrayList.size(); j++) {
                if (null != arrayList.get(j)) {
                    sb.append(arrayList.get(j));
                }
            }
        }
        return sb.toString();
    }
}