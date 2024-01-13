import java.util.*;

class Solution {
    public String solution(String rsp) {
        String answer = "";
        
        Map<Integer, String> map = new HashMap<>();
        map.put(2 , "0");
        map.put(0, "5");
        map.put(5, "2");
        
        for(int i = 0; i < rsp.length(); i++){
            int k = rsp.charAt(i) - '0';
            answer += map.get(k);
            
        }
        
        return answer;
    }
}