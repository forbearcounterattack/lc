package com.leetcode.problems.tree.binarytree.bfs.connect;

import java.util.LinkedList;
import java.util.Queue;

public class Lc116 {
    public static void main(String[] args) {

    }
}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}


class Solution {
    //方法一：增加一个pre指针
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //每一层初始化prev节点
            Node prev = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                //判断prev是不是空，为null的话证明是每一层的第一个节点;不为null则代表pre是当前节点的同一层中的前一个结点
                if (prev != null) {
                    prev.next = cur;
                }
                if (null != cur) {
                    //放入子节点
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                prev = cur;
            }
        }
        return root;
    }

    //方法二：让同一层中的除了最后一个节点，都指向队列的下一个元素即可
    public Node connect2(Node root) {
        Node result = root;
        Queue<Node> queue = new LinkedList();
        if (null != root) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node next = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (null != node) {
                    if (i < size - 1) {
                        node.next = queue.peek();
                    }
                }
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}
