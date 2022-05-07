package com.leetcode.problems.hashtable.canconstruct;

import java.util.HashMap;
import java.util.Map;

public class Lc383 {
    public static void main(String[] args) {
        String a = "aa";
        String b = "aab";
        Solution solution = new Solution();
        System.out.println(solution.canConstruct(a, b));
    }
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        int index = 0;
        for (int i = 0; i < magazine.length(); i++) {
            index = magazine.charAt(i) - 'a';
            arr[index]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            index = ransomNote.charAt(i) - 'a';
            if (arr[index] > 0) {
                arr[index]--;
            } else {
                return false;
            }
        }
        return true;
    }


    public boolean canConstruct1(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap();
        char[] magazineArray = magazine.toCharArray();
        for (char c : magazineArray) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        char[] ransomNoteArray = ransomNote.toCharArray();
        for (char c : ransomNoteArray) {
            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    map.put(c, map.get(c) - 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}