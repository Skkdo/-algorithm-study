import java.util.*;
class Solution {
        static Set<Long> set;
        static Map<Long,Long> map;
    
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        set = new HashSet<Long>();
        map = new HashMap<Long,Long>();
        
        for(int i=0;i<room_number.length;i++){
           Long number = room_number[i];
           answer[i] = logic(number,number);
        }
        return answer;
    }
    
    public static Long logic(Long number,Long start){
        if(check(number)) return number;
        
        Long index = number;
       
        if(map.get(index)==number){
            Long result = logic(number+1,start);
            if(start.equals(number)){
                map.replace(index,result+1);
                map.put(result,start);
            }else{
                map.replace(index,start);
            }        
            return result;
        }else{ 
            Long result =logic(map.get(index),start);
            if(start.equals(number)){
                map.replace(index,result+1);
                map.put(result,start);
            }else{
                map.replace(index,start);
            }
           
            return result;
        }
    }
    
    public static boolean check(Long number){
        if(set.add(number)){
            map.put(number,number);
            return true;
        }
        return false;   
    }
    
}