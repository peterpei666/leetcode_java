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
    private void dfs(TreeNode node, String cur, List<String> ans) {
        if (node == null) {
            return;
        }
        if (cur.length() > 0) {
            cur += "->";
        }
        cur += node.val;
        if (node.left == null && node.right == null) {
            ans.add(cur);
        }
        dfs(node.left, cur, ans);
        dfs(node.right, cur, ans);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs(root, "", ans);
        return ans;
    }
}