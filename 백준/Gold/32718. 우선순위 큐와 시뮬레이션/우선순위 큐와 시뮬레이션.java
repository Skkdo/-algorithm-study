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

        Set<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            int num = input % K;
            set.add(num);
        }

        List<Integer> indexList = new ArrayList<>(set);
        Collections.sort(indexList);

        st = new StringTokenizer(br.readLine());

        int max = K - 1;
        int flag = K - 1;

        for (int i = 0; i < T; i++) {
            int query = Integer.parseInt(st.nextToken()) % K;

            flag = (flag - query + K) % K;

            int find = Collections.binarySearch(indexList, flag);
            if (find < 0) {
                find = -(find + 1) - 1;
                if (find == -1) {
                    find = indexList.size() - 1;
                }
            }

            int index = indexList.get(find);
            int distance = (flag - index + K) % K;
            sb.append(max - distance).append(" ");
        }
        System.out.println(sb);
    }
}
