import java.util.*;

class Solution {
    public String solution(String my_string) {
        Set<String> set = new TreeSet<>();
        set.add("a");
        set.add("e");
        set.add("i");
        set.add("o");
        set.add("u");
        
        String answer = "";
        
        String[] str = my_string.split("");
        
        for(String next : str){
            if(set.contains(next))
                continue;
            answer+=next;
        }
        
        
        return answer;
    }
}