package com.leetcode.problems.hashtable.isisomorphic;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Duole
 * @Version 1.0
 */
public class Lc205 {
    public static void main(String[] args) {
        String s = "babc";
        String t = "baba";
        Solution solution = new Solution();
        System.out.println(solution.isIsomorphic(s, t));
    }
}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            //不同的字符不能映射到同一个字符上
            if (map.containsValue(t.charAt(i))) {
                char key = '0';
                for (Map.Entry<Character, Character> entry : map.entrySet()) {
                    if (entry.getValue() == t.charAt(i)) {
                        key = entry.getKey();
                    }
                }
                if (key != s.charAt(i)) {
                    return false;
                }
            }
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
            } else {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}