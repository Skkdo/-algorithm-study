import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        for(int i = 1; i < phone_book.length; i++) {
            String before = phone_book[i - 1];
            String now = phone_book[i];
            
            if(before.length() < now.length()) {
                if(before.equals(now.substring(0,before.length()))) return false;
            }else {
                if(now.equals(before.substring(0,before.length()))) return false;
            }
        }
        return true;
    }
}