package com.leetcode.problems.backtracking.combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc39 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 3, 6, 7};

        int target = 7;

        Arrays.sort(arr);

        System.out.println(solution.combinationSum(arr, target));

    }
}

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> path = new ArrayList();
        backtracking(candidates, target, 0, result, path);
        return result;
    }

    private void backtracking(int[] candidates, int target, int startIndex, List<List<Integer>> result, List<Integer> path) {
        int sum = 0;
        for (Integer tmp : path) {
            sum += tmp;
        }
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList(path));
            return;
        }
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            //for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtracking(candidates, target, i, result, path);
            path.remove(path.size() - 1);
        }
    }
}
