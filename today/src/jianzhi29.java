
/**
 * 剑指 Offer II 029. 排序的循环链表
 * @author xiao__zhao
 */
public class jianzhi29 {

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        if(head == null){
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        Node fast = head.next;
        Node slow = head;
        while(slow.val <= fast.val){
            slow = slow.next;
            fast = fast.next;
            if(fast == head) break;
        }
        Node realHead = fast;
        while(fast.val <= insertVal){
            fast = fast.next;
            slow = slow.next;
            if(fast == realHead) break;
        }
        slow.next = new Node(insertVal, fast);
        return head;
    }
}
