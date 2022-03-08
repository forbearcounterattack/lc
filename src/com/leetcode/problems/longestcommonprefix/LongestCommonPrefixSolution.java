package com.leetcode.problems.longestcommonprefix;

import java.util.ArrayList;

/**
 * @Author Duole
 * @Version 1.0
 */
public class LongestCommonPrefixSolution {
    public static void main(String[] args) {

        //String[] strArrs = {"flower","flow","flight"};

        String[] strArrs = {"cir", "car"};

        Solution solution = new Solution();
        String str = solution.longestCommonPrefix(strArrs);
        System.out.println(str);

    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String commonPrefix = "";
        ArrayList<Character> commonPrefixList = new ArrayList<Character>();
        int minCols = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            if (minCols > strs[i].length()) {
                minCols = strs[i].length();
            }
        }
        for (int j = 0; j < minCols; j++) {
            //第1行的字符数组
            char[] baseChars = strs[0].toCharArray();
            //基准值依次选择第一行的每一个字符
            char baseChar = baseChars[j];
            int count = 0;
            for (int i = 1; i < strs.length; i++) {
                char[] lineArrs = strs[i].toCharArray();
                if (lineArrs[j] == baseChar) {
                    count++;
                }
            }
            if (count == strs.length - 1) {
                commonPrefixList.add(baseChar);
                count = 0;
            } else {
                break;
            }
        }
        for (int i = 0; i < commonPrefixList.size(); i++) {
            commonPrefix += commonPrefixList.get(i).toString();
        }
        return commonPrefix;
    }
}
