import java.util.PriorityQueue;

/*
* 剑指 Offer II 078. 合并排序链表
* */
public class jianzhi78 {

   public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(((o1, o2) -> {
            return o1.val - o2.val;
        }));
        for (ListNode node : lists){
            while (node != null){
                queue.add(node);
                node = node.next;
            }
        }
        ListNode ans = new ListNode();
        ListNode cur = ans;
        while (queue.size() > 0){
            cur.next = queue.poll();
            cur = cur.next;
        }
        cur.next = null;
        return ans.next;
    }

}
