package com.leetcode.problems.addtwonumbers;

/**
 * @Author Duole
 * @Version 1.0
 */
public class addTwoNumbersSolution {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(9);

        ListNode m1 = new ListNode(9);
        ListNode m2 = new ListNode(9);
        ListNode m3 = new ListNode(9);
        ListNode m4 = new ListNode(9);

        n1.next = n2;
        n2.next = n3;

        m1.next = m2;
        m2.next = m3;
        m3.next = m4;

        Solution solution = new Solution();
        ListNode listNode = solution.addTwoNumbers(n1, m1);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultList = null;
        ListNode curNode = resultList;
        int sum = 0;
        //进位标志
        boolean addOneFlag = false;
        while (true) {
            if (l1 != null && l2 != null) {
                //判断前一位要不要进位
                ListNode tempNode = new ListNode();
                tempNode.val = addOneFlag ? 1 : 0;
                sum = l1.val + l2.val;
                tempNode.val = tempNode.val + sum;
                if (tempNode.val >= 10) {
                    addOneFlag = true;
                    tempNode.val = tempNode.val % 10;
                } else {
                    addOneFlag = false;
                }
                if (resultList == null) {
                    resultList = tempNode;
                    curNode = tempNode;
                } else {
                    curNode.next = tempNode;
                }
                l1 = l1.next;
                l2 = l2.next;
                if (curNode.next != null) {
                    curNode = curNode.next;
                }
            } else {
                ListNode tempNode = new ListNode();
                tempNode.val = addOneFlag ? 1 : 0;
                if (l1 != null) {
                    tempNode.val = tempNode.val + l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    tempNode.val = tempNode.val + l2.val;
                    l2 = l2.next;
                }
                if (tempNode.val >= 10) {
                    addOneFlag = true;
                    tempNode.val = tempNode.val % 10;
                } else {
                    addOneFlag = false;
                }
                curNode.next = tempNode;
                curNode = curNode.next;
            }
            if (l1 == null && l2 == null) {
                if (!addOneFlag) {
                    break;
                } else {
                    ListNode tempNode = new ListNode(1);
                    curNode.next = tempNode;
                }
            }
        }
        return resultList;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
