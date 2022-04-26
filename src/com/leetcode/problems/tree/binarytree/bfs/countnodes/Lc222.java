package com.leetcode.problems.tree.binarytree.bfs.countnodes;

import java.util.LinkedList;
import java.util.Queue;

public class Lc222 {
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        int leftHeight = 0;
        int rightHeight = 0;
        while (null != leftNode) {  // 求左子树深度
            leftNode = leftNode.left;
            leftHeight++;
        }
        while (null != rightNode) { // 求右子树深度
            rightNode = rightNode.right;
            rightHeight++;
        }
        if (leftHeight == rightHeight) {
            return (2 << leftHeight) - 1; // 注意(2<<1) 相当于2^2，所以leftHeight初始为0
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    //方法一：递归
    public int countNodes1(TreeNode root) {
        if(null == root){
            return 0;
        }
        int left = countNodes1(root.left);
        int right = countNodes1(root.right);
        return left + right + 1;
    }

    //方法二：层次遍历
    public int countNodes2(TreeNode root) {
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(null != root){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            count += size;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(null != node.left){
                    queue.offer(node.left);
                }
                if(null != node.right){
                    queue.offer(node.right);
                }
            }
        }
        return count;
    }
}
