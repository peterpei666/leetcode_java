import java.util.ArrayList;
import java.util.List;

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
    private void preorder(TreeNode node, int d, List<Integer> ans) {
        if (node == null) {
            return;
        }
        if (d == ans.size()) {
            ans.add(node.val);
        }
        ans.set(d, node.val);
        preorder(node.left, d + 1, ans);
        preorder(node.right, d + 1, ans);
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, 0, ans);
        return ans;
    }
}