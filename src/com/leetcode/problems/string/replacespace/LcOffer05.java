package com.leetcode.problems.string.replacespace;

public class LcOffer05 {
    public static void main(String[] args) {
        String str = "We are happy.";
        System.out.println(new Solution().replaceSpace(str));
    }
}

class Solution {
    public String replaceSpace(String s) {
        char[] arr = s.toCharArray();
        String strNew = s;
        for (int i = 0; i < arr.length; i++) {
            if (' ' == arr[i]) {
                strNew += "  ";
            }
        }
        char[] arrNew = strNew.toCharArray();
        int left = arr.length - 1;
        int right = arrNew.length - 1;
        while (left >= 0) {
            if (' ' == arrNew[left]) {
                arrNew[right] = '0';
                right--;
                arrNew[right] = '2';
                right--;
                arrNew[right] = '%';
            } else {
                arrNew[right] = arrNew[left];
            }
            left--;
            right--;
        }
        return new String(arrNew);
    }

    public String replaceSpace1(String s) {
        char[] arr = s.toCharArray();
        int add = 0;
        for (int i = 0; i < arr.length; i++) {
            if (' ' == arr[i]) {
                add += 2;
            }
        }
        char[] arrNew = new char[s.length() + add];
        for (int i = 0; i < arr.length; i++) {
            arrNew[i] = arr[i];
        }
        int left = arr.length - 1;
        int right = arrNew.length - 1;
        while (left >= 0) {
            if (' ' == arrNew[left]) {
                arrNew[right] = '0';
                right--;
                arrNew[right] = '2';
                right--;
                arrNew[right] = '%';
            } else {
                arrNew[right] = arrNew[left];
            }
            left--;
            right--;
        }
        return new String(arrNew);
    }


    public String replaceSpace2(String s) {
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