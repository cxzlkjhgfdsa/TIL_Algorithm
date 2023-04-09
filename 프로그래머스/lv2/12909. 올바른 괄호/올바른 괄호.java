import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int a = 0;
        int size = s.length();
        
        for(int i=0; i<size; i++){            
            if(s.charAt(i) == '('){
                a++;
            }else{
                if(a == 0){
                    answer = false;
                    break;
                }
                a--;
                             
            }
            
        }    
        if(a> 0){
            answer = false;
        }
        return answer;
    }
}