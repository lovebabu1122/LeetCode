/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int bottomLeftValue = root.val;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            bottomLeftValue = queue.peek().val; // First element in this level

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // Add children, left first to ensure leftmost node is processed first
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return bottomLeftValue;
    }
}