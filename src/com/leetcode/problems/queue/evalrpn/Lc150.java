package com.leetcode.problems.queue.evalrpn;

import java.util.Stack;

public class Lc150 {
    public static void main(String[] args) {
        String[] s1 = {"2", "1", "+", "3", "*"};
        String[] s2 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new Solution().evalRPN(s1));
        System.out.println(new Solution().evalRPN(s2));
    }
}


class Solution {
    public int evalRPN(String[] tokens) {
        int result = -1;
        Stack<Integer> stack = new Stack();
        for (String str : tokens) {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int second = stack.pop();
                int first = stack.pop();
                int temp = 0;
                if (str.equals("+")) {
                    temp = first + second;
                }
                if (str.equals("-")) {
                    temp = first - second;
                }
                if (str.equals("*")) {
                    temp = first * second;
                }
                if (str.equals("/")) {
                    temp = first / second;
                }
                stack.push(temp);
            } else {
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.pop();
    }
}