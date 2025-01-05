import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static class Quiz {
        int deadLine;
        int reward;

        private Quiz(int deadLine, int reward) {
            this.deadLine = deadLine;
            this.reward = reward;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Quiz> pq = new PriorityQueue<>(Comparator.comparingInt((Quiz q) -> -q.reward));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int reward = Integer.parseInt(st.nextToken());
            pq.add(new Quiz(deadLine, reward));
        }

        int[] parent = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }

        int maxReward = 0;
        while (!pq.isEmpty()) {
            Quiz quiz = pq.poll();
            int time = find(parent, quiz.deadLine);
            if (time > 0){
                maxReward += quiz.reward;
                union(parent,time,time-1);
            }
        }
        System.out.println(maxReward);
    }

    private static int find(int[] parent, int time) {
        if (parent[time] == time) {
            return time;
        }
        return parent[time] = find(parent, parent[time]);
    }

    private static void union(int[] parent, int time, int nearTime) {
        int a = find(parent, time);
        int b = find(parent, nearTime);
        parent[a] = b;
    }
}

