package com.leetcode.problems.twopoints.numrescueboats;

/**
 * @Author Duole
 * @Version 1.0
 */
public class Lc881 {
    public static void main(String[] args) {
        int[] people = {3, 2, 3, 2, 2};
        int limit = 6;
        Solution solution = new Solution();
        System.out.println(solution.numRescueBoats(people, limit));

    }
}

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int count = 0;
        for (int i = 0; i < people.length - 1; i++) {
            for (int j = 0; j < people.length - i - 1; j++) {
                if (people[j] < people[j + 1]) {
                    int temp = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = temp;
                }
            }
        }


        boolean flag = false;
        int step = 1;
        for (int i = 0; i < people.length - 1; i = i + step) {
            if (people[i] + people[i + 1] <= limit) {
                count++;
                step = 2;
                flag = true;
            } else {
                if (people[i] <= limit) {
                    count++;
                    step = 1;
                }
            }
        }
        return flag ? count : count + 1;
    }
}
