package com.leetcode.problems.twopoints.sortedsquares;

public class Lc977 {
    public static void main(String[] args) {
        int[] arr = {-4, -1, 0, 3, 10};
        System.out.println(new Solution().sortedSquares(arr));
    }
}


class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        while (left <= right) {
            int left2 = nums[left] * nums[left];
            int right2 = nums[right] * nums[right];
            if (left2 > right2) {
                result[index] = left2;
                left++;
            } else {
                result[index] = right2;
                right--;
            }
            index--;
        }
        return result;
    }
}