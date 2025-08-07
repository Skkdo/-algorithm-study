import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        String answer = "";
        
        for(int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
        
            while(!stack.isEmpty() && k > 0 && stack.peek() < c) {
                stack.pop();
                k--;
            }
            stack.add(c);
        }
        
        while(k-- > 0) {
            stack.pop();
        }
        
        for(Character c : stack) {
            answer += c;
        }
        return answer;
    }
}