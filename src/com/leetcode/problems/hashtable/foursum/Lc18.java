package com.leetcode.problems.hashtable.foursum;

import java.util.*;

public class Lc18 {
    public static void main(String[] args) {
        int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
        int target = 0;
        System.out.println(new Solution().fourSum(nums, target));

    }
}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList();
        }
        List<List<Integer>> result = new ArrayList();
        Set<List<Integer>> set = new HashSet();
        int left = 1;
        int right = nums.length - 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                left = j + 1;
                right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
                        List<Integer> list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        if (!set.contains(list)) {
                            result.add(list);
                            set.add(list);
                        }
                    }
                    if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
