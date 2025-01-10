import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static class SegmentTree {
        private long[] tree;

        public SegmentTree(int arrayLength) {
            int h = (int) Math.ceil(Math.log(arrayLength) / Math.log(2));
            tree = new long[1 << (h + 1)];
        }

        public void init(int node, int start, int end, long[] array) {
            if (start == end) {
                tree[node] = array[start];
                return;
            }

            int mid = (start + end) / 2;
            int leftChild = 2 * node;
            int rightChild = 2 * node + 1;

            init(leftChild, start, mid, array);
            init(rightChild, mid + 1, end, array);

            tree[node] = tree[leftChild] + tree[rightChild];
        }

        public void update(int node, int start, int end, int index, long value) {
            if (index < start || index > end) {
                return;
            }

            if (start == end) {
                tree[node] = value;
                return;
            }

            int mid = (start + end) / 2;
            int leftChild = 2 * node;
            int rightChild = 2 * node + 1;

            update(leftChild, start, mid, index, value);
            update(rightChild, mid + 1, end, index, value);

            tree[node] = tree[leftChild] + tree[rightChild];
        }

        public long sum(int node, int start, int end, int left, int right) {
            if (right < start || left > end) {
                return 0;
            }

            if (left <= start && right >= end) {
                return tree[node];
            }

            int mid = (start + end) / 2;
            int leftChild = 2 * node;
            int rightChild = 2 * node + 1;

            return sum(leftChild, start, mid, left, right)
                    + sum(rightChild, mid + 1, end, left, right);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder builder = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] array = new long[N + 1];
        SegmentTree segmentTree = new SegmentTree(N + 1);

        for (int i = 1; i < N + 1; i++) {
            array[i] = Long.parseLong(br.readLine());
        }

        segmentTree.init(1, 1, N, array);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                long c = Long.parseLong(st.nextToken());
                segmentTree.update(1, 1, N, b, c);
            }
            if (a == 2) {
                int c = Integer.parseInt(st.nextToken());
                long sum = segmentTree.sum(1, 1, N, b, c);
                builder.append(sum).append("\n");
            }
        }
        System.out.print(builder);
    }
}