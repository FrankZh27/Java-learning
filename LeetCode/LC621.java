class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        int[] map = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            map[tasks[i]-'A']++;
        }
        Queue<Integer> pq = new PriorityQueue<Integer>(5, Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                pq.offer(map[i]);
            }
        }
        List<Integer> list = new ArrayList<>();
        
        while (!pq.isEmpty()) {
            for (int i = 0; i <= n; i++) {
                if (pq.isEmpty() && list.isEmpty()) {
                    return time;
                }
                else {
                    time++;
                    if (!pq.isEmpty()) {
                        int num = pq.poll();
                        if (--num > 0) {
                            list.add(num);
                        }
                    }
                }
            }
            while (!list.isEmpty()) {
                int num = list.remove(0);
                pq.offer(num);
            }
        }
        return time;
    }
}
