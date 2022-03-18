package com.leetcode.problems.arrays.removeelement;

/**
 * @Author Duole
 * @Version 1.0
 */
public class Lc27 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
        Solution solution = new Solution();
        System.out.println(solution.removeElement(arr, 2));


        int[] arr1 = {3, 2, 2, 3, 1, 2};
        System.out.println(solution.removeElement_feeder(arr, 2));

    }
}

class Solution {
    //双指针，左指针找等于val的元素，右指针找不等于val的元素。二者进行交换
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }


    //双指针，左指针找等于val的元素，右指针找不等于val的元素。二者进行交换
    public int removeElement_feeder(int[] nums, int val) {
        int front = 0;
        int back = nums.length - 1;
        while (front < back) {
            while (nums[front] != val && front < back) {
                front++;
            }
            while (nums[back] == val && front < back) {
                back--;
            }
            nums[front] = nums[back];
            nums[back] = val;
        }
        if (nums[front] == val) {
            return front;
        }
        return front + 1;
    }
}
