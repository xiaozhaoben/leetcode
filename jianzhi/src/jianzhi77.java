import java.util.PriorityQueue;

/*
* 剑指 Offer II 075. 数组相对排序
* */
public class jianzhi77 {

      public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });
        while (head != null){
            queue.add(head);
            head = head.next;
        }
        ListNode ans = new ListNode();
        ListNode cur = ans;
        while (queue.size() > 0){
            cur.next = queue.poll();
            cur = cur.next;
        }
        return ans.next;
    }

}
