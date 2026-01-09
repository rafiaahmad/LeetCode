// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {
    int findDist(Node root, int a, int b) {
        // Step 1 : Find LCA
        Node lCA = lca(root, a, b);
        
        int d1 = distance(lCA, a);
        int d2 = distance(lCA, b);
        
        return d1 + d2;
    }
    
    private Node lca(Node node, int a, int b){
        if(node == null) return null;
        if(node.data == a || node.data == b) return node;
        
        Node left = lca(node.left, a, b);
        Node right = lca(node.right, a, b);
        
        if(left != null && right != null) return node;
        return (left != null)? left : right;
    }
    
    private int distance(Node node, int target){
        if(node == null) return -1;
        if(node.data == target) return 0;
        
        int left = distance(node.left, target);
        if(left != -1) return left + 1;
        
        int right = distance(node.right, target);
        if(right != -1) return right + 1;
        
        return -1;
    }
}