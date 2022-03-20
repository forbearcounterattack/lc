package com.leetcode.problems.stack.isvalid;

import java.util.Stack;

/**
 * @Author Duole
 * @Version 1.0
 */
public class Lc20 {
    public static void main(String[] args) {
        String s = "(])";
        Solution solution = new Solution();
        System.out.println(solution.isValid(s));

    }
}


class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else {
                if (!stack.isEmpty()) {
                    Character peek = stack.peek();
                    if ((c == ')' && peek == '(') || (c == ']' && peek == '[') || (c == '}' && peek == '{')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0 ? true : false;
    }
}
