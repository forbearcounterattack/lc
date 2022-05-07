package com.leetcode.problems.hashtable.intersection;

import java.util.HashSet;
import java.util.Set;

public class Lc349 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = new Solution().intersection(nums1, nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
    }
}


class Solution {
    //方法二：双重for循环
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                resultSet.add(i);
            }
        }
        int[] resultArray = new int[resultSet.size()];
        int index = 0;
        for (int i : resultSet) {
            resultArray[index++] = i;
        }
        return resultArray;
    }


    //方法一：双重for循环
    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet();
        for (int i = 0; i < nums2.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                if (nums1[j] == nums2[i]) {
                    set.add(nums2[i]);
                }
            }
        }

        int[] result = new int[set.size()];
        int index = 0;
        for (int v : set) {
            result[index++] = v;
        }
        return result;
    }
}