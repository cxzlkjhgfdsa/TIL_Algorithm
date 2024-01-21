import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int temp = -1;
        for(int n : arr){
            if(n == temp){
                continue;
            }else{
                temp = n;
                list.add(n);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        
        

        return answer;
    }
}