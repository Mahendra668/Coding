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
    public ListNode mergeKLists(ListNode[] lists) {
        // Edge case: empty array
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        // Use a min-heap (PriorityQueue) to keep track of smallest nodes
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Add the head of each non-empty list to the heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        
        // Create a dummy node to build the result
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Process all nodes
        while (!minHeap.isEmpty()) {
            // Get the node with smallest value
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;
            
            // If this node has a next, add it to the heap
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }
        
        return dummy.next;
    }
}
