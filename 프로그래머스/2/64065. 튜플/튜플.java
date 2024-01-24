import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer;
        
        Map map = new HashMap<Integer, ArrayList>();
        
        int tuple_length =logic(s,map);
       
        ArrayList result = new ArrayList();
        
        for(int i=1;i<=map.size();i++){
            ArrayList list = (ArrayList)map.get(i);
            for(int j=0;j<list.size();j++){
                 
                if(result.contains(list.get(j))) continue;
                result.add(list.get(j));
            }
        }
        
        answer = new int[tuple_length];
        for(int i=0;i<tuple_length;i++){
            answer[i] = (int)result.get(i);
        }
        
        return answer;
    }
    
    
    static int logic(String s, Map map){
        int length =0;
        int temp=1;
        int num=0;
        
        ArrayList arrayList= new ArrayList();

        for(int i=1;i<s.length()-1;i++){
            if(s.charAt(i)=='{'){
                num = 0;
                arrayList= new ArrayList();
                temp = 1;
                continue;
            }
            if(s.charAt(i)=='}'){

                arrayList.add(num);
                map.put(temp,arrayList);
                if(temp>length) length = temp;
                continue;
            }
            if(s.charAt(i)==','){
                arrayList.add(num);
                num = 0;
                temp++;
                continue;
            }
            num = num*10+s.charAt(i)-'0';

        }
        return length;
    }
    
    
    
    
    
    
}