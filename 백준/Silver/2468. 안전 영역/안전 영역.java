import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        int highest = 0;

        for (int y = 0; y < map.length; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < map[y].length; x++) {
                int input = Integer.parseInt(st.nextToken());
                map[y][x] = input;
                highest = Math.max(highest, input);
            }
        }

        int max = 0;
        int height = 0;
        boolean[][] visit;

        while (height <= highest) {
            visit = new boolean[map.length][map[0].length];
            int count = 0;

            for (int y = 0; y < map.length; y++) {
                for (int x = 0; x < map[y].length; x++) {
                    if (visit[y][x]) {
                        continue;
                    }

                    if (map[y][x] <= height) {
                        visit[y][x] = true;
                        continue;
                    }

                    bfs(map, height, visit, x, y);
                    count++;
                }
            }
            max = Math.max(count, max);
            height++;
        }

        System.out.println(max);
    }

    public static void bfs(int[][] map, int height, boolean[][] visit, int startX, int startY) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});
        visit[startY][startX] = true;

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX >= 0 && nextX < map[0].length && nextY >= 0 && nextY < map.length) {
                    if (visit[nextY][nextX]) {
                        continue;
                    }

                    if (map[nextY][nextX] <= height) {
                        visit[nextY][nextX] = true;
                        continue;
                    }
                    q.add(new int[]{nextX, nextY});
                    visit[nextY][nextX] = true;
                }
            }
        }

    }
}
