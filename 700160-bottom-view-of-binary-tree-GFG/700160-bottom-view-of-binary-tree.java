/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    static class Pair{
        Node node;
        int hd;
        
        Pair(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        
        q.offer(new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            Node node = p.node;
            int hd = p.hd;
            
            // overwrite to ensure bottom-most
            map.put(hd, node.data);
            
            if(node.left != null)
                q.offer(new Pair(node.left, hd-1));
                
            if(node.right != null)
                q.offer(new Pair(node.right, hd+1));
        }
        
        for(int val : map.values())
            res.add(val);
            
        return res;
    }
}