import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        String[] str = (n+"").split("");
        
        for(String s : str){
            answer += Integer.parseInt(s);
        }

        return answer;
    }
}