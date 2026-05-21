class MyCalendar {

    private TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {

        Integer prev = calendar.floorKey(start);
        Integer next = calendar.ceilingKey(start);

        // overlap with previous
        if (prev != null && calendar.get(prev) > start) {
            return false;
        }

        // overlap with next
        if (next != null && next < end) {
            return false;
        }

        calendar.put(start, end);

        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna