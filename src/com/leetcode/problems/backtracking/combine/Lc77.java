package com.leetcode.problems.backtracking.combine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lc77 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int k = 2;
        System.out.println(solution.combine(n, k));

    }
}

class Solution {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList();
        ArrayList<Integer> path = new ArrayList();
        backTracking(n, k, 1, result, path);
        return result;
    }

    private void backTracking(int n, int k, int startIndex, List<List<Integer>> result, List<Integer> path) {
        if (path.size() == k) {
            result.add(new ArrayList(path));
            return;
        }
        //for (int i = startIndex; i <= n - (k - path.size()) +1; i++) {
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            //递归
            backTracking(n, k, i + 1, result, path);
            //回溯
            path.remove(path.size() - 1);
        }
    }
}