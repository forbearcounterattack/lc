package com.leetcode.problems.tree.binarytree.bfs.issymmetric;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc101 {
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
    public boolean isSymmetric(TreeNode root) {
        List<Integer> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] list = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (null != node) {
                    list[i] = node.val;
                } else {
                    list[i] = Integer.MIN_VALUE;
                    //此处的continue系画龙点睛之笔，不加会空指针
                    continue;
                }
                if (null != node.left) {
                    queue.offer(node.left);
                } else {
                    //当左孩子为空节点，必须要置为null，这样才可以在node==null的时候，向list中添加一个元素，才能实现每一层的回文数判断
                    queue.offer(null);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                } else {
                    //当右孩子为空节点，必须要置为null，这样才可以在node==null的时候，向list中添加一个元素，才能实现每一层的回文数判断
                    queue.offer(null);
                }
            }
            if (!isSymmetricHelper(list)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSymmetricHelper(int[] arr) {
        if (arr.length <= 1) {
            return true;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] == arr[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
