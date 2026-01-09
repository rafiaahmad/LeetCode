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
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root)    ;
        return result;
    }

    private String serialize(TreeNode node){
        if(node == null) return "#";

        String left = serialize(node.left);
        String right = serialize(node.right);

        String serial = node.val + "," + left + "," + right;

        map.put(serial, map.getOrDefault(serial, 0) + 1);

        // add only when seen the second time
        if(map.get(serial) == 2)
            result.add(node);

        return serial;
    }
}