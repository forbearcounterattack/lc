package com.leetcode.problems.search.binarysearch.searchmatrix;


public class Lc74 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}};
        int target = 12;
        System.out.println(solution.searchMatrix(arr, target));
    }
}


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        int high = rows * cols - 1;
        int mid = 0;
        while (low <= high) {
            //mid = low + ((high - low) / 2);
            //使用位运算,效率更高
            mid = low + ((high - low) >> 1);
            //mid/cols是一维数组转化为二维数组后的行坐标；mid%cols是一维数组转化为二维数组后的列坐标;
            if (target == matrix[mid / cols][mid % cols]) {
                return true;
            } else if (target > matrix[mid / cols][mid % cols]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
