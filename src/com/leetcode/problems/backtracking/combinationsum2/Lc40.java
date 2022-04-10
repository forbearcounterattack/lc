package com.leetcode.problems.backtracking.combinationsum2;

import java.util.*;

public class Lc40 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int target = 27;
        System.out.println(solution.combinationSum2(candidates, target));
    }
}

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList();
        Arrays.sort(candidates);
        Map<String, Integer> existKey = new HashMap<>();
        backTracking(candidates, target, existKey, 0, result, path);
        return result;
    }

    private void backTracking(int[] candidates, int target, Map<String, Integer> existKey, int startIndex, List<List<Integer>> result, List<Integer> path) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int num : path) {
            sum += num;
            sb.append(String.valueOf(num));
        }
        if (sum > target) {
            return;
        }
        if (sum == target) {
            if (!existKey.containsKey(sb.toString())) {
                result.add(new ArrayList(path));
                existKey.put(sb.toString(), 1);
            }
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            backTracking(candidates, target, existKey, i + 1, result, path);
            path.remove(path.size() - 1);
        }
    }
}
