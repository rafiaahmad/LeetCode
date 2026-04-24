class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    private TrieNode root = new TrieNode();

    public int findMaximumXOR(int[] nums) {
        for (int num : nums) {
            insert(num);
        }

        int maxXor = 0;

        // Step 2: Find max XOR
        for (int num : nums) {
            maxXor = Math.max(maxXor, getMaxXor(num));
        }

        return maxXor;
    }

    private void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }

    private int getMaxXor(int num) {
        TrieNode node = root;
        int xor = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int opposite = 1 - bit;

            if (node.children[opposite] != null) {
                xor |= (1 << i); // set this bit
                node = node.children[opposite];
            } else {
                node = node.children[bit];
            }
        }

        return xor;
    }
}