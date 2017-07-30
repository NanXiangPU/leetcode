public class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        int[] letter = new int[26];
        for (int i = 0; i < tasks.length; ++i) {
            letter[tasks[i] - 'A']++;
        }
        Arrays.sort(letter);
        int time = 0;
        while (letter[25] > 0) {
            int count = 0;
            while (count <= n) {
                if (letter[25] == 0) {
                    break;
                }
                if (count < 26 && letter[25 - count] > 0) {
                    letter[25 - count]--;
                }
                time++;
                count++;
            }
            Arrays.sort(letter);
        }
        return time;
    }

    //PriorityQueu
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(26, Collections.reverseOrder());
        int[] letter = new int[26];
        for (int i = 0; i < tasks.length; ++i) {
            letter[tasks[i] - 'A']++;
        }
        for (int i : letter) {
            if (i != 0) {
                pq.offer(i);
            }
        }
        int time = 0;
        while (!pq.isEmpty()) {
            int i = 0;
            List<Integer> list = new ArrayList<>();
            while (i <= n) {
                if (!pq.isEmpty()) {
                    if (pq.peek() > 1) {
                        list.add(pq.poll() - 1);
                    } else {
                        pq.poll();
                    }
                }
                time++;
                if (pq.isEmpty() && list.size() == 0) {
                    break;
                }
                i++;
            }
            for (Integer integer : list) {
                pq.add(integer);
            }
        }
        return time;
    }
}