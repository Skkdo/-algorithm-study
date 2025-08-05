import java.util.*;

class Solution {
    
    public class NoNoMath {
        int studentNum;
        int[] pattern;
        int score;
        
        public NoNoMath (int studentNum, int[] pattern) {
            this.studentNum = studentNum;
            this.pattern = pattern;
            this.score = 0;
        }
    }
    public int[] solution(int[] answers) {
        NoNoMath n1 = new NoNoMath(1, new int[]{1,2,3,4,5});
        NoNoMath n2 = new NoNoMath(2, new int[]{2,1,2,3,2,4,2,5});
        NoNoMath n3 = new NoNoMath(3, new int[]{3,3,1,1,2,2,4,4,5,5});
        NoNoMath[] arr = new NoNoMath[]{n1, n2, n3};
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == n1.pattern[i % n1.pattern.length]) n1.score++;
            if(answers[i] == n2.pattern[i % n2.pattern.length]) n2.score++;
            if(answers[i] == n3.pattern[i % n3.pattern.length]) n3.score++;
        }
        
        Arrays.sort(arr, (a, b) -> a.score - b.score);
        
        int maxScore = arr[arr.length - 1].score;
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i].score == maxScore){
                answer.add(arr[i].studentNum);
            }
        }
            
        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }
}