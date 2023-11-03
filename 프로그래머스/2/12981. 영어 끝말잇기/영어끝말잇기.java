import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        TreeSet<String> ts = new TreeSet<>();
        
        ts.add(words[0]);
        
        for(int i = 1; i < words.length; i++){
            
            
            if(words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1)){
                
                int count = i / n + 1;
                int turn = i % n + 1;
                
                answer[0]  = turn;
                answer[1] = count;
                break;
            }
            
            if(ts.contains(words[i])){
                int count = i / n + 1;
                int turn = i % n + 1;
                
                answer[0]  = turn;
                answer[1] = count;
                break;
            }
            
            ts.add(words[i]);
                
            
        }

        
        
        return answer;
    }
}