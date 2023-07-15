import java.util.*;

class Solution {
    
    String[] words = {"A", "E", "I", "O", "U"};
    Map<String, Integer> order = new HashMap<>();
    int idx = 1;
    
    public int solution(String word) {
        int answer = 0;
        dfs(0, "");
        answer = order.get(word);
        return answer;
    }
    
    public void dfs(int cnt, String word){
        if(cnt == 5){
            return;
        }
        
        for(int i=0; i<5; i++){
            String curWord = word + words[i];
            //stem.out.println(curWord);
            order.put(curWord, idx);
            idx++;
            dfs(cnt+1, curWord);
            
        }
        
        
    }
}