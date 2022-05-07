package com.leetcode.problems.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Duole
 * @Version 1.0
 */
public class Lc1 {
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
    //方法二：利用hash表
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < len; i++) {
            int minus = target - nums[i];
            if (map.containsKey(minus)) {
                return new int[]{i, map.get(minus)};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    //方法一：暴力破解
    public int[] twoSum1(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}

