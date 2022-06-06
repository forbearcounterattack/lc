package com.leetcode.problems.tree.binarytree.searchbst;

import java.util.Stack;

public class Lc700 {
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
    public TreeNode searchBST(TreeNode root, int val) {
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val == val) {
                return node;
            }
            if (val < node.val) {
                if (null != node.left) {
                    stack.push(node.left);
                }
            }
            if (val > node.val) {
                if (null != node.right) {
                    stack.push(node.right);
                }
            }
        }
        return null;
    }

    //充分利用二叉搜索树的特点进行迭代,其实就是二分法
    public TreeNode searchBST1(TreeNode root, int val) {
        while (root != null) {
            if (val < root.val) {
                root = root.left;
            } else if (val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
