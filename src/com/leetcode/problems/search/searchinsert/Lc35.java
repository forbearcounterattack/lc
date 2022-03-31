package com.leetcode.problems.search.searchinsert;

import javax.sound.midi.Soundbank;

public class Lc35 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 5, 7, 9, 10};
        System.out.println(solution.searchInsert(arr, 8));
    }
}


class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        //执行到这里就说明没找到，直接拿target和nums[mid]对比即可
        return target > nums[mid] ? mid + 1 : mid;
    }
}