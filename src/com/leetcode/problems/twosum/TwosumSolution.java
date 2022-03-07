package com.leetcode.problems.twosum;

/**
 * @Author Duole
 * @Version 1.0
 */
public class TwosumSolution {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        Solution solution = new Solution();
        int[] result = solution.twoSum(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return new int[0];
        } else {
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return new int[0];
    }
}

