package com.leetcode.problems.arrays.movezeroes;

/**
 * @Author Duole
 * @Version 1.0
 */
public class Lc283 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        Solution solution = new Solution();
        solution.moveZeroes(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] == 0) {
                    temp = nums[j + 1];
                    nums[j + 1] = 0;
                    nums[j] = temp;
                }
            }
        }
    }
}