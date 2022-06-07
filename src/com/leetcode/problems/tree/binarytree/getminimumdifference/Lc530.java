package com.leetcode.problems.tree.binarytree.getminimumdifference;

import java.util.Stack;

public class Lc530 {
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
    public int getMinimumDifference(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        TreeNode pre = null;
        int minus = Integer.MAX_VALUE;
        while (null != cur || !stack.isEmpty()) {
            if (null != cur) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (null != pre) {
                    int result = cur.val - pre.val;
                    if (result < minus) {
                        minus = result;
                    }
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return minus;
    }
}