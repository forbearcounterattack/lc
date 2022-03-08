package com.leetcode.problems.findmiddleindex;


/**
 * @Author Duole
 * @Version 1.0
 */
public class FindMiddleIndexSolution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] nums = {-1, -1, 0, 1, 1, 0, 0};
        int[] nums = {0, -1, 1};
        //int[] nums = {2,2};
        int centerIndex = solution.findMiddleIndex(nums);
        System.out.println(centerIndex);
    }
}

class Solution {
    public int findMiddleIndex(int[] nums) {
        //第一次循环代表中心索引的位置
        for (int centerIndex = 0; centerIndex < nums.length; centerIndex++) {
            if (centerIndex == 0 && 0 == partSum(nums, 1, nums.length - 1)) {
                return 0;
            }
            if (centerIndex == nums.length - 1 && 0 == partSum(nums, 0, nums.length - 2)) {
                return nums.length - 1;
            }
            if (centerIndex != 0 && centerIndex != nums.length - 1) {
                if (partSum(nums, 0, centerIndex - 1) == partSum(nums, centerIndex + 1, nums.length - 1)) {
                    return centerIndex;
                }
            }
        }
        return -1;
    }

    private int partSum(int[] nums, int start, int end) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
