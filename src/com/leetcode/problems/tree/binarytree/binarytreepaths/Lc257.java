package com.leetcode.problems.tree.binarytree.binarytreepaths;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc257 {
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
    //方法一：层序遍历
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList();
        if (null == root) {
            return result;
        }
        Queue<TreeNode> qNode = new LinkedList();
        Queue<String> qPath = new LinkedList();
        qNode.offer(root);
        qPath.offer("" + root.val);
        while (!qPath.isEmpty() && !qNode.isEmpty()) {
            int size = qNode.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = qNode.poll();
                String path = qPath.poll();
                if (null == node.left && null == node.right) {
                    result.add(path);
                }
                if (null != node.left) {
                    qNode.offer(node.left);
                    qPath.offer(path + "->" + node.left.val);
                }
                if (null != node.right) {
                    qNode.offer(node.right);
                    qPath.offer(path + "->" + node.right.val);
                }
            }
        }
        return result;
    }
}