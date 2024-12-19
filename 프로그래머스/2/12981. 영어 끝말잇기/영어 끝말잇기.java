import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        
        Set<String> set = new HashSet<>();
    
        String preWord = words[0];
        set.add(preWord);
                
        for(int i=1;i<words.length;i++){
            String word = words[i];
            
            if(!checkStartChar(preWord,word) || !set.add(word)){
                int person = (i%n) + 1;
                int turn = (i/n) + 1;
                answer[0] = person;
                answer[1] = turn;
                return answer;
            }
            preWord = word;
        }
        return answer;
    }
    
    static boolean checkStartChar(String preWord,String word){
        return preWord.charAt(preWord.length()-1) == word.charAt(0);
    }
        
}