package com.leetcode.problems.hashtable.containsduplicate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author Duole
 * @Version 1.0
 */
public class Lc217 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        Solution solution = new Solution();

        System.out.println(solution.containsDuplicate(arr));
    }
}


class Solution {
    //方法三:使用hashset
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        //return set.size() != nums.length;
        //这里可以优化,可以直接返回false
        return false;
    }

    //方法二：排序后判断相邻元素
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    //方法一：使用hashmap
    public boolean containsDuplicate1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], 0);
            }
        }
        return false;
    }
}