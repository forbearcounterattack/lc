package com.leetcode.problems.hashtable.foursumcount;

import java.util.HashMap;
import java.util.Map;

public class Lc454 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};

        System.out.println(new Solution().fourSumCount(nums1, nums2, nums3, nums4));
    }
}

class Solution {
    //方法二：使用hash表
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i1 = 0; i1 < nums1.length; i1++) {
            for (int i2 = 0; i2 < nums2.length; i2++) {
                if (map.containsKey(nums1[i1] + nums2[i2])) {
                    map.put(nums1[i1] + nums2[i2], map.get(nums1[i1] + nums2[i2]) + 1);
                } else {
                    map.put(nums1[i1] + nums2[i2], 1);
                }
            }
        }
        for (int i3 = 0; i3 < nums3.length; i3++) {
            for (int i4 = 0; i4 < nums4.length; i4++) {
                if (map.containsKey(0 - nums4[i4] - nums3[i3])) {
                    count += map.get(0 - nums4[i4] - nums3[i3]);
                }
            }
        }
        return count;
    }

    //方法一：暴力破解，但是会超出时间限制
    public int fourSumCount1(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        for (int i1 = 0; i1 < nums1.length; i1++) {
            for (int i2 = 0; i2 < nums2.length; i2++) {
                for (int i3 = 0; i3 < nums3.length; i3++) {
                    for (int i4 = 0; i4 < nums4.length; i4++) {
                        if (nums1[i1] + nums2[i2] + nums3[i3] + nums4[i4] == 0) {
                            count++;
                            System.out.println(nums1[i1] + " " + nums2[i2] + " " + nums3[i3] + " " + nums4[i4]);
                        }
                    }
                }
            }
        }
        return count;
    }
}

