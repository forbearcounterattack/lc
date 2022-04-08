package com.leetcode.problems.backtracking.combinationsum3;

import java.util.ArrayList;
import java.util.List;

public class Lc216 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 7;
        int k = 3;
        System.out.println(solution.combinationSum3(k, n));
    }
}

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList();
        backTracking(k, n, 1, result, path);
        return result;
    }

    private void backTracking(int k, int n, int startIndex, List<List<Integer>> result, List<Integer> path) {
        //剪枝3
        if (path.size() > k) {
            return;
        }
        int sum = 0;
        for (int num : path) {
            sum += num;
        }
        //剪枝1
        if (sum > n) {
            return;
        }
        //递归终止条件
        if (sum == n && path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        //剪枝2
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            //for(int i = startIndex; i <= 9 && sum < n; i++){
            path.add(i);
            //开始递归
            backTracking(k, n, i + 1, result, path);
            //回溯
            path.remove(path.size() - 1);
        }
    }
}