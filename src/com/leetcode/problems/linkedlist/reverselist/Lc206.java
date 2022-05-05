package com.leetcode.problems.linkedlist.reverselist;

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

        char[] s = {'a', 'b'};

    }
}

class Solution {
    //方法一：递归解法
    public ListNode reverseList1(ListNode head) {
        //这里判断head == null 居然是为了验证输入的数组是[]的情况。。。。。。  醉了
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //方法二：双指针
    public ListNode reverseList(ListNode head) {
        //当前节点的前一个节点
        ListNode pre = null;
        //被逆转的每一个节点
        ListNode cur = head;
        while (null != cur) {
            ListNode curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return pre;
    }
}