import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
         List<Integer> list = new ArrayList(works.length);
        for(int element: works){
            list.add(element);
        }
      
        Collections.sort(list,Collections.reverseOrder());
        int x=0;
        int index=0;
        for(int i=0;i<list.size()-1;i++){
            int temp=(list.get(i)-list.get(i+1))*(i+1);
            if(n<x+temp) {
                break;
            }
            x+=temp;
            index=i+1;
        }
        n-=x;
        for(int i=0;i<index;i++){
            list.set(i,list.get(index));
        }


        int j=0;
        int notZero=0;
        while(true){
            if(n==0) break;
            list.set(j, list.get(j)-1);
            n--;

            if(list.get(j)==0){
                if(j==list.size()-1) break;
                notZero = j+1;
                j=notZero;
            }

            if(j==list.size()-1){
                j=notZero;
                continue;
            }
            if(list.get(j)>list.get(j+1)){
                j=notZero;
                continue;
            }
            j++;
        }

        for(int i=0;i<list.size();i++){
            answer += list.get(i)*list.get(i);
        }

        
        
        return answer;
    }
}