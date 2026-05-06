import java.util.List;
import java.util.ArrayList;

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

class Solution {
    private void postorder(List<Integer> ans, TreeNode node) {
        if (node == null) {
            return;
        }
        postorder(ans, node.left);
        postorder(ans, node.right);
        ans.add(node.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorder(ans, root);
        return ans;
    }
}