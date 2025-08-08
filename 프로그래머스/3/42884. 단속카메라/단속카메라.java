import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        int camera_locaiton = routes[0][1];
        int answer = 1;
        
        for(int[] rout : routes) {
            if(rout[0] > camera_locaiton) {
                answer++;
                camera_locaiton = rout[1];
            }
        }
        return answer;
    }
}