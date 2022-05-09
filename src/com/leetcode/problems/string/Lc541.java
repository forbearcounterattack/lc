package com.leetcode.problems.string;

import java.util.ArrayList;
import java.util.List;

public class Lc541 {
    public static void main(String[] args) {
        String s = "abcdef";
        int k = 3;
        System.out.println(new Solution().reverseStr(s, k));
    }
}

class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        char[] sArr = s.toCharArray();
        char[] tempArr = new char[2 * k];
        int index = 0;
        for (int i = 0; i < sArr.length; i++) {
            tempArr[index++] = sArr[i];
            if (index == 2 * k || i == sArr.length - 1) {
                if (i == sArr.length - 1) {
                    List<Character> tempList = new ArrayList<>();
                    for (int j = 0; j < tempArr.length; j++) {
                        if ('\u0000' != tempArr[j]) {
                            tempList.add(tempArr[j]);
                        }
                    }
                    int size = tempList.size();
                    tempArr = new char[size];
                    for (int j = 0; j < tempArr.length; j++) {
                        tempArr[j] = tempList.get(j);
                    }
                }
                index = 0;
                //开始翻转
                int left = 0;
                int right = -1;
                if (tempArr.length == 2 * k) {
                    right = k - 1;
                } else {
                    if (tempArr.length >= k && tempArr.length <= 2 * k) {
                        right = k - 1;
                    } else if (tempArr.length < k) {
                        right = tempArr.length - 1;
                    }
                }
                while (left < right) {
                    char temp = tempArr[left];
                    tempArr[left] = tempArr[right];
                    tempArr[right] = temp;
                    left++;
                    right--;
                }
                sb.append(new String(tempArr));
                tempArr = new char[2 * k];
            }
        }
        return sb.toString();
    }


    public String reverseStr1(String s, int k) {
        int n = 2 * k;
        int index = 0;
        List<Character> strList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            strList.add(index, s.charAt(i));
            index++;
            if (index == n || i == s.length() - 1) {
                index = 0;
                //开始翻转
                int left = 0;
                int right = -1;
                if (strList.size() == n) {
                    right = k - 1;
                } else {
                    if (strList.size() >= k && strList.size() <= n) {
                        right = k - 1;
                    } else if (strList.size() < k) {
                        right = strList.size() - 1;
                    }
                }
                while (left < right) {
                    char temp = strList.get(left);
                    strList.set(left, strList.get(right));
                    strList.set(right, temp);
                    left++;
                    right--;
                }
                for (int j = 0; j < strList.size(); j++) {
                    if (null != strList.get(j)) {
                        sb.append(strList.get(j));
                    }
                }
                strList = new ArrayList<>();
            }
        }
        return sb.toString();
    }
}