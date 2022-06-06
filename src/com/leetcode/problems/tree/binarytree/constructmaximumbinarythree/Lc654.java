package com.leetcode.problems.tree.binarytree.constructmaximumbinarythree;

public class Lc654 {
    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int maxPos = -1;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxPos = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = helper(nums, start, maxPos - 1);
        root.right = helper(nums, maxPos + 1, end);
        return root;
    }
}