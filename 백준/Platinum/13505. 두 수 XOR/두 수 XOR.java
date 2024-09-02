import java.io.*;
import java.util.*;

public class Main {

    static int TrieHeight = 30;

    static class Trie{

        Trie[] child = new Trie[2];

        public Trie(){}

        public void insert(int num){
            Trie now = this;
            for(int i = TrieHeight;i>=0;i--){
                int ith_bit = num & (1<<i);
                int ith_bit_value = ith_bit == 0? 0:1;
                if(now.child[ith_bit_value]==null){
                    now.child[ith_bit_value] = new Trie();
                }
                now = now.child[ith_bit_value];
            }
        }

        public int findMax(int num){
            Trie now = this;
            int result = 0;
            for(int i = TrieHeight;i>=0;i--){
                int ith_bit = num & (1<<i);
                int ith_bit_value = ith_bit == 0? 0:1;
                int reverse_bit_value = ith_bit == 0? 1:0;
                if(now.child[reverse_bit_value]==null){
                    reverse_bit_value = ith_bit_value;
                }
                result += reverse_bit_value<<i;
                now = now.child[reverse_bit_value];
            }
            return result;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        Trie trie = new Trie();

        trie.insert(Integer.parseInt(st.nextToken()));

        for(int i=1;i<N;i++){
            int num =Integer.parseInt(st.nextToken());
            trie.insert(num);
            int result = trie.findMax(num);
            max = Math.max(max,result^num);
        }
        System.out.println(max);
    }



}
