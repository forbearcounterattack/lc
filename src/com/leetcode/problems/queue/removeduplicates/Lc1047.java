package com.leetcode.problems.queue.removeduplicates;

import java.util.Stack;

public class Lc1047 {
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(new Solution().removeDuplicates(s));
    }
}

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack();
        for (Character c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() != c) {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }
        }
        char[] ch = new char[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            ch[index++] = stack.pop();
        }
        int left = 0;
        int right = index - 1;
        while (left < right) {
            char c = ch[left];
            ch[left] = ch[right];
            ch[right] = c;
            left++;
            right--;
        }
        return new String(ch);
    }

    public String removeDuplicates2(String s) {
        Stack<Character> stack = new Stack();
        for (Character c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() != c) {
                    stack.push(c);
                } else {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                }
            }
        }
        String str = "";
        while (!stack.isEmpty()) {
            str = stack.pop() + str;
        }
        return str;
    }
}
