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
    public int height(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=height(root.left);
        int right=height(root.right);
        int ans=Math.max(left, right) +1;
        return ans;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int p1 = diameterOfBinaryTree(root.left);
        int p2 = diameterOfBinaryTree(root.right);  
        int p3=height(root.left)+height(root.right);
        int maxDiameter=Math.max(p1,Math.max(p2,p3));
        return maxDiameter;
    }
}