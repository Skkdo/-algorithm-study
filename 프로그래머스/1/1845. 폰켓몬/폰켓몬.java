import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }
        
        int size = set.size();
        int max = nums.length / 2;
        
        return size > max ? max : size;
    }
}