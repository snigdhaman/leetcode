package list;

import java.util.Arrays;

public class LC23MergeKSortedList {

    public ListNode mergeKLists (ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeLists(lists, 0, lists.length - 1);
    }

    ListNode mergeLists (ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start == end - 1) {
            return merge2Lists(lists[start], lists[end]);
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeLists(lists, start, mid);
        ListNode right = mergeLists(lists, mid + 1, end);
        return merge2Lists(left, right);
    }

    ListNode merge2Lists (ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode currNode = null;

        while (list1 != null && list2 != null) {
            ListNode node = new ListNode();
            if (list1.val < list2.val) {
                node.val = list1.val;
                list1 = list1.next;
            }
            else {
                node.val = list2.val;
                list2 = list2.next;
            }
            if (head == null) {
                head = node;
                currNode = head;
            }
            else {
                currNode.next = node;
                currNode = currNode.next;
            }
        }

        while (list1 != null) {
            ListNode node = new ListNode();
            node.val = list1.val;
            if (head == null) {
                head = node;
                currNode = head;
            }
            else {
                currNode.next = node;
                currNode = currNode.next;
            }
            list1 = list1.next;
        }

        while (list2 != null) {
            ListNode node = new ListNode();
            node.val = list2.val;
            if (head == null) {
                head = node;
                currNode = head;
            }
            else {
                currNode.next = node;
                currNode = currNode.next;
            }
            list2 = list2.next;
        }
        return head;
    }

    public static void main (String[] args) {
        LC23MergeKSortedList lc23MergeKSortedList = new LC23MergeKSortedList();
    }
}
