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
// DFS -> Recursive Solution
// Time : O(n), Space: O(h) for recursion stack
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        // Swap children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Invert Trees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}