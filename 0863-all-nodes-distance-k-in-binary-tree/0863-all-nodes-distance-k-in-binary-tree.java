/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, null, parentMap);

        List<Integer> result = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(target);
        visited.add(target);

        int dist = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            if (dist == k) {
                for (TreeNode node : queue) {
                    result.add(node.val);
                }
                return result;
            }

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // neighbors: left, right, parent
                if (node.left != null && visited.add(node.left)) {
                    queue.offer(node.left);
                }
                if (node.right != null && visited.add(node.right)) {
                    queue.offer(node.right);
                }
                if (parentMap.get(node) != null && visited.add(parentMap.get(node))) {
                    queue.offer(parentMap.get(node));
                }
            }

            dist++;
        }

        return result;
    }

    private void buildParentMap(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> map) {
        if (node == null) return;

        map.put(node, parent);
        buildParentMap(node.left, node, map);
        buildParentMap(node.right, node, map);
    }
}