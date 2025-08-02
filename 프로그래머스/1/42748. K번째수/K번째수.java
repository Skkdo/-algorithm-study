import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        
        for(int[] cmd : commands) {
            int[] copy = Arrays.copyOfRange(array, cmd[0] - 1, cmd[1]);
            Arrays.sort(copy);
            answer.add(copy[cmd[2] - 1]);
        }
        
        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }
}