package com.leetcode.problems.divideconquer.majorityElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Lc169 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(solution.majorityElement(arr));

    }
}


class Solution {

    //方法三：摩尔投票法  时间复杂度o(n),空间复杂度是o(1)
    public int majorityElement(int[] nums) {
        int majorEle = Integer.MIN_VALUE;
        //计数器，因为众数一定比其它数字个数多。每次出现1个众数，counter++;每次出现1个非众数,counter--
        //每次counter==0的时候，增加当前元素为候选人
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
             if(0 == counter){
                 majorEle = nums[i];
             }
             if(majorEle == nums[i]){
                 counter++;
             }else{
                 counter--;
             }
        }
        return majorEle;
    }

    //方法二：排序 时间复杂度o(n),但是空间复杂度是o(1)   （这种解法太牛逼了，学习了）
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    //方法一：使用hashmap。时间复杂度o(n),但是空间复杂度是o(n)
    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        Set<Integer> integers = map.keySet();
        for(Integer key : integers){
            if(map.get(key) > nums.length / 2){
                return key;
            }
        }
        return -1;
    }
}