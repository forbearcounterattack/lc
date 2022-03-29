package com.leetcode.problems.twopoints.numrescueboats;

import java.util.Arrays;

/**
 * @Author Duole
 * @Version 1.0
 */
public class Lc881 {
    public static void main(String[] args) {
        int[] people = {5, 1, 4, 2};
        int limit = 6;
        Solution solution = new Solution();
        System.out.println(solution.numRescueBoats(people, limit));

    }
}

class Solution {
    //使用快慢指针
    public int numRescueBoats(int[] people, int limit) {
        int count = 0;
        int slow = 0;
        int fast = people.length - 1;
        Arrays.sort(people);
        while (slow <= fast) {
            if (people[slow] + people[fast] <= limit) {
                slow++;
            }
            fast--;
            count++;
        }
        return count;
    }

}
