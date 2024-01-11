import java.util.*;

class Solution {
    public String solution(String my_string) {     
        
        String answer = "";
        
        my_string = my_string.toLowerCase(); // 모두 소문자로 치환
        
        String[] str = my_string.split(""); // 정렬하기위한 배열
        
        Arrays.sort(str);
        
        for(String s : str){
            answer += s;
        }
        
        return answer;
    }
}