import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            ArrayList<Integer>[] arrayLists = new ArrayList[26];
            for (int i = 0; i < arrayLists.length; i++) {
                arrayLists[i] = new ArrayList<>();
            }

            for (int i = 0; i < W.length(); i++) {
                char ch = W.charAt(i);
                int index = ch - 'a';
                arrayLists[index].add(i);
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (ArrayList<Integer> arrayList : arrayLists) {
                if (arrayList.size() >= K) {
                    for (int i = 0; i < arrayList.size() - (K - 1); i++) {
                        int length = arrayList.get(i + K - 1) - arrayList.get(i) + 1;
                        min = Math.min(min, length);
                        max = Math.max(max, length);
                    }
                }
            }

            if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(min + " " + max);
            }
        }
    }
}
