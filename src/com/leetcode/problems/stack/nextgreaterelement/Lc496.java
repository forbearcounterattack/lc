package com.leetcode.problems.stack.nextgreaterelement;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Author Duole
 * @Version 1.0
 */
public class Lc496 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 3, 5, 2, 4};
        int[] nums2 = {6, 4, 5, 3, 2, 1, 7};
        int[] result = solution.nextGreaterElement(nums1, nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}

class Solution {
    //使用单调栈
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        //key是某个元素，value是这个元素对应的其右侧第一个大于它自己的元素
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                //这里需要注意的是，可以不是stackPeek，而是stackPop
                map.put(stack.pop(), nums2[i]);
            }
            stack.add(nums2[i]);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }


    //暴力破解方法
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        //如果在num2中已经找到了num1中对应的元素,则findFlag设置为true。  当findFlag为true的时候，剩下的查找只需要查找下一个更大的值即可
        boolean findFlag = false;
        for (int i = 0; i < nums1.length; i++) {
            result[i] = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (findFlag) {
                    if (nums2[j] > nums1[i]) {
                        result[i] = nums2[j];
                        break;
                    } else {
                        continue;
                    }
                } else {
                    if (nums1[i] == nums2[j]) {
                        findFlag = true;
                    }
                }
            }
            //num1[i]的下一个最大值查找完毕后，findFlag重置为false,开启下一轮查找
            findFlag = false;
        }
        return result;
    }
}