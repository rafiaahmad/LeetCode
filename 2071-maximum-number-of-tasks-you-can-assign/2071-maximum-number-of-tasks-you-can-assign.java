class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        // Step 1: Sort tasks and workers
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int left = 0;
        int right = Math.min(tasks.length, workers.length);

        // Step 2: Binary search on number of tasks
        while (left < right) {
            int mid = (left + right + 1) / 2;

            if (canAssign(mid, tasks, workers, pills, strength)) {
                left = mid;       // try for more tasks
            } else {
                right = mid - 1;  // reduce tasks
            }
        }
        return left;
    }

    // Step 3: Feasibility check for k tasks
    private boolean canAssign(
            int k,
            int[] tasks,
            int[] workers,
            int pills,
            int strength
    ) {
        Deque<Integer> deque = new ArrayDeque<>();
        int taskIndex = 0;
        int pillsLeft = pills;

        // Use strongest k workers
        for (int i = workers.length - k; i < workers.length; i++) {
            int worker = workers[i];

            // Add all tasks that this worker *can possibly do*
            while (taskIndex < k && tasks[taskIndex] <= worker + strength) {
                deque.addLast(tasks[taskIndex]);
                taskIndex++;
            }

            if (deque.isEmpty()) {
                return false;
            }

            // If worker can do the easiest task without pill
            if (deque.peekFirst() <= worker) {
                deque.pollFirst();
            } else {
                // Must use a pill
                if (pillsLeft == 0) {
                    return false;
                }
                pillsLeft--;
                deque.pollLast(); // assign hardest possible task
            }
        }
        return true;
    }
}