package com.leetcode.problems.backtracking.partition;

import java.util.ArrayList;
import java.util.List;

public class Lc131 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aab";
        System.out.println(solution.partition(s));

    }
}

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();
        List<String> path = new ArrayList();
        backTracking(s, 0, result, path);
        return result;
    }

    private void backTracking(String s, int startIndex, List<List<String>> result, List<String> path) {
        if (startIndex == s.length()) {
            result.add(new ArrayList(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String temp = s.substring(startIndex, i + 1);
            if (isPartition(temp)) {
                path.add(temp);
            } else {
                continue;
            }
            backTracking(s, i + 1, result, path);
            path.remove(path.size() - 1);
        }
    }

    private boolean isPartition(String s) {
        if (s.length() == 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}