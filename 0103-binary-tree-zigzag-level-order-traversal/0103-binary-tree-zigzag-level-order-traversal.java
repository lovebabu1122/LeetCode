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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean dicision=true;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> ans = new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode snode=q.peek();
                q.poll();
                if (dicision) {
                    ans.add(snode.val);
                }
                else{ 
                    ans.add(0, snode.val);
                }
                if (snode.left != null){
                    q.add(snode.left);
                }
                if (snode.right != null){
                    q.add(snode.right);
                }
            }
            result.add(ans);
            dicision=!dicision;
        }
        return result;
    }
}