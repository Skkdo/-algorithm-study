import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = Arrays.stream(numbers)
            .mapToObj(i -> String.valueOf(i))
            .toArray(size -> new String[size]);
        
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        
        if(arr[0].equals("0")) return "0";
        return String.join("", arr);
    }
}