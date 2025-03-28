import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int L = Integer.parseInt(br.readLine());
        int[] S = new int[L];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int N = Integer.parseInt(br.readLine());
        
        Arrays.sort(S);
        
        if (Arrays.binarySearch(S, N) >= 0) {
            System.out.println(0);
            return;
        }
        
        int min = 0, max = 0;
        for (int i = 0; i < L; i++) {
            if (S[i] < N) {
                min = S[i];
            } else {
                max = S[i];
                break;
            }
        }
        
        int count = 0;
        for (int A = min + 1; A <= N; A++) {
            for (int B = N; B < max; B++) {
                if (A < B) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
