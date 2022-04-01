package com.leetcode.problems.slidingwindow.minsubarraylen;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Lc209 {
    public static void main(String[] args) {

        Solution solution = new Solution();
//        int target = 7;
//        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 11;
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(solution.minSubArrayLen(target, nums));


        int[] sums = new int[nums.length + 1];
        System.out.println(sums[0]);
//        for (int i = 1; i <= length; i++) {
//            sums[i] = sums[i - 1] + nums[i - 1];
//        }


    }
}

class Solution {

    //方法一：滑动窗口
    public int minSubArrayLen(int target, int[] nums) {
        //初始化最小数组长度为原数组长度加1
        int minCount = nums.length + 1;
        int queueTail = 0;
        int queueHead = 0;
        //队列中当前所有元素的和
        int sum = 0;
        while (queueHead < nums.length) {
            sum += nums[queueHead];
            queueHead++;
            while (sum >= target) {
                if (queueHead - queueTail < minCount) {
                    minCount = queueHead - queueTail;
                }
                sum -= nums[queueTail];
                queueTail++;
            }
        }
        return minCount == nums.length + 1 ? 0 : minCount;
    }

    //方法一：直接循环遍历原数组，时间复杂度 o(n^2)
    public int minSubArrayLen1(int target, int[] nums) {
        //初始化最小数组长度为原数组长度加1
        int minCount = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            //计数器，判断当前子数组已经存在几个元素
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                count++;
                if (sum >= target) {
                    if (count < minCount) {
                        minCount = count;
                        //这里的break很有意思，看高手答案才发现的。因为内循环第一次找到的子数组肯定是最短的
                        break;
                    }
                }
            }
        }
        return minCount == nums.length + 1 ? 0 : minCount;
    }
}