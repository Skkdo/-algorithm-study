import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        int moveCount;
        int beforeValue;
        int value;
        Node next;

        public Node(int value) {
            this.moveCount = 0;
            this.beforeValue = 0;
            this.value = value;
        }

        public void move(int turn) {
            if (this.moveCount < turn) {
                next.moveCount++;
                next.beforeValue = next.value;
                next.value = this.value;
            } else {
                next.moveCount++;
                next.beforeValue = next.value;
                next.value = this.beforeValue;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        Node[][] map = new Node[N][M];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                int value = Integer.parseInt(st.nextToken());
                map[y][x] = new Node(value);
            }
        }

        setDirection(map, 0);
        turn(map,R);

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                int value = map[y][x].value;
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void turn(Node[][] map, int turn) {
        for (int i = 1; i <= turn; i++) {
            for (int y = 0; y < map.length; y++) {
                for (int x = 0; x < map[0].length; x++) {
                    Node node = map[y][x];
                    node.move(i);
                }
            }
        }
    }

    private static void setDirection(Node[][] map, int depth) {
        if (depth >= Math.min(map.length, map[0].length) / 2) {
            return;
        }

        int mapLastXIndex = map[0].length - 1;
        int mapLastYIndex = map.length - 1;
        int x = depth;
        int y = depth;

        Node preNode = map[y][x];

        // right
        x++;
        for (; x <= mapLastXIndex - depth; x++) {
            Node node = map[y][x];
            node.next = preNode;
            preNode = node;
        }
        x--;

        // down
        y++;
        for (; y <= mapLastYIndex - depth; y++) {
            Node node = map[y][x];
            node.next = preNode;
            preNode = node;
        }
        y--;

        // left
        x--;
        for (; x >= depth; x--) {
            Node node = map[y][x];
            node.next = preNode;
            preNode = node;
        }
        x++;

        // up
        y--;
        for (; y >= depth; y--) {
            Node node = map[y][x];
            node.next = preNode;
            preNode = node;
        }
        y++;

        setDirection(map, depth + 1);
    }
}
