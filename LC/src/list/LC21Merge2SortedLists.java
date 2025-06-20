package list;

public class LC21Merge2SortedLists {

    public ListNode mergeTwoLists (ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode currNode = head;

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
            list1 = list1.next;
            if (head == null) {
                head = node;
                currNode = head;
            }
            else {
                currNode.next = node;
                currNode = currNode.next;
            }
        }
        while (list2 != null) {
            ListNode node = new ListNode();
            node.val = list2.val;
            list2 = list2.next;
            if (head == null) {
                head = node;
                currNode = head;
            }
            else {
                currNode.next = node;
                currNode = currNode.next;
            }
        }
        return head;
    }

    public static void main (String[] args) {
        LC21Merge2SortedLists lc21Merge2SortedLists = new LC21Merge2SortedLists();
    }
}
