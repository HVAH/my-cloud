package com.mall.study.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。
 *              将两数相加返回一个新的链表。你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *              输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *              输出：7 -> 0 -> 8
 *              原因：342 + 465 = 807
 * @Author HuangJiang
 * @Date 2018/8/3 14:31
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[]args){
        int [] arr = {5};
        int [] arr2 = {6};
        ListNode listNode1 = initListNode(arr);
        ListNode listNode2 = initListNode(arr2);

        ListNode listNode = addTwoNumbers(listNode1, listNode2);
        System.out.println();
        Random random = new Random();
        random.nextInt(1);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 对应位置的数值相加,如果产生进位则需在下一次循环+1,若末次循环产生进位,则需注意则增加一个最高位为1,
        int l1NextValue;
        int l2NextValue;
        // 进位数
        int carry = 0;
        // 先用数组记录每位上的数值
        List<Integer> list = new ArrayList<>();

        do {
            if (l1 == null) {
                l1NextValue = 0;
            } else {
                l1NextValue = l1.val;
                l1 = l1.next;
            }
            if (l2 == null) {
                l2NextValue = 0;
            } else {
                l2NextValue = l2.val;
                l2 = l2.next;
            }
            // 产生进位
            if ((l1NextValue + l2NextValue + carry) > 9) {
                list.add((l1NextValue + l2NextValue + carry) % 10);
                carry = 1;
            } else {
                list.add(l1NextValue + l2NextValue + carry);
                carry = 0;
            }
        }while (l1 != null || l2 != null);

        // 如果最后两位相加产生进位,则多一位,最高位为1(最大为9+9+1)
        if (carry == 1) {
            list.add(1);
        }

        int[] arr = new int[list.size()];

        for (int j = 0; j < arr.length; j++) {
            if (!list.get(j).equals(0)) {
                arr[j] = list.get(j);
            }
        }

        return initListNode(arr);
    }

    /**
     * 初始化一个单向链表
     * @param arr
     * @return
     */
    static ListNode initListNode(int [] arr) {
        if (arr.length == 0) {
            return new ListNode(0);
        }
        return initListNode(arr, new ListNode(arr[0]), 1);
    }

    /**
     * 初始化一个单向链表
     * @param arr
     * @param listNode
     * @param currentIndex
     * @return
     */
    static ListNode initListNode(int [] arr, ListNode listNode, int currentIndex) {
        if (currentIndex < arr.length) {
            listNode.next = new ListNode(arr[currentIndex]);
            currentIndex ++;
            initListNode(arr, listNode.next, currentIndex);
        }
        return listNode;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
