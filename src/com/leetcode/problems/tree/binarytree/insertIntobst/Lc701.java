package com.leetcode.problems.tree.binarytree.insertIntobst;

public class Lc701 {
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
    //方法二：递归
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (null == root) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    //方法一：迭代
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (null == root) {
            return new TreeNode(val);
        }
        TreeNode pre = null;
        TreeNode cur = root;
        while (null != cur) {
            pre = cur;
            if (val < cur.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        TreeNode node = new TreeNode(val);
        if (val < pre.val) {
            pre.left = node;
        } else {
            pre.right = node;
        }
        return root;
    }
}