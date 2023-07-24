import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Map<String, String> map = new HashMap<>();
        for(String s : phone_book){
            map.put(s, s);
        }
        
        for(String s : phone_book){
            int size = s.length();
            for(int i=1; i<size; i++){
                //System.out.println(s.substring(0,i));
                if(map.get(s.substring(0, i)) != null){
                    answer = false;
                    break;
                }
            }
            if(!answer){
                break;
            }
        }
        
        return answer;
    }
}