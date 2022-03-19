package com.leetcode.problems.queue.firstuniqchar;

import javax.sound.midi.Soundbank;
import javax.swing.text.html.HTMLDocument;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author Duole
 * @Version 1.0
 */
public class Lc387 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "leetcode";
        System.out.println(solution.firstUniqChar(str));
    }
}

class Solution {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
