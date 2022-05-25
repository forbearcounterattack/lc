package com.leetcode.problems.tree.binarytree.issametree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lc100 {
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //此处重要，集合比较一定要用equals,不能用==
        if (helper(p).equals(helper(q))) {
            return true;
        }
        return false;
    }

    private List<Integer> helper(TreeNode root) {
        List<Integer> result = new ArrayList();
        if (null == root) {
            return result;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (null == node) {
                result.add(Integer.MIN_VALUE);
                continue;
            } else {
                result.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return result;
    }
}