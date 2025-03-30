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


import java.util.*;

class Pair {
    TreeNode node;
    int hd;  // Horizontal Distance
    int level;  // Level of the node

    public Pair(TreeNode node, int hd, int level) {
        this.node = node;
        this.hd = hd;
        this.level = level;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        // TreeMap: hd -> (level -> List of nodes)
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0)); // Root at hd = 0, level = 0

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            int hd = temp.hd;
            int level = temp.level;
            TreeNode node = temp.node;

            // If hd not in map, put it
            map.putIfAbsent(hd, new TreeMap<>());
            // If level not in map.get(hd), put it
            map.get(hd).putIfAbsent(level, new ArrayList<>());
            // Add node value to List
            map.get(hd).get(level).add(node.val);

            // Add children with updated hd and level
            if (node.left != null) q.add(new Pair(node.left, hd - 1, level + 1));
            if (node.right != null) q.add(new Pair(node.right, hd + 1, level + 1));
        }

        // Extract values from TreeMap
        for (TreeMap<Integer, List<Integer>> levelMap : map.values()) {
            List<Integer> col = new ArrayList<>();
            for (List<Integer> values : levelMap.values()) {
                Collections.sort(values); // Sorting for left-to-right order
                col.addAll(values);
            }
            ans.add(col);
        }

        return ans;
    }
}
