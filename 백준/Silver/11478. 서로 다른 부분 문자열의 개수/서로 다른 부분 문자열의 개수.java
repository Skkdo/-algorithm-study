import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        Set<String> set = new HashSet<>();
        logic(set, string, 1);
        System.out.print(set.size());
    }

    private static void logic(Set<String> set, String string, int depth) {
        if (depth > string.length()) {
            return;
        }

        for (int i = 0; i + depth <= string.length(); i++) {
            set.add(string.substring(i, i + depth));
        }
        logic(set, string, depth + 1);
    }
}