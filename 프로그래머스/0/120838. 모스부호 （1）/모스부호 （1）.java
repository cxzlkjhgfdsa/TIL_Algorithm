import java.util.*;

class Solution {
    public String solution(String letter) {
        String answer = "";
        
        String[] mos = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",
                        ".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Map<String, Integer> map = new HashMap<>();
        
        int idx = 97;
        
        for(int i = 0; i < 26; i++){
            map.put(mos[i], idx);
            idx++;
        }
        
        String[] str = letter.split(" ");
        
        for(String s : str){
            int i = map.get(s);
            
            answer += (char)i;
        }
        
        return answer;
    }
}