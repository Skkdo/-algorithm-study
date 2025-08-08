import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int start = 0;
        int end = people.length - 1;
        int count = 0;
        while(start <= end) {
            if(people[start] + people[end] <= limit) {
                start++;
                end--;
                count++;
            }else {
                end--;
                count++;
            }
        }
        return count;
    }
}