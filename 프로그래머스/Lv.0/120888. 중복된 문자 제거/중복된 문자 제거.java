import java.util.*;

class Solution {
    public String solution(String my_string) {
        
        Set<String> set = new LinkedHashSet<>();  // 중복을 걸러내고 순서를 기억하기위해 LinkedHashSet 활용
        
        String[] str = my_string.split(""); // 문자열을 문자하나하나로 분리
        
        for(String s : str){  // Set 에 넣어 중복제거
            set.add(s);
        }
        
        String answer = "";
        
        for(String next : set){ // 순서가 기억되기 때문에 그대로 합하기
            answer += next;
        }
    
        return answer;
    }
}