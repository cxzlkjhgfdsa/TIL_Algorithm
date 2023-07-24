import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int size = citations.length;
        
        
        for(int h = 1; h<=10000; h++){
            int cnt = 0;
            int uCnt = 0;
            for(int k : citations){
                if(k>=h){
                    cnt++;
                }else{
                    uCnt++;
                }
            }
            if(cnt >= h){
                if(uCnt <= h)
                    answer = Math.max(h, answer);
            }
        }
        
        return answer;
    }
    
}