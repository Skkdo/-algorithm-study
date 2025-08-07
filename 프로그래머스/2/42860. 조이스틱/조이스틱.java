import java.util.*;

class Solution {
    public int solution(String name) {
        int count = 0;
        
        for(int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if(name.charAt(i) != 'A') {
                count += Math.min(c - 'A', 'Z' - c + 1);
            }
        }
        
        int min = name.length() - 1;
        for(int i = 0; i < name.length(); i++) {
            int a_index = i + 1;
            
            while(a_index < name.length() && name.charAt(a_index) == 'A') {
                a_index++;
            }
            
            int length = i + (name.length() - a_index) + Math.min(i, (name.length() - a_index));
            min = Math.min(length, min);
        }
        
        count += min;
        return count;
    }
}