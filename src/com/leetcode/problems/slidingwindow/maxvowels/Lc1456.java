package com.leetcode.problems.slidingwindow.maxvowels;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Lc1456 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "abciiidef";
        int k = 3;
        System.out.println(solution.maxVowels(str, k));
    }
}

class Solution {
    public int maxVowels(String s, int k) {
        int maxCount = 0;
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int count = 0;
        for (int i = 0; i < k; i++) {
            // if (set.contains(chars[i])) {
            //     count++;
            // }
            if(findFlag(chars[i])){
                count++;
            }
        }
        maxCount = Math.max(maxCount, count);
        for (int i = k; i < chars.length; i++) {
            // if (set.contains(chars[i])) {
            //     count++;
            // }
            // if (set.contains(chars[i - k])) {
            //     count--;
            // }
            if (findFlag(chars[i])) {
                count++;
            }
            if (findFlag(chars[i - k])) {
                count--;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
    //实践证明，基本数据类型直接比较，效率要高于集合
    private boolean findFlag(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ? true : false;
    }
}
