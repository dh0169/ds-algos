/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static ListNode insertionSortList(ListNode head) {
        ListNode sortedList = new ListNode(head.val);
        ListNode key = head.next;

        while(key != null){
            //Perform insertion, iterate through our sorted list. Insert key
            ListNode prev = null;
            boolean didInsert = false;

            //Three possible locations for insertion. Head, Middle, Tail
            for (ListNode iter = sortedList; iter != null;) {
                if(key.val < iter.val){
                    //Head
                    if(prev == null){
                        sortedList = new ListNode(key.val, sortedList);
                    }else{
                        //Middle
                        ListNode tmp = new ListNode(key.val, iter);
                        prev.next = tmp;
                    }
                    didInsert = true;
                    break;
                }

                prev = iter;
                iter = iter.next;
            }

            //Tail
            if(prev != null && !didInsert){
                prev.next = new ListNode(key.val, null);
            }

            key = key.next;
        }
        return sortedList;
    }
}