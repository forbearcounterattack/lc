package com.leetcode.problems.backtracking.lettercombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc17 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String digits = "2";
        System.out.println(solution.letterCombinations(digits));
    }
}

class Solution {
    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return new ArrayList<>();
        }
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        backTracking(map, digits, 0, result, path);
        return result;
    }

    private void backTracking(Map<Integer, String> map, String digits, int startIndex, List<String> result, StringBuilder path) {
        if (path.length() == digits.length()) {
            result.add(path.toString());
            return;
        }
        String templates = map.get(Integer.valueOf(String.valueOf(digits.charAt(startIndex))));
        //此处i的选择是当前数字对应的字母表
        for (int i = 0; i < templates.length(); i++) {
            path.append(templates.charAt(i));
            //回溯的时候，需要回溯到下一个数字对应的字母表
            backTracking(map, digits, startIndex + 1, result, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
