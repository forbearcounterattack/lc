package com.leetcode.problems.recursion.reversestring;

public class Lc344 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] arr = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(arr);
        solution.reverseString(arr);
        System.out.println(arr);
    }
}

class Solution {

    //方法三：递归
    public void reverseString(char[] s) {
        reverseStringHelper(s, 0, s.length - 1);
    }

    private void reverseStringHelper(char[] s, int left, int right) {
        //递归结束条件
        if (left >= right) {
            return;
        }
        //交互左右指针
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        //左右指针分别向右向左移动，开始下一轮递归
        reverseStringHelper(s, left + 1, right - 1);
    }


    //方法二：双指针交换
    public void reverseString2(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }


    //方法一：直接交换
    public void reverseString1(char[] s) {
        int n = s.length;
        for (int i = 0; i < n / 2; i++) {
            char temp = s[i];
            s[i] = s[n - i - 1];
            s[n - i - 1] = temp;
        }
    }
}