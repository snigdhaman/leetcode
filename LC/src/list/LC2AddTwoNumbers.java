package list;

public class LC2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode currNode = null;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;
            if (res == null) {
                res = new ListNode(sum % 10);
                currNode = res;
            }
            else {
                ListNode node = new ListNode(sum % 10);
                currNode.next = node;
                currNode = currNode.next;
            }
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return res;
    }
}
