package com.leetcode.problems.linkedlist.removeelements;


/**
 * @Author Duole
 * @Version 1.0
 */
public class Lc203 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Solution solution = new Solution();
        ListNode resultHead = solution.removeElements(head, 6);
        while (resultHead != null) {
            System.out.println(resultHead.val + "   ");
            resultHead = resultHead.next;
        }

    }
}

class Solution {
    //方法一：增加虚拟节点和前置指针
    public ListNode removeElements1(ListNode head, int val) {
        ListNode newHead = new ListNode(-1, head);
        ListNode pre = newHead;
        while (head != null) {
            if (head.val == val) {
                head = head.next;
                pre.next = head;
            } else {
                pre = head;
                head = head.next;
            }
        }
        return newHead.next;
    }

    //方法二：单独处理头节点和前置指针
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }

        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null) {
            if (cur.val == val) {
                cur = cur.next;
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
