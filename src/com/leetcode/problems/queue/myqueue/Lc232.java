package com.leetcode.problems.queue.myqueue;

import java.util.Stack;

public class Lc232 {
    public static void main(String[] args) {

    }
}

class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack();
        out = new Stack();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if (out.isEmpty()) {
            moveInToOut();
        }
        return out.pop();
    }

    public int peek() {
        if (out.isEmpty()) {
            moveInToOut();
        }
        return out.peek();
    }

    private void moveInToOut() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
    }

    public boolean empty() {
        if (in.isEmpty() && out.isEmpty()) {
            return true;
        }
        return false;
    }
}