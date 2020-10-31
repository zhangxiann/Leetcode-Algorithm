// Linked List Cycle
// https://leetcode.com/problems/linked-list-cycle/description/

public class Solution141 {
    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (fast==slow)
                return true;
        }
        return false;
    }
}