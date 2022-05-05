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
    //方法一：增加一个虚拟头节点
    public ListNode removeElements1(ListNode head, int val) {
        if (null == head){
            return null;
        }
        ListNode tmpHead = new ListNode(-1, head);
        ListNode pre = tmpHead;
        ListNode cur = head;
        while (null != cur) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return tmpHead.next;
    }

    //方法二：直接利用原来的头节点
    public ListNode removeElements(ListNode head, int val) {
        while (null != head && head.val == val) {
            head = head.next;
        }
        if (null == head){
            return null;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (null != cur) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
