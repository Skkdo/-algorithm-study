import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static class CustomQ {
        private Queue<Integer> q;
        private int[] state;
        private int uniqueCount;

        public CustomQ(int stateSize) {
            this.q = new LinkedList<>();
            this.state = new int[stateSize + 1];
            this.uniqueCount = 0;
        }

        public void add(int n) {
            this.q.add(n);
            if (state[n] == 0) {
                this.uniqueCount++;
            }
            state[n]++;
        }

        public int poll() {
            int n = this.q.poll();
            if (state[n] == 1) {
                this.uniqueCount--;
            }
            state[n]--;
            return n;
        }

        public boolean exist(int n) {
            return state[n] > 0;
        }

        public int size() {
            return q.size();
        }

        public int getUniqueCount() {
            return uniqueCount;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int max = 0;

        CustomQ customQ = new CustomQ(d);
        Queue<Integer> belt = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            belt.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < N; ) {
            int size = customQ.size();
            if (size < k) {
                int n = belt.poll();
                customQ.add(n);
                belt.add(n);
            } else if (size == k) {
                int uniqueCount = customQ.getUniqueCount();
                if (!customQ.exist(c)) {
                    uniqueCount++;
                }
                max = Math.max(max, uniqueCount);
                customQ.poll();
                i++;
            } else {
                customQ.poll();
            }
        }
        System.out.println(max);
    }
}
