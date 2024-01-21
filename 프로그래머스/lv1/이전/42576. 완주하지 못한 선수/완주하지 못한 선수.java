import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(String s : participant){
            if(map.get(s)!= null){
                map.put(s, map.get(s)+1);
            }else{
                 map.put(s, 1);
            }           
        }
        for(String s : completion){
            int i = map.get(s);
            if(i == 1){
                map.remove(s);
            }else{
                map.put(s, i-1);
            }
        }
        
        for(String key : map.keySet()){
            answer = key;
            break;
        }
            
        return answer;
    }
}