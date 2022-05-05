package com.leetcode.problems.arrays.sortedsquares;

import java.util.Arrays;

public class Lc977 {
    public static void main(String[] args) {
        int[] arr = {-4, -1, 0, 3, 10};
        Solution solution = new Solution();
        System.out.println(solution.sortedSquares(arr));
    }
}

class Solution {

    //方法一：暴力破解1
    public int[] sortedSquares1(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] * nums[i];
        }
        Arrays.sort(result);
        return result;
    }

    //方法二：双指针。index指针指向当前填值的位置
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = right;
        int[] result = new int[nums.length];
        while (left <= right) {
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                result[index] = nums[right] * nums[right];
                right--;
            } else {
                result[index] = nums[left] * nums[left];
                left++;
            }
            index--;
        }
        return result;
    }
}
