import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] expected_days = new int[progresses.length];
        
        for(int i = 0; i < progresses.length; i++) {
            int todo = 100 - progresses[i];
            int expected_day = todo / speeds[i];
            
            if(todo % speeds[i] == 0) {
                expected_days[i] = expected_day;
            }else {
                expected_days[i] = expected_day + 1;
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        int count = 1;
        int deploy_day = expected_days[0];
        
        for(int i = 1; i < expected_days.length; i++) {
            if(expected_days[i] > deploy_day) {
                answer.add(count);
                count = 1;
                deploy_day = expected_days[i];
            }else {
                count++;
            }
        }
        answer.add(count);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}