package com.leetcode.problems.tree.binarytree.bfs.mindepth;

import java.util.LinkedList;
import java.util.Queue;

public class Lc111 {
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
    //方法一：递归
    public int minDepth1(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (null == root.left && null == root.right) {
            return 1;
        }
        int result = Integer.MAX_VALUE;
        if (null != root.left) {
            int temp = minDepth(root.left);
            if (temp < result) {
                result = temp;
            }
        }
        if (null != root.right) {
            int temp = minDepth(root.right);
            if (temp < result) {
                result = temp;
            }
        }
        return result + 1;
    }

    //方法二：层序遍历
    public int minDepth(TreeNode root) {
        int result = 0;
        if (null == root) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > 0) {
                result++;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //左右孩子都为null,说明该节点处于当前二叉树最浅的层
                if (null == node.left && null == node.right) {
                    return result;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }
}