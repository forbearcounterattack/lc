package com.leetcode.problems.backtracking.subsets;

import java.util.ArrayList;
import java.util.List;

public class Lc78 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};

        System.out.println(solution.subsets(nums));
    }
}


class Solution {
    //方法三：利用二进制位解决
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < Math.pow(2, n); i++) {
            List<Integer> temp = new ArrayList<>();
            String binaryString = Integer.toBinaryString(i);
            for (int j = binaryString.length(); j < n ; j++) {
                binaryString = "0" + binaryString;
            }
            for (int j = 0; j < binaryString.length(); j++) {
                if (binaryString.charAt(j) == '1') {
                    temp.add(nums[j]);
                }
            }
            result.add(temp);
        }
        return result;
    }


    //方法二：动态扩展
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            //每次都向result中已经存在的数组动态扩充
            for (int j = 0; j < result.size(); j++) {
                List<Integer> exist = new ArrayList<>(result.get(j));
                exist.add(nums[i]);
                temp.add(exist);
            }
            //result.addAll(temp);
            for (List<Integer> tempElement : temp) {
                result.add(tempElement);
            }
        }
        return result;
    }

    //方法一：回溯
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTracking(nums, 0, result, path);
        return result;
    }

    private void backTracking(int[] nums, int startIndex, List<List<Integer>> result, List<Integer> path) {
        //第一步：收集元素
        result.add(new ArrayList<>(path));
        //第二步：递归终止条件 (此步骤非必须)
        if (startIndex >= nums.length) {
            return;
        }

        //第三步：进行递归
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backTracking(nums, i + 1, result, path);
            //第四步：回溯
            path.remove(path.size() - 1);
        }
    }
}
