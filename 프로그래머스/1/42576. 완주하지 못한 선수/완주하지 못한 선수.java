import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();

        for (String name : participant) {
            map.compute(name, (k, count) -> count == null ? 1 : count + 1);
        }

        for (String name : completion) {
            Integer count = map.get(name);
            if (--count > 0) {
                map.put(name, count);
            } else {
                map.remove(name);
            }
        }
        Set<String> names = map.keySet();
        for(String name : names) {
            Integer count = map.get(name);
            while(count-- > 0) {
                sb.append(name);
            }
        }
        
        return sb.toString();
    }
}