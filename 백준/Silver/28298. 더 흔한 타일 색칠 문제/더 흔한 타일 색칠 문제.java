import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        private int[] countArray;
        private char maxAlphabet;
        private int totalCount;

        public Node() {
            this.countArray = new int[26];
            this.maxAlphabet = '0';
            this.totalCount = 0;
        }

        public void count(char alphabet) {
            int index = alphabet - 'A';
            this.countArray[index]++;
            this.totalCount++;
        }

        public char getMaxAlphabet() {
            if (this.maxAlphabet < 'A') {
                int max = 0;
                int index = 0;
                for (int i = 0; i < this.countArray.length; i++) {
                    int count = this.countArray[i];
                    if (count > max) {
                        max = count;
                        index = i;
                    }
                }
                this.maxAlphabet = (char) (index + 'A');
            }
            return this.maxAlphabet;
        }

        public int getCountExcludeMaxAlphabet() {
            int index = getMaxAlphabet() - 'A';
            return totalCount - countArray[index];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        Node[][] pattern = new Node[K][K];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                pattern[i][j] = new Node();
            }
        }

        initPattern(map, pattern);

        int rePaintingCount = 0;
        for (int i = 0; i < pattern.length; i++) {
            for (int j = 0; j < pattern[0].length; j++) {
                rePaintingCount += pattern[i][j].getCountExcludeMaxAlphabet();
            }
        }

        paintingMapByPattern(map, pattern, sb);

        System.out.println(rePaintingCount);
        System.out.println(sb);
    }

    private static void initPattern(char[][] map, Node[][] pattern) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                char alphabet = map[i][j];
                pattern[i % pattern.length][j % pattern[0].length].count(alphabet);
            }
        }
    }

    private static void paintingMapByPattern(char[][] map, Node[][] pattern, StringBuilder sb) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                char alphabet = pattern[i % pattern.length][j % pattern[0].length].getMaxAlphabet();
                sb.append(alphabet);
            }
            sb.append("\n");
        }
    }
}
