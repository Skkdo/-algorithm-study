import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] arrayLists = new ArrayList[N + 1];
        for (int i = 0; i < arrayLists.length; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            arrayLists[node1].add(node2);
            arrayLists[node2].add(node1);
        }

        boolean[] check = new boolean[N + 1];
        int[] parent = new int[N + 1];

        bfs(arrayLists, check, parent);

        for (int i = 2; i < arrayLists.length; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void bfs(ArrayList<Integer>[] arrayLists, boolean[] check, int[] parent) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        check[1] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int i = 0; i < arrayLists[node].size(); i++) {
                int child = arrayLists[node].get(i);
                if (check[child]) {
                    continue;
                }
                parent[child] = node;
                check[child] = true;
                q.add(child);
            }

        }
    }
}
