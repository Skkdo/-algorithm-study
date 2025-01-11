import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static class Node {
        private int max;
        private int min;

        public Node(int max, int min) {
            this.max = max;
            this.min = min;
        }

        public Node(int num) {
            this.max = num;
            this.min = num;
        }
    }


    private static class SegmentTree {
        private Node[] tree;

        public SegmentTree(int arrayLength) {
            int h = (int) Math.ceil(Math.log(arrayLength) / Math.log(2));
            this.tree = new Node[1 << (h + 1)];
        }

        public void build(int nodeIndex, int start, int end, int[] array) {
            if (start == end) {
                tree[nodeIndex] = new Node(array[start]);
                return;
            }

            int mid = (start + end) / 2;
            int leftChild = 2 * nodeIndex;
            int rightChild = 2 * nodeIndex + 1;

            build(leftChild, start, mid, array);
            build(rightChild, mid + 1, end, array);

            int max = Math.max(tree[leftChild].max, tree[rightChild].max);
            int min = Math.min(tree[leftChild].min, tree[rightChild].min);

            tree[nodeIndex] = new Node(max, min);
        }

        public Node find(int nodeIndex, int start, int end, int left, int right) {
            if (start > right || end < left) {
                return new Node(Integer.MIN_VALUE, Integer.MAX_VALUE);
            }

            if (start >= left && end <= right ) {
                return tree[nodeIndex];
            }

            int mid = (start + end) / 2;
            int leftChild = 2 * nodeIndex;
            int rightChild = 2 * nodeIndex + 1;

            Node leftChildNode = find(leftChild, start, mid, left, right);
            Node rightChildNode = find(rightChild, mid + 1, end, left, right);

            int max = Math.max(leftChildNode.max, rightChildNode.max);
            int min = Math.min(leftChildNode.min, rightChildNode.min);

            return new Node(max, min);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] array = new int[N + 1];
        SegmentTree segmentTree = new SegmentTree(array.length);

        for (int i = 1; i < array.length; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        segmentTree.build(1, 1, N, array);

        while (M != 0) {
            M--;
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Node node = segmentTree.find(1, 1, N, a, b);
            sb.append(node.min).append(" ").append(node.max).append("\n");
        }
        System.out.print(sb);
    }
}