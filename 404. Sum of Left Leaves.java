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
    private int ans;

    private void dfs(TreeNode node, boolean isLeft) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (isLeft) {
                ans += node.val;
            }
            return;
        }
        dfs(node.left, true);
        dfs(node.right, false);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        ans = 0;
        dfs(root, false);
        return ans;
    }
}