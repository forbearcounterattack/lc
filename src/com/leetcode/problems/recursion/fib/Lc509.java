package com.leetcode.problems.recursion.fib;

public class Lc509 {
    public static void main(String[] args) {

    }
}

class Solution {

    public int fib(int n) {
        int[] cache = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            cache[i] = -1;
        }
        return fibHelper(n, cache);
    }

    private int fibHelper(int n, int[] arr) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (-1 != arr[n]) {
            return arr[n];
        }
        arr[n] = fibHelper(n - 1, arr) + fibHelper(n - 2, arr);
        return arr[n];
    }

    public int fib1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    //动态规划方式
    public int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        //第一步：定义状态数组
        int[] dp = new int[n + 1];
        //第二步：状态初始化
        dp[0] = 0;
        dp[1] = 1;
        //第三步：状态转移
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        //第四步：返回最终返回值
        return dp[n];
    }
}
