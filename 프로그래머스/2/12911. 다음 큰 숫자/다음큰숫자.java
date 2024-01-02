import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String s = Integer.toBinaryString(n);
        
        int oneCount = 0;
        
        for(int i = 0; i <s.length(); i++){
            if(s.charAt(i) == '1')
                oneCount++;
        }
        
        int idx = n + 1;
        
        while(true){
            
            int count = 0;
            
            String str = Integer.toBinaryString(idx);
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == '1')
                    count++;
            }
            
            if(count == oneCount){
                answer = idx;
                break;
            }
            
            idx++;
            
        }
        
        return answer;
    }
}