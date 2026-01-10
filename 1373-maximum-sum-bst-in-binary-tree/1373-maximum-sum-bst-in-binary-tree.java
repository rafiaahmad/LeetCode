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
    int maxSum = 0;

    class Info{
        boolean isBST;
        int min, max, sum;

        Info(boolean isBST, int min, int max, int sum){
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    public int maxSumBST(TreeNode root) {
        postorder(root);
        return maxSum;
    }

    private Info postorder(TreeNode node){
        if(node == null)
            return (new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0));

        Info left   = postorder(node.left);
        Info right  = postorder(node.right);

        // check BST property
        if(    left.isBST && right.isBST
            && node.val > left.max && node.val < right.min){

            int currentSum = node.val + left.sum + right.sum;
            maxSum = Math.max(maxSum, currentSum);

            return new Info(
                true, 
                Math.min(node.val, left.min),
                Math.max(node.val, right.max),
                currentSum
            );
        }

        // No BST
        return new Info(false, 0, 0, 0);
    }
}