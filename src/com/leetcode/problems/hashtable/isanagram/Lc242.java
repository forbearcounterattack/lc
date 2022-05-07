package com.leetcode.problems.hashtable.isanagram;

import java.util.HashMap;
import java.util.Map;

public class Lc242 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(new Solution().isAnagram(s, t));
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        return getMap(s).equals(getMap(t));
    }

    private Map<Character, Integer> getMap(String s) {
        Map<Character, Integer> map = new HashMap();
        char[] array = s.toCharArray();
        for (char c : array) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}