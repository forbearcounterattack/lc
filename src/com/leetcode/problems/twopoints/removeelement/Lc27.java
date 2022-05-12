package com.leetcode.problems.twopoints.removeelement;

public class Lc27 {
    public static void main(String[] args) {

    }
}


class Solution {
    //方法一：快慢指针
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (val != nums[fast]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }


    //方法二：首尾指针
    public int removeElement2(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (nums[right] == val) {
                right--;
                if (right < 0) {
                    return 0;
                }
            }
            if (right <= left) {
                return right + 1;
            }
            if (nums[left] == val) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            }
            left++;
        }
        if (left == right) {
            if (nums[left] != val) {
                return left + 1;
            }
        }
        return left;
    }
}