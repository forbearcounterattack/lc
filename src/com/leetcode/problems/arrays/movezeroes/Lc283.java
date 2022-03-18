package com.leetcode.problems.arrays.movezeroes;

/**
 * @Author Duole
 * @Version 1.0
 */
public class Lc283 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        Solution solution = new Solution();
        solution.moveZeroes(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }

        System.out.println();
        int[] arr1 = {0, 1, 0, 3, 12};
        solution.moveZeroes_1(arr1);
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + "  ");
        }
    }
}

class Solution {
    //方法一:使用冒泡排序的思路，把0冒泡到数组的最后一个位置
    public void moveZeroes(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] == 0) {
                    temp = nums[j + 1];
                    nums[j + 1] = 0;
                    nums[j] = temp;
                }
            }
        }
    }

    //方法二:使用双指针。 index是放置非0元素的数组下标
    public void moveZeroes_1(int[] nums) {
        //这里是放置非0元素的数组下标
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}