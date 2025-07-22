import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String,Integer> map = new HashMap<>();
        
        for(String[] data : clothes) {
            String k = data[1];
            map.compute(k, (key, value) -> value == null ? 1 : value + 1);
        }
        
        int sum = 1;
        Collection<Integer> arr = map.values();
        
        for(Integer count : arr) {
            sum *= count + 1;
        }
        
        return sum - 1;
    }
}