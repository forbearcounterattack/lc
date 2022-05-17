package com.leetcode.problems.queue.maxslidingwindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Lc239 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = new Solution().maxSlidingWindow(nums, k);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}


class Solution {

    //方法三：使用单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList();
        int[] result = new int[n - k + 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            //第一步：删除头部，保证滑动窗口的长度为k
            //while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            //第二步：移除尾部小于nums[i]的元素
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.removeLast();
            }
            //第三步：尾部插入i
            deque.offerLast(i);
            //第四步：更新结果数组
            if (i - k + 1 >= 0) {
                //result[i - k + 1] = nums[deque.peekFirst()];
                //此处的优化也更好理解
                result[index++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }


    //方法二：使用队列，依旧超时。。
    public int[] maxSlidingWindow2(int[] nums, int k) {
        Queue<Integer> q = new LinkedList();
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length - k + 1; i++) {
            int indexIn = 0;
            if (i == 0) {
                while (indexIn < k) {
                    q.offer(nums[i + indexIn]);
                    indexIn++;
                }
            } else {
                q.poll();
                q.offer(nums[i + k - 1]);
            }
            Queue<Integer> temp = new LinkedList();
            temp.addAll(q);
            int max = getMax(temp);
            result[index++] = max;
        }
        return result;
    }
    private int getMax(Queue<Integer> temp) {
        int max = Integer.MIN_VALUE;
        while (!temp.isEmpty()) {
            int k = temp.poll();
            if (k > max) {
                max = k;
            }
        }
        return max;
    }
    //方法一： 暴力破解，结果超时了。。。
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length - k + 1; i++) {
            int indexIn = 0;
            int[] temp = new int[k];
            for (int j = 0; j < k; j++) {
                temp[indexIn++] = nums[i + j];
            }
            Arrays.sort(temp);
            result[index++] = temp[k - 1];
        }
        return result;
    }
}