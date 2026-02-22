class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToID = new HashMap<>();
        Map<String, String> owner = new HashMap<>();
        int id = 0;

        // Step 1: Assign IDs and record owner
        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailToID.containsKey(email)) {
                    emailToID.put(email, id++);
                }
                owner.put(email, name);
            }
        }

        // Union Find
        UnionFind uf = new UnionFind(id);

        // Step 2: Union emails within the same account
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstID = emailToID.get(firstEmail);

            for (int i = 2; i < account.size(); i++) {
                uf.union(firstID, emailToID.get(account.get(i)));
            }
        }

        // Step 3: Group emails by their root parent
        Map<Integer, List<String>> map = new HashMap<>();
        for (String email : emailToID.keySet()) {
            int rootID = uf.find(emailToID.get(email));
            map.computeIfAbsent(rootID, x -> new ArrayList<>()).add(email);
        }

        // Step 4: Build result
        List<List<String>> res = new ArrayList<>();
        for (List<String> emails : map.values()) {
            Collections.sort(emails);
            String name = owner.get(emails.get(0));
            List<String> merged = new ArrayList<>();
            merged.add(name);
            merged.addAll(emails);
            res.add(merged);
        }

        return res;
    }

    class UnionFind {
        int[] parent, rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) return;

            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}