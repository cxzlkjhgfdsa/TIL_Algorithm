import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            String category = clothes[i][1];
            if(map.get(category) == null){
                map.put(category, 1);
            }else{
                map.put(category, map.get(category)+1);
            }
        }
        
        int answer = 1;
        
        for(Map.Entry<String, Integer> el : map.entrySet()){
            
            answer *= (el.getValue()+1);
        }               
        
        answer--;
        
        return answer;
    }
}