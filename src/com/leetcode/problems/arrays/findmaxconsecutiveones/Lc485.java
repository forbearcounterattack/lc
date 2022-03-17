package com.leetcode.problems.arrays.findmaxconsecutiveones;

/**
 * @Author Duole
 * @Version 1.0
 */
public class Lc485 {
    public static void main(String[] args) {
        int arr[] = {1, 0, 1, 1, 0, 1};
        Solution solution = new Solution();
        System.out.println(solution.findMaxConsecutiveOnes(arr));
    }
}

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                if (count > result) {
                    result = count;
                }
            } else {
                count = 0;
            }
        }
        return result;
    }
}
