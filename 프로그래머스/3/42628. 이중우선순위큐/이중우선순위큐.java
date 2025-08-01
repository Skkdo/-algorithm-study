import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();
        
        for(String s : operations) {
            String[] cmd = s.split(" ");
            
            switch(cmd[0]) {
                case "I" :
                    Integer n = Integer.parseInt(cmd[1]);
                    maxQ.add(n);
                    minQ.add(n);
                    map.compute(n, (k, v) -> v == null ? 1 : v + 1);
                    break;
                case "D" :
                    switch(cmd[1]) {
                        case "1" :
                            delete(maxQ, map);
                            break;
                        case "-1" :
                            delete(minQ, map);
                            break;
                    }
                    break;
            }
        }
    
        Integer max = get(maxQ, map);
        Integer min = get(minQ, map);
        
        if(max == null && min == null) return new int[]{0, 0};
        return new int[]{max, min};
    }
    
    public void delete(PriorityQueue<Integer> queue, Map<Integer, Integer> map) {
        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (map.containsKey(num)) {
                int count = map.get(num);
                if (count == 1) {
                    map.remove(num);
                } else {
                    map.put(num, count - 1);
                }
                break;
            }
        }
    }
    
    public Integer get(PriorityQueue<Integer> queue, Map<Integer, Integer> map) {
    while (!queue.isEmpty()) {
        int num = queue.peek();
        if (map.containsKey(num)) {
            return num;
        } else {
            queue.poll(); 
        }
    }
    return null;
}

    
}