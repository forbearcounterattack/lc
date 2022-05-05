package com.leetcode.problems.arrays;

import java.util.ArrayList;
import java.util.Stack;

public class Demo {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("JavaFx");
        list1.add("Java");
        list1.add("WebGL");
        list1.add("OpenCV");
        System.out.println(list1);
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("JavaFx");
        list2.add("Java");
        list2.add("WebGL");
        list2.add("OpenCV");
        System.out.println(list2);
        System.out.println(list1.equals(list2));


        Stack<Character> stack1 = new Stack();
        stack1.push('a');
        stack1.push('a');
        stack1.push('b');

        Stack<Character> stack2 = new Stack();
        stack2.push('a');


        stack2.push('a');
        stack2.push('d');

        System.out.println(stack1.equals(stack2));

    }
}
