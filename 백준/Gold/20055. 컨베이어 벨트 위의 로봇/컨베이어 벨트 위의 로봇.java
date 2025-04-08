import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[2 * N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int upIndex = 0;
        int downIndex = N - 1;
        int countZero = 0;
        int level = 1;
        Queue<Integer> robotIndexQ = new LinkedList<>();
        boolean[] existRobot = new boolean[A.length];
        while (true) {

            // 1
            upIndex--;
            if (upIndex < 0) {
                upIndex = A.length - 1;
            }

            downIndex--;
            if (downIndex < 0) {
                downIndex = A.length - 1;
            }

            // 2
            int size = robotIndexQ.size();
            for (int i = 0; i < size; i++) {
                int index = robotIndexQ.poll();
                if (index == downIndex) {
                    existRobot[index] = false;
                    continue;
                }

                int nextIndex = index + 1;
                if (nextIndex > A.length - 1) {
                    nextIndex = 0;
                }

                if (!existRobot[nextIndex] && A[nextIndex] > 0) {
                    existRobot[index] = false;
                    A[nextIndex]--;
                    if (A[nextIndex] == 0) {
                        countZero++;
                    }

                    if (nextIndex == downIndex) {
                        continue;
                    }

                    existRobot[nextIndex] = true;
                    robotIndexQ.add(nextIndex);
                } else {
                    robotIndexQ.add(index);
                }
            }

            // 3
            if (A[upIndex] > 0) {
                existRobot[upIndex] = true;
                A[upIndex]--;
                if (A[upIndex] == 0) {
                    countZero++;
                }
                robotIndexQ.add(upIndex);
            }

            // 4
            if (countZero >= K) {
                break;
            }
            level++;
        }
        System.out.println(level);
    }
}
