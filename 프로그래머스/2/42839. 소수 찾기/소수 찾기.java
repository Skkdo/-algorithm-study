import java.util.*;
class Solution {
    
    static boolean flag = true;     
    
    public int solution(String numbers) {
        int answer = 0;
        int[] check = new int[10];
        Integer[] numList = new Integer[numbers.length()];

        for (int i = 0; i < numbers.length(); i++) {
            int num = numbers.charAt(i) - '0';
            numList[i] = num;
            check[num]++;
        }
        Arrays.sort(numList, (o1, o2) -> o2 - o1);
        int max = 0;
        for (int i = 0; i < numList.length; i++) {
            max = max * 10 + numList[i];
        }

        boolean[] decimal = new boolean[max + 1];
        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (decimal[i]) continue;
            for (int j = 2; j <= max / i; j++) {
                decimal[i * j] = true;
            }
        }

        for (int i = 2; i <= max; i++) {
            if (decimal[i]) continue;

            flag = true;
            int[] arr = check.clone();
            test(i, arr);
            if (flag) answer++;
        }
        
        return answer;
    }
    public static void test(int num, int[] check) {
        if (!flag) return;
        if (num >= 10) test(num / 10, check);
        if (num < 10) {
            if (0 < check[num]--)  return;
        }
        if (0 < check[num % 10]--)  return;
        flag = false;
    }
}