import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        int num;
        int move;

        public Node(int num, int move) {
            this.num = num;
            this.move = move;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        Deque<Node> dq = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int move = Integer.parseInt(st.nextToken());
            dq.add(new Node(i, move));
        }

        Node node = dq.poll();
        sb.append(node.num).append(" ");
        int move = node.move;

        while (!dq.isEmpty()) {
            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    dq.addLast(dq.pollFirst());
                }
            } else {
                for (int i = 0; i < -move; i++) {
                    dq.addFirst(dq.pollLast());
                }
            }

            node = dq.pollFirst();
            sb.append(node.num).append(" ");
            move = node.move;
        }
        System.out.println(sb);
    }
}
