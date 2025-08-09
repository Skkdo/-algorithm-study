import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i <= 8; i++) list.add(new HashSet<>());
        
        for(int i = 1; i <= 8; i++) {
            list.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            for(int j = 1; j < i; j++) {
                for(Integer a : list.get(j)) {
                    for(Integer b : list.get(i - j)) {
                        Integer max = Math.max(a, b);
                        Integer min = Math.min(a, b);
                        
                        list.get(i).add(a + b);
                        list.get(i).add(max - min);
                        list.get(i).add(a * b);
                        if(min != 0)list.get(i).add(max / min);
                    }
                }    
            }
            
            if(list.get(i).contains(number)) return i;
        }
        return -1;
    }
}