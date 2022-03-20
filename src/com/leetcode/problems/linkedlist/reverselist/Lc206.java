package com.leetcode.problems.linkedlist.reverselist;

import java.util.List;
import java.util.Stack;

/**
 * @Author Duole
 * @Version 1.0
 */
public class Lc206 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Solution solution = new Solution();

        ListNode resultNode = solution.reverseList(head);
        while (resultNode != null) {
            System.out.println(resultNode.val + "   ");
            resultNode = resultNode.next;
        }
    }
}

class Solution {
    //递归解法
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //双指针：增加前置指针和后置指针
    public ListNode reverseList1(ListNode head) {
        //当前节点的前一个节点，逆转后的下一个节点
        ListNode pre = null;
        //当前节点的下一个节点
        ListNode curNext = null;
        //head就代表当前节点
        while (head != null) {
            curNext = head.next;
            head.next = pre;
            pre = head;
            head = curNext;
        }
        return pre;
    }
}