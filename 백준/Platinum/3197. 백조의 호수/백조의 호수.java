import java.io.*;
import java.util.*;

public class Main {

    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, -1, 0, 1};

    private static final char ICE = 'X';
    private static final char WATER = '.';
    private static final char SWAN = 'L';
    private static int R;
    private static int C;

    private static boolean MEET = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        boolean[][] visitL1 = new boolean[R][C];
        boolean[][] visitL2 = new boolean[R][C];
        Queue<Integer> waterQ = new LinkedList<>();
        Queue<Integer> L1Q = new LinkedList<>();
        Queue<Integer> L2Q = new LinkedList<>();

        boolean first = true;
        for (int r = 0; r < R; r++) {
            String input = br.readLine();
            for (int c = 0; c < C; c++) {
                char ch = input.charAt(c);
                map[r][c] = ch;
                if (ch == SWAN) {
                    if (first) {
                        first = false;
                        L1Q.add(r * C + c);
                        visitL1[r][c] = true;
                    } else {
                        L2Q.add(r * C + c);
                        visitL2[r][c] = true;
                    }
                }
            }
        }

        fillWaterQ(waterQ, map);

        int days = 0;
        // 처음부터 마주칠 수 있는 경우
        L1Q = check(L1Q, map, visitL1, visitL2);
        L2Q = check(L2Q, map, visitL2, visitL1);
        if (MEET) {
            System.out.println(days);
            return;
        }

        while (!MEET) {
            melt(waterQ, map);
            L1Q = check(L1Q, map, visitL1, visitL2);
            L2Q = check(L2Q, map, visitL2, visitL1);
            days++;
        }
        System.out.println(days);
    }

    // 백조 영역 표시, 마주치면 MEET = true
    private static Queue<Integer> check(Queue<Integer> q, char[][] map, boolean[][] visit, boolean[][] otherVisit) {
        Queue<Integer> temp = new LinkedList<>();

        while (!q.isEmpty()) {
            int index = q.poll();
            int r = index / C;
            int c = index % C;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                    continue;
                }
                if (visit[nr][nc]) {
                    continue;
                }

                char ch = map[nr][nc];
                if (ch == WATER || ch == SWAN) {
                    visit[nr][nc] = true;
                    if (otherVisit[nr][nc]) {
                        MEET = true;
                        return temp;
                    }
                    q.add(nr * C + nc);
                } else if (ch == ICE) {
                    visit[nr][nc] = true;
                    temp.add(nr * C + nc);
                }
            }
        }
        return temp;
    }

    // waterQ 의 모든 Locate 의 상하좌우를 얼음이면 녹이고 waterQ 에 담음
    private static void melt(Queue<Integer> waterQ, char[][] map) {
        int size = waterQ.size();
        while (size-- > 0) {
            int index = waterQ.poll();
            int r = index / C;
            int c = index % C;
            for (int i = 0; i < 4; i++) {
                int nextRow = r + dr[i];
                int nextColumn = c + dc[i];
                if (nextRow >= 0 && nextRow < R && nextColumn >= 0 && nextColumn < C) {
                    if (map[nextRow][nextColumn] == ICE) {
                        map[nextRow][nextColumn] = WATER;
                        waterQ.add(nextRow * C + nextColumn);
                    }
                }
            }
        }
    }

    private static void fillWaterQ(Queue<Integer> waterQ, char[][] map) {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] != WATER) {
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    int nextRow = r + dr[i];
                    int nextColumn = c + dc[i];
                    if (nextRow >= 0 && nextRow < R && nextColumn >= 0 && nextColumn < C) {
                        if (map[nextRow][nextColumn] == ICE) {
                            waterQ.add(r * C + c);
                            break;
                        }
                    }
                }
            }
        }
    }
}
