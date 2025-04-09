import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        List<Integer> indexList = new ArrayList<>();
        boolean[] check = new boolean[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            int num = input % K;
            if (!check[num]) {
                check[num] = true;       // 나머지 분포 표시
                indexList.add(num);      // 인덱스 저장
            }
        }
        Collections.sort(indexList);

        st = new StringTokenizer(br.readLine());

        int max = K - 1;        // 나머지의 최댓값
        int flag = K - 1;       // 나머지가 최댓값 일 때의 check 인덱스를 표시
        for (int i = 0; i < T; i++) {
            int query = Integer.parseInt(st.nextToken());
            query %= K;

            flag -= query;      // 더해지는 값만큼 flag 를 왼쪽으로 옮김
            if (flag < 0) {
                flag += K;
            }

            int find = Collections.binarySearch(indexList, flag);      // flag 왼쪽으로 가장 가까운 인덱스 찾기
            if (find < 0) {
                find = -(find + 1) - 1;
                if (find == -1) {
                    find = indexList.size() - 1;
                }
            }
            int index = indexList.get(find);
            int distance = flag - index;
            if (distance < 0) {
                distance += K;
            }
            sb.append(max - distance).append(" ");      // max 에서 flag 와 떨어진 거리만큼 빼면 최댓값
        }
        System.out.println(sb);
    }
}
