import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] map = new int[101];
        Arrays.fill(map, Integer.MAX_VALUE);
        Map<Integer, Integer> root = new HashMap<>();

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            root.put(start, end);
        }
        map[1] = 0;
        logic(1, 1, map, root);
        System.out.println(map[100]);
    }

    private static void logic(int index, int turn, int[] map, Map<Integer, Integer> root) {
        if (index >= map.length - 1) {
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        int LastNotRootIndex = index;

        for (int i = 1; i <= 6; i++) {
            int next = index + i;
            if (next >= map.length) {
                break;
            }

            boolean nextIsRoot = root.containsKey(next);
            if (!nextIsRoot) {
                LastNotRootIndex = next;
            }

            if (map[next] > turn) {
                map[next] = turn;
                if (nextIsRoot) {
                    q.add(next);
                }
            }
        }
        while (!q.isEmpty()) {
            int start = q.poll();
            int end = root.get(start);
            if (map[end] > turn) {
                map[end] = turn;
                logic(end, turn + 1, map, root);
            }
        }
        logic(LastNotRootIndex, turn + 1, map, root);
    }
}
