import java.util.*;

class Solution {
    public long solution(String numbers) {
        long answer = 0;
        
        Map<String , Integer> map = new HashMap<>();
        
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        
        String[] str = numbers.split("");
        
        String check = "";
        String ans = "";
            
        for(String next : str){
            check += next;
            if(map.get(check) != null){
                ans += map.get(check)+"";
                check = "";
            }
        }
        
        answer = Long.parseLong(ans);
                
        return answer;
    }
}