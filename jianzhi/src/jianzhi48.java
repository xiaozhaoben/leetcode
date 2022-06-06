import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class jianzhi48 {


  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;

      }
  }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rootSerialize(root, "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] a = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(a));
        return rootDeserialize(list);
    }

    public String rootSerialize(TreeNode root, String str){
        if(root == null){
            return str + "null,";
        }
        str = str + root.val + ",";
        str = rootSerialize(root.left, str);
        str = rootSerialize(root.right, str);
        return str;
    }

    public TreeNode rootDeserialize(List<String> list){
        if(list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = rootDeserialize(list);
        root.right = rootDeserialize(list);
        return root;
    }
}
