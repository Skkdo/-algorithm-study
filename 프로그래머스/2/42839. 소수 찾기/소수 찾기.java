import java.util.*;

class Solution {

    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        boolean[] check = new boolean[numbers.length()];
        DFS(numbers,"",check);
        
        int answer = 0;
        for(Integer num : set) {
            if(isPrime(num)) answer++;
        }
        return answer;
    }
    
    public void DFS(String numbers, String string, boolean[] check) {
        if(!string.equals("")){
            set.add(Integer.parseInt(string));
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if(!check[i]) {
                check[i] = true;
                DFS(numbers, string + numbers.charAt(i), check);
                check[i] = false;
            }
        }
    }
    
    public boolean isPrime(Integer num) {
        if(num < 2) return false;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}