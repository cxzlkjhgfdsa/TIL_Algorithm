import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] str = s.split("");
        Map<String, Integer> map = new TreeMap<>();
        
        for(String next : str){
            if(map.get(next) != null){
                map.put(next, map.get(next)+1);
            }else{
                map.put(next, 1);
            }
        }
        
        for(String key : map.keySet()){
            if(map.get(key) == 1)
                answer+=key;
        }
        
        
        
        return answer;
    }
}