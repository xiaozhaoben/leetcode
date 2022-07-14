/*
 * 558. 四叉树交集
 * */
public class leetcode558 {

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

    ;

    class Solution {
        public Node intersect(Node quadTree1, Node quadTree2) {
            if (quadTree1.isLeaf) {
                if (quadTree1.val) {
                    return new Node(true, true, null, null, null, null);
                }
                return new Node(quadTree2.val, quadTree2.isLeaf, quadTree2.topLeft
                        , quadTree2.topRight, quadTree2.bottomLeft, quadTree2.bottomRight);
            }
            if (quadTree2.isLeaf) {
                return intersect(quadTree2, quadTree1);
            }
            Node n1 = intersect(quadTree1.topLeft, quadTree2.topLeft);
            Node n2 = intersect(quadTree1.topRight, quadTree2.topRight);
            Node n3 = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
            Node n4 = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
            if (n1.isLeaf && n2.isLeaf && n3.isLeaf && n4.isLeaf && n1.val == n2.val && n2.val == n3.val && n3.val == n4.val) {
                return new Node(n1.val, true, null, null, null, null);
            }
            return new Node(false, false, n1, n2, n3, n4);
        }
    }

}
