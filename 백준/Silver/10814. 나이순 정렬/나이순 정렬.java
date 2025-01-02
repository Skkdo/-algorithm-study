import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    private static class Member {
        int age;
        String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder builder = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Member[] array = new Member[N];

        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            array[i] = new Member(age,name);
        }

        Arrays.sort(array, Comparator.comparingInt((Member member)-> member.age));

        for(Member member : array){
            builder.append(member.age)
                    .append(" ")
                    .append(member.name)
                    .append("\n");
        }
        System.out.println(builder);
    }
}