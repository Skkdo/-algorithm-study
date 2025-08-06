import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        
        for(int i = 3; i <= Math.sqrt(total); i++) {
            if(total % i != 0) continue;
            
            int w = Math.max(i, total / i);
            int h = Math.min(i, total / i);
            
            if(!check(brown, yellow, w, h)) continue;
            
            answer[0] = w;  
            answer[1] = h;
            break;
        }
        return answer;
    }
    
    public boolean check(int brown, int yellow, int w, int h) {
        if((w + h - 2) * 2 != brown) return false;
        if((w - 2) * (h - 2) != yellow) return false;
        return true;
    }
}