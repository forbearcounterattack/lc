package com.leetcode.problems.arrays.removeduplicates;

public class Lc26 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 3, 3, 4, 4, 5};
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(arr));
    }
}


class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                nums[slow + 1] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow + 1;
    }
}