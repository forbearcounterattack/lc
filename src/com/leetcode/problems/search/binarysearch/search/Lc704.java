package com.leetcode.problems.search.binarysearch.search;

public class Lc704 {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 12};
        int target = 2;
        Solution solution = new Solution();
        System.out.println(solution.search(arr, 2));
    }
}


class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            //int mid = (left + right) / 2;
            //这么写可以避免当left+right较大的时候，超过int的最大值
            int mid = (right - left) / 2 + left;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}