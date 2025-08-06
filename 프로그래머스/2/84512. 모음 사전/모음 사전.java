import java.util.*;

class Solution {
    List<String> dictionary = new ArrayList<>();
    
    public int solution(String word) {
        String[] alphabet = new String[]{"A","E","I","O","U"};
        DFS("", alphabet);
        Collections.sort(dictionary);
        return dictionary.indexOf(word) + 1;
    }
    
    public void DFS(String string, String[] alphabet) {
        if(string.length() > 5) return;
        if(!string.isEmpty()) dictionary.add(string);
        
        for(int i = 0; i < alphabet.length; i++) {
            DFS(string + alphabet[i], alphabet);
        }
    }
}