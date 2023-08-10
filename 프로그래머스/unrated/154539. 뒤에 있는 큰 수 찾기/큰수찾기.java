import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int len = numbers.length;
        int[] answer = new int[len];
        
        stack.add(numbers[len-1]);
        answer[len-1] = -1;
        
        for(int i=len-2; i>=0; i--){
            int cur = numbers[i];
            int bigNum = -1;
            while(!stack.isEmpty()){
                if(stack.peek() > cur){
                    bigNum = stack.peek();
                    stack.add(cur);
                    break;
                }
                stack.pop();
                
            }
            if(bigNum == -1){
                stack.add(cur);
            }
            
            answer[i] = bigNum;
        }
        
        
        return answer;
    }
}