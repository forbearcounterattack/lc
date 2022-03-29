package com.leetcode.problems.tree.binarytree.findkthlargest;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author Duole
 * @Version 1.0
 */
public class Lc215 {
    public static void main(String[] args) {

    }
}

class Solution {
    //排序后遍历
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] < nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums[k - 1];
    }

    //使用大顶堆
    public int findKthLargest1(int[] nums, int k) {
        if (nums.length < k || nums.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(nums.length,
                new Comparator<Integer>() {
                    public int compare(Integer t1, Integer t2) {
                        return t2 - t1;
                    }
                });
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
        }
        int count = 0;
        while (!heap.isEmpty()) {
            int value = heap.poll();
            if (++count == k) {
                return value;
            }
        }
        return 0;
    }
}
