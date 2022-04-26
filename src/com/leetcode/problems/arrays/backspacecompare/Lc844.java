package com.leetcode.problems.arrays.backspacecompare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Lc844 {
    public static void main(String[] args) {

        String s = "ab#c";
        String t = "ad#c";
        Solution solution = new Solution();
        System.out.println(solution.backspaceCompare(s, t));

    }
}

class Solution {
    public boolean backspaceCompare(String s, String t) {
        return helper(s).equals(helper(t));
    }


    private String helper(String str) {
        Stack<Character> stack = new Stack();
        for (char c : str.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else {
                if (!stack.empty()) {
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private String helper1(String str) {
        Stack<Character> stack = new Stack();
        for (char c : str.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else {
                if (!stack.empty()) {
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList();
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}