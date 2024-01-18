import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        Set<Integer> set = new LinkedHashSet<>();
        
        while(n > 1){
            
            for(int i = 2; i <= 10000; i++){
                if(n % i == 0){
                    set.add(i);
                    n /= i;
                    break;
                }
            }
            
        }
        
        int[] answer = new int[set.size()];
        int idx = 0;
        
        for(int next : set){
            answer[idx] = next;
            idx++;
        }
        
        
        return answer;
    }
}