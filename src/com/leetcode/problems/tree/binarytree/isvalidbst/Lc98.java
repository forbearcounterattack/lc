package com.leetcode.problems.tree.binarytree.isvalidbst;

import java.util.Stack;

public class Lc98 {
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
    public boolean isValidBST(TreeNode root) {
        if (null == root) {
            return true;
        }
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        TreeNode pre = null;
        while (null != cur || !stack.isEmpty()) {
            if (null != cur) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (null != pre && cur.val <= pre.val) {
                    return false;
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return true;
    }
}