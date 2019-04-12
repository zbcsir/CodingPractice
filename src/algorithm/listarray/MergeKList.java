package algorithm.listarray;

import java.util.PriorityQueue;

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}

public class MergeKList {
  
//   Definition for singly-linked list.
    
  public static ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> queen = new PriorityQueue<>((a,b)->a.val-b.val);
    for(int i=0; i<lists.length; i++) {
      queen.offer(lists[i]);
      lists[i] = lists[i].next;
    }
    ListNode merged = null;
    ListNode mergedHead = null;
    if(!queen.isEmpty()) {
      ListNode minNode = queen.poll();
      merged = minNode;
      mergedHead = minNode;
      if(minNode.next != null) {
        queen.add(minNode.next);
        minNode = minNode.next;
      }
      merged = merged.next;
    }
    while(!queen.isEmpty()) {
      ListNode minNode = queen.poll();
      merged = minNode;      
      if(minNode.next != null) {
        queen.add(minNode.next);
        minNode = minNode.next;
      }
//      ListNode tmpNext = 
      merged = merged.next;
    }
    return mergedHead;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ListNode list11 = new ListNode(1);
    ListNode list12 = new ListNode(4);
    list11.next = list12;
    ListNode list13 = new ListNode(5);
    list12.next = list13;
    list13.next = null;
    
    ListNode list21 = new ListNode(1);
    ListNode list22 = new ListNode(3);
    list21.next = list22;
    ListNode list23 = new ListNode(4);
    list22.next = list23;
    list23.next = null;
    
    ListNode list31 = new ListNode(2);
    ListNode list32 = new ListNode(6);
    list31.next = list32;
    list32.next = null;
    
    ListNode[] lists = new ListNode[3];
    lists[0] = list11;
    lists[1] = list21;
    lists[2] = list31;
    ListNode mergedList = mergeKLists(lists);
    System.out.println(mergedList.val);
  }

}
