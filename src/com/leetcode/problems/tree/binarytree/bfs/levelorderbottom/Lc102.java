package com.leetcode.problems.tree.binarytree.bfs.levelorderbottom;

import java.util.*;

public class Lc102 {
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        if (null != root) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (null != node) {
                    list.add(node.val);
                }
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
            }
            if (list.size() > 0) {
                result.add(list);
            }
        }
        Collections.reverse(result);
        return result;
    }
}