class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        // Build graph + compute in-degrees
        for (int[] p : prerequisites) {
            int course = p[0];
            int prereq = p[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        int[] order = new int[numCourses];
        int idx = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            order[idx++] = node;
            for (int next : graph.get(node)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        if (idx < numCourses) {
            return new int[0]; // cycle found
        }
        return order;
    }
}